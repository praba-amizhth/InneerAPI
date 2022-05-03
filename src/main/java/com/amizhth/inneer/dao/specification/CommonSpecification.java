package com.amizhth.inneer.dao.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.amizhth.inneer.dto.FilterCriteria;

public class CommonSpecification {

	public Predicate getPredicate(FilterCriteria criteria, Root<?> root, CriteriaBuilder builder) {
		Predicate predicate = null;
		if (criteria.getOperation().equalsIgnoreCase(">")) {
			predicate = builder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()),
					criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase("<")) {
			predicate = builder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase(":")) {
			predicate = builder.like(root.<String>get(criteria.getKey()), '%' + criteria.getValue().toString() + '%');
		} else if (criteria.getOperation().equalsIgnoreCase("=")) {
			predicate = builder.equal(root.get(criteria.getKey()), criteria.getValue());
		}
		return predicate;
	}
}
