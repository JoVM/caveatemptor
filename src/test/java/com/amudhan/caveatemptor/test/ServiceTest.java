package com.amudhan.caveatemptor.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test
@ContextConfiguration("classpath:configuration/applicationContext-core-test.xml")
public abstract class ServiceTest extends AbstractTestNGSpringContextTests {

}
