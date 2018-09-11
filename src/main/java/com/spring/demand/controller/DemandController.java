package com.spring.demand.controller;

import com.spring.demand.exception.InsertException;
import com.spring.demand.exception.UpdateException;
import com.spring.demand.model.*;
import com.spring.demand.service.DemandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.demand.utils.StringUtils;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@Api(value = "/demand", tags ="Demand API")
@RequestMapping(value = "/demand")
public class DemandController {
    @Autowired
    private DemandService demandService;
    @Autowired
    private DemandRepository repository;
    @ApiOperation(value="添加需求", notes="添加一条需求信息")
    @ApiImplicitParam(name = "demand", value="需求实体Demand", required = true, dataType = "Demand")
    @PostMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
//    public int addDemand(@RequestBody Demand demand){
//        if(StringUtils.isEmpty(demand.getSkill())
//               || StringUtils.isEmpty(demand.getLanguage())
//                || StringUtils.isEmpty((demand.getLocation()))
//                || StringUtils.isNull(demand.getStartTime())
//                || StringUtils.isNull(demand.getEndTime())
//                || StringUtils.isNull(demand.getQuantity())) {
//            throw new InsertException();
//        }
//        demand.setCreatetime(new Timestamp(System.currentTimeMillis()));
//        demand.setUpdatetime(new Timestamp(System.currentTimeMillis()));
//        return demandService.addDemand(demand);
//    }
    public ExecuteDTO save(@RequestBody Demand demand) {
        if (demand.getCreatetime() == null||demand.getUpdatetime()==null) {
            demand.setCreatetime(new Date());
            demand.setUpdatetime(new Date());

        }
        repository.save(demand);
        return new ExecuteDTO(true, "保存成功", demand.getId());
    }
    @ApiOperation(value="查询需求", notes="根据id查询需求信息")
    @ApiImplicitParam(name = "id", value="需求id", required = true, dataType = "String")
    @GetMapping(value = "/get/{id}", produces = {"application/json;charset=UTF-8"})
//    public Demand getDemandByid(@PathVariable("id") int id) {
//        return demandService.getDemandbyId(id);
//    }
    public Demand get(@PathVariable String id) {
        //String iId=String.valueOf(id);
        return repository.findOne(id);
    }

    @ApiOperation(value="更新需求", notes="更新选择的需求信息")
    @ApiImplicitParam(name = "demand", value="需求实体Demand", required = true, dataType = "Demand")
    @PostMapping(value = "/upd", produces = {"application/json;charset=UTF-8"})
    public ExecuteDTO updDemand(@RequestBody Demand demand){
        Demand demandTmp = demandService.getDemandbyId(demand.getId());
        //if (demandTmp == null) throw new UpdateException();
        if (demand.getUpdatetime()==null) {
            demand.setUpdatetime(new Date());
        }

         //demand.setCreatetime(demandTmp.getCreatetime());
//        long parm = demand.getUpdatetime().getTime();
//        long sel = demandTmp.getUpdatetime().getTime();
//        if(parm-sel <= 0){
//            throw new UpdateException();
//        }

        demandService.updateByPrimaryKeySelective(demand);
        //return demandService.updateByPrimaryKeySelective(demand);
        return new ExecuteDTO(true, "删除成功", demand.getId());

        //return new ExecuteDTO(true, "保存成功", demand.getId());
    }

    @ApiOperation(value="需求一览显示", notes="分页显示需求")
    @ApiImplicitParam(name = "params", value = "参数",required = true,dataType = "PageQueryParamDTO")
    //@GetMapping(value = "/find/{pageNum}", produces = {"application/json;charset=UTF-8"})
//    public List<Demand> findDemand(@PathVariable("pageNum") int pageNum){
//        int count = 20;
//        int start = (pageNum - 1) * count;
//        return demandService.findDemand(start, count);
//    }
    @PostMapping(value = "/find", produces = {"application/json;charset=UTF-8"})
    public PageResultDTO loadPage(@RequestBody PageQueryParamDTO params) {
        // 动态查询条件
        Specification<Demand> spec = (root, query, cb) -> {
            if (params.getQuery() != null) {
                // 筛选 会员姓名
                query.where(cb.equal(root.get("id"), params.getQuery().toString()));
            }
            return null;
        };
        Pageable pageable = new PageRequest(params.getPage() - 1, params.getSize());
        Page<Demand> pageResult = repository.findAll(spec, pageable);

        // 返回分页数据
        return new PageResultDTO(pageResult.getTotalElements(), pageResult.getContent());
    }

    @ApiOperation(value="删除需求", notes="根据id物理删除需求")
    @ApiImplicitParam(name = "id", value = "需求id",required = true,dataType = "int")
    @DeleteMapping(value = "/del/{id}",produces = {"application/json;charset=UTF-8"})
//    public int delDemand(@PathVariable("id") int id){
//        return demandService.deleteByPrimaryKey(id);
//    }
    public ExecuteDTO remove(@PathVariable("id")  int id) {
        //int iId=Integer.parseInt(id);
        //String iId=String.valueOf(id);
        demandService.deleteByPrimaryKey(id);
       // repository.delete(iId);
        return new ExecuteDTO(true, "删除成功", id);
    }

//    @ApiOperation(value="模糊查询", notes="多字段模糊查询")
//    @ApiImplicitParam(name = "demand", value="需求实体Demand", required = true, dataType = "Demand")
//    @GetMapping(value = "/search", produces = {"application/json;charset=UTF-8"})
//    public List<Demand> searchDemand(Demand demand){
//        return demandService.searchDemand(demand);
//    }
}
