package com.amizhth.inneer.dao.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.amizhth.inneer.dto.FilterCriteria;
import com.amizhth.inneer.model.WaterCanModel;

public class WaterCanSpecification extends CommonSpecification implements Specification<WaterCanModel> {

	private List<FilterCriteria> criteriaList;

	private List<FilterCriteria> searchList;

	public WaterCanSpecification(List<FilterCriteria> filterCriterias, List<FilterCriteria> searchCriterias) {
		this.criteriaList = filterCriterias;
		this.searchList = searchCriterias;
	}

	@Override
	public Predicate toPredicate(Root<WaterCanModel> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		Predicate finalPredicate = null;
		Predicate filterPredicate = null;
		Predicate searchPredicate = null;
		List<Predicate> filterPredicateList = new ArrayList<Predicate>();
		List<Predicate> searchPredicateList = new ArrayList<Predicate>();

		for (FilterCriteria filterCriteria : criteriaList) {
			filterPredicateList.add(getPredicate(filterCriteria, root, builder));
		}
		for (FilterCriteria filterCriteria : searchList) {
			searchPredicateList.add(getPredicate(filterCriteria, root, builder));
		}
		
		if (filterPredicateList.size() > 0) {
			filterPredicate = builder.and(filterPredicateList.toArray(new Predicate[filterPredicateList.size()]));
		}
		if (searchPredicateList.size() > 0) {
			searchPredicate = builder.or(searchPredicateList.toArray(new Predicate[searchPredicateList.size()]));
		}

		if (filterPredicate != null && searchPredicate != null) {
			finalPredicate = builder.and(filterPredicate, searchPredicate);
		} else if (filterPredicate != null) {
			finalPredicate = filterPredicate;
		} else if (searchPredicate != null) {
			finalPredicate = searchPredicate;
		}
		return finalPredicate;
	}
}
