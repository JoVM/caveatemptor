package com.amudhan.caveatemptor.test.dao;

import com.amudhan.caveatemptor.config.PersistenceJPAConfig;
import com.amudhan.caveatemptor.entity.Name;
import com.amudhan.caveatemptor.entity.User;
import com.amudhan.caveatemptor.repository.UserRepository;
import com.amudhan.caveatemptor.repository.specification.SearchCriteria;
import com.amudhan.caveatemptor.repository.specification.UserSpecification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceJPAConfig.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
@ActiveProfiles("specification")
public class UserSpecificationTest {

    @Autowired
    private UserRepository repository;

    private User userJohn;
    private User userTom;

    @Before
    public void init() {
        userJohn = new User();
        Name name = new Name("John", "Doe");
        userJohn.setName(name);
        userJohn.setUserType(User.UserType.SELLER);
        repository.saveAndFlush(userJohn);

        userTom = new User();
        name = new Name("Tom", "Due");
        userTom.setName(name);
        userTom.setUserType(User.UserType.BUYER);
        repository.saveAndFlush(userTom);

    }

    @Test
    public void givenLast_whenGettingListOfUsers_thenCorrect() {
        UserSpecification spec = new UserSpecification(new SearchCriteria("name", "firstName", ":", "John"));

        List<User> results = repository.findAll(spec);

        spec = new UserSpecification(new SearchCriteria("name", "firstName", ":", "Tom"));

        List<User> results2 = repository.findAll(spec);

        assertThat(userJohn, isIn(results));
        assertThat(userTom, isIn(results2));

        //assertThat(results.get(0).getName().getFirstName(), equalTo("Jon"));
    }

    @Test
    public void givenFirstAndLastName_whenGettingListOfUsers_thenCorrect() {
        UserSpecification spec1 =
                new UserSpecification(new SearchCriteria("name", "firstName", ":", "john"));
        UserSpecification spec2 =
                new UserSpecification(new SearchCriteria("name", "lastName", ":", "doe"));

        List<User> results = repository.findAll(Specifications.where(spec1).and(spec2));

        assertThat(userJohn, isIn(results));
        assertThat(userTom, not(isIn(results)));
    }

    @Test
    public void givenPartialFirst_whenGettingListOfUsers_thenCorrect() {
        UserSpecification spec =
                new UserSpecification(new SearchCriteria("name", "firstName", ":", "jo"));

        List<User> results = repository.findAll(spec);

        assertThat(userJohn, isIn(results));
        assertThat(userTom, not(isIn(results)));
    }

    @Test
    public void givenLastAndAge_whenGettingListOfUsers_thenCorrect() {
        UserSpecification spec1 =
                new UserSpecification(new SearchCriteria("age", "", ">", "25"));
        UserSpecification spec2 =
                new UserSpecification(new SearchCriteria("name", "lastName", ":", "doe"));

        List<User> results =
                repository.findAll(Specifications.where(spec1).and(spec2));

        assertThat(userTom, isIn(results));
        assertThat(userJohn, not(isIn(results)));
    }

}
