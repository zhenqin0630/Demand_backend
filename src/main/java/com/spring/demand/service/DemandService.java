package com.spring.demand.service;

import com.spring.demand.model.Demand;

import java.util.List;


public interface DemandService {
//
//    int addDemand(Demand demand);
//
    int updateByPrimaryKeySelective(Demand demand);
//
//    List<Demand> findDemand(int start, int count);
//
    Demand getDemandbyId(int id);
//
    int deleteByPrimaryKey(Integer id);
//
//    List<Demand> searchDemand(Demand demand);
}
