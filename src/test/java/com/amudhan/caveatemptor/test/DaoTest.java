package com.amudhan.caveatemptor.test;

import com.amudhan.caveatemptor.utils.RandomAlphaGenerator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * The methods in classes that extend this will be transactional.
 * */
@ContextConfiguration("classpath:configuration/applicationContext-core-test.xml")
@TestExecutionListeners({TransactionalTestExecutionListener.class})
@Transactional
public abstract class DaoTest extends AbstractTestNGSpringContextTests {
    @PersistenceContext
    protected EntityManager entityManager;
    protected RandomAlphaGenerator randomStringGenerator = new RandomAlphaGenerator();
}
