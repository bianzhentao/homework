package com.kgc.ssm2020.homework1123.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Standard {
    private Integer id;

    private String stdNum;

    private String zhname;

    private String version;

    private String keys;

    @JSONField(format="yyyy-MM-dd")
    private Date releaseDate;
    @JSONField(format="yyyy-MM-dd")
    private Date implDate;

    private String packagePath;

    public Standard() {
    }

    public Standard(String stdNum, String zhname, String version, String keys, Date releaseDate, Date implDate, String packagePath) {
        this.stdNum = stdNum;
        this.zhname = zhname;
        this.version = version;
        this.keys = keys;
        this.releaseDate = releaseDate;
        this.implDate = implDate;
        this.packagePath = packagePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStdNum() {
        return stdNum;
    }

    public void setStdNum(String stdNum) {
        this.stdNum = stdNum == null ? null : stdNum.trim();
    }

    public String getZhname() {
        return zhname;
    }

    public void setZhname(String zhname) {
        this.zhname = zhname == null ? null : zhname.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys == null ? null : keys.trim();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getImplDate() {
        return implDate;
    }

    public void setImplDate(Date implDate) {
        this.implDate = implDate;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath == null ? null : packagePath.trim();
    }
}