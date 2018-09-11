package com.spring.demand.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 需求Repository类
 * */
public interface DemandRepository extends JpaRepository<Demand, String>, JpaSpecificationExecutor<Demand> {

}

