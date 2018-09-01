package com.amudhan.caveatemptor.test;

import com.amudhan.caveatemptor.CaveatEmptorApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ActiveProfiles("specification")
@SpringBootTest(classes = CaveatEmptorApplication.class)
//@Test
@ContextConfiguration("classpath:configuration/applicationContext-core-test.xml")
public abstract class ServiceTest extends AbstractTestNGSpringContextTests {

}
