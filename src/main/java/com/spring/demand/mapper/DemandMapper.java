package com.spring.demand.mapper;

import com.spring.demand.model.Demand;

import java.util.List;


public interface DemandMapper {

    int deleteByPrimaryKey(Integer id);
//
//    int insert(Demand record);
//
//    int insertSelective(Demand demand);
//
    Demand selectByPrimaryKey(Integer id);
//
    int updateByPrimaryKeySelective(Demand demand);
//
//    int updateByPrimaryKey(Demand record);
//
//    List<Demand> findDemand(int start, int count);
//
//    List<Demand> searchDemand(Demand record);
//
}
