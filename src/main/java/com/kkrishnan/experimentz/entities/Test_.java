package com.kkrishnan.experimentz.entities;

import java.util.Date;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Test.class)
public class Test_ {
	public static volatile SingularAttribute<Test, Integer> id;
	public static volatile SingularAttribute<Test, String> name;
	public static volatile SingularAttribute<Test, String> formulaId;
	public static volatile SingularAttribute<Test, String> version;
	public static volatile SingularAttribute<Test, User> user;
	public static volatile ListAttribute<Test, Measurement> measurements;
	public static volatile SingularAttribute<Test, String> operation;
	public static volatile SingularAttribute<Test, Date> timestamp;
	public static volatile SingularAttribute<Test, Integer> specification;
}
