package com.covidPotar19.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Detail {

    @Id
    private int stateDt;

    private String stateTime;
    private String decideCnt;
    private String clearCnt;
    private String examCnt;
    private String deathCnt;
    private String careCnt;
    private String resutlNegCnt;
    private String accExamCnt;
    private String accExamCompCnt;
    private String accDefRate;
    private String createDt;
    private String updateDt;


    public int getStateDt() {
        return stateDt;
    }

    public void setStateDt(int stateDt) {
        this.stateDt = stateDt;
    }

    public String getStateTime() {
        return stateTime;
    }

    public void setStateTime(String stateTime) {
        this.stateTime = stateTime;
    }

    public String getDecideCnt() {
        return decideCnt;
    }

    public void setDecideCnt(String decideCnt) {
        this.decideCnt = decideCnt;
    }

    public String getClearCnt() {
        return clearCnt;
    }

    public void setClearCnt(String clearCnt) {
        this.clearCnt = clearCnt;
    }

    public String getExamCnt() {
        return examCnt;
    }

    public void setExamCnt(String examCnt) {
        this.examCnt = examCnt;
    }

    public String getDeathCnt() {
        return deathCnt;
    }

    public void setDeathCnt(String deathCnt) {
        this.deathCnt = deathCnt;
    }

    public String getCareCnt() {
        return careCnt;
    }

    public void setCareCnt(String careCnt) {
        this.careCnt = careCnt;
    }

    public String getResutlNegCnt() {
        return resutlNegCnt;
    }

    public void setResutlNegCnt(String resutlNegCnt) {
        this.resutlNegCnt = resutlNegCnt;
    }

    public String getAccExamCnt() {
        return accExamCnt;
    }

    public void setAccExamCnt(String accExamCnt) {
        this.accExamCnt = accExamCnt;
    }

    public String getAccExamCompCnt() {
        return accExamCompCnt;
    }

    public void setAccExamCompCnt(String accExamCompCnt) {
        this.accExamCompCnt = accExamCompCnt;
    }

    public String getAccDefRate() {
        return accDefRate;
    }

    public void setAccDefRate(String accDefRate) {
        this.accDefRate = accDefRate;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public String getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt;
    }
}
