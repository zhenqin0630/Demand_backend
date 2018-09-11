package com.spring.demand.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "t_demand")
public class Demand {
    @Id
    @GeneratedValue(generator = "identity")
    @GenericGenerator(name = "identity", strategy = "identity")
    @Column(name = "id", length = 11)
    private Integer id;


    @Column(name = "`skill`", length = 20)
    private String skill;


    @Column(name = "`language`", length = 20)
    private String language;


    @Column(name = "`location`", length = 20)
    private String location;

    @Column(name = "`industry`", length = 20)
    private String industry;

    @Column(name = "bandLow", length = 11)
    private Integer bandLow;

    @Column(name = "bandHigh", length = 11)
    private Integer bandHigh;

    @Column(name = "`onsite`", length = 1)
    private Boolean onsite;

    @Column(name = "`parttime`", length = 1)
    private Boolean parttime;


    @Column(name = "quantity", length = 11)
    private Integer quantity;


    @JsonFormat(pattern = "yyyy-mm-dd", timezone = "GMT+8")
    @Temporal(TemporalType.DATE)
    @Column(name = "`startTime`")
    private Date startTime;


    @JsonFormat(pattern = "yyyy-mm-dd", timezone = "GMT+8")
    @Temporal(TemporalType.DATE)
    @Column(name = "`endTime`")
    private Date endTime;

    @Column(name = "status", length = 11)
    private Integer status;

    @Column(name = "`comment`", length = 100)
    private String comment;


    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`createtime`")
    private Date createtime;

    @Column(name = "`updater`", length = 20)
    private String updater;


    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "`updatetime`")
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Integer getBandLow() {
        return bandLow;
    }

    public void setBandLow(Integer bandLow) {
        this.bandLow = bandLow;
    }

    public Integer getBandHigh() {
        return bandHigh;
    }

    public void setBandHigh(Integer bandHigh) {
        this.bandHigh = bandHigh;
    }

    public Boolean getOnsite() {
        return onsite;
    }

    public void setOnsite(Boolean onsite) {
        this.onsite = onsite;
    }

    public Boolean getParttime() {
        return parttime;
    }

    public void setParttime(Boolean parttime) {
        this.parttime = parttime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
