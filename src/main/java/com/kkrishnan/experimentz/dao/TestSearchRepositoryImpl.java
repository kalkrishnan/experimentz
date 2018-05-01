package com.kkrishnan.experimentz.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kkrishnan.experimentz.entities.Measurement;
import com.kkrishnan.experimentz.entities.MeasurementType;
import com.kkrishnan.experimentz.entities.Test;
import com.kkrishnan.experimentz.entities.User;

@Repository
public class TestSearchRepositoryImpl implements TestSearchRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MeasurementRepository measurementRepository;

	@Autowired
	private MeasurementTypeRepository measurementTypeRepository;

	@Override
	public List<Test> findByCriteria(SearchCriteria searchCriteria) {
		CriteriaBuilder criteriaBuilderObj = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> queryObj = criteriaBuilderObj.createQuery();
		Root<Test> from = queryObj.from(Test.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (searchCriteria.getUserName() != null) {
			User user = userRepository.findByUserName(searchCriteria.getUserName());
			predicates.add(criteriaBuilderObj.equal(from.get("user"), user));
		}
		if (searchCriteria.getFormulaId() != null) {
			predicates.add(criteriaBuilderObj.equal(from.get("formulaId"), searchCriteria.getFormulaId()));
		}
		if (searchCriteria.getVersion() != null) {
			predicates.add(criteriaBuilderObj.equal(from.get("version"), searchCriteria.getVersion()));
		}
		if (searchCriteria.getMeasurementName() != null) {
			MeasurementType type = measurementTypeRepository.findByMeasurementName(searchCriteria.getMeasurementName());
			List<Measurement> measurements = measurementRepository.findByType(type);
			Expression<List<Measurement>> measurementExpression = from.join("measurements");
			Predicate measurementPredicate = measurementExpression.in(measurements);
			predicates.add(measurementPredicate);
		}
		queryObj.select(from).where(predicates.toArray(new Predicate[] {}));
		Query query = entityManager.createQuery(queryObj);
		return query.getResultList();
	}

}
