package com.kkrishnan.experimentz.dao;

import java.util.List;

import com.kkrishnan.experimentz.entities.Test;

public interface TestSearchRepository {

	List<Test> findByCriteria(SearchCriteria searchCriteria);
}
