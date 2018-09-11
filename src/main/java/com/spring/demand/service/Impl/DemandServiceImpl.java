package com.spring.demand.service.Impl;

import com.spring.demand.mapper.DemandMapper;
import com.spring.demand.model.Demand;
import com.spring.demand.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "demandService")
public class DemandServiceImpl implements DemandService {
//
    @Autowired
    private DemandMapper demandMapper;
//
    @Override
    public int deleteByPrimaryKey(Integer id){
        return demandMapper.deleteByPrimaryKey(id);
    }
//
//    @Override
//    public int addDemand(Demand demand){
//        return demandMapper.insert(demand);
//    }
//
   @Override
    public int updateByPrimaryKeySelective(Demand demand){
       return demandMapper.updateByPrimaryKeySelective(demand);
   }
//
//    @Override
//    public List<Demand> findDemand(int start, int count){
//        return demandMapper.findDemand(start, count);
//    }
//
    @Override
    public Demand getDemandbyId(int id) {
        return demandMapper.selectByPrimaryKey(id);
    }
//
//    @Override
//    public List<Demand> searchDemand(Demand demand){ return demandMapper.searchDemand(demand); }
//
//
}
