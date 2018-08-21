package com.amudhan.caveatemptor.repository.specification;

import com.amudhan.caveatemptor.entity.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification implements Specification<User> {

    private SearchCriteria criteria;

    public UserSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
                    root.<String>get(criteria.getKey()).get(criteria.getKey2()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.<String>get(criteria.getKey()).get(criteria.getKey2()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).get(criteria.getKey2()).getJavaType() == String.class) {
                return builder.like(
                        root.<String>get(criteria.getKey()).get(criteria.getKey2()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()).get(criteria.getKey2()), criteria.getValue());
            }
        }
        return null;
    }
}
