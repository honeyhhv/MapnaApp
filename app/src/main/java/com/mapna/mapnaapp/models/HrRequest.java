package com.mapna.mapnaapp.models;

/**
 * Created by variani_h on 2/7/2017.
 */

public class HrRequest {
    private String EndDate,EndTime,MissionPlace,MissionSubject
            ,PersonelId,Remarks,ReqDate,ReqType,ReqTypeDesc,
            StartDate,StartTime,StatusDesc,ReqCat,SoaStatus;

    public String getSoaStatus() {
        return SoaStatus;
    }

    public void setSoaStatus(String soaStatus) {
        SoaStatus = soaStatus;
    }

    public HrRequest(String soaStatus, String reqCat, String personelId, String startDate, String startTime, String missionPlace, String missionSubject, String endTime, String statusDesc, String reqTypeDesc, String reqType, String reqDate, String remarks) {
        PersonelId = personelId;
        StartDate = startDate;
        StartTime = startTime;
        MissionPlace = missionPlace;
        MissionSubject = missionSubject;
        EndTime = endTime;
        StatusDesc = statusDesc;
        ReqTypeDesc = reqTypeDesc;
        ReqType = reqType;
        ReqDate = reqDate;
        Remarks = remarks;
        ReqCat=reqCat;
        SoaStatus=soaStatus;

    }

    public HrRequest(String soaStatus, String reqCat , String startDate, String endDate, String reqDate, String reqType, String reqTypeDesc, String statusDesc, String remarks, String personelId) {
        PersonelId = personelId;
        StartDate = startDate;
        EndDate = endDate;
        ReqDate = reqDate;
        ReqType = reqType;
        ReqTypeDesc = reqTypeDesc;
        StatusDesc = statusDesc;
        Remarks = remarks;
        ReqCat=reqCat;
        SoaStatus=soaStatus;
    }

    public HrRequest(String soaStatus,String reqCat, String startDate, String startTime, String statusDesc, String reqTypeDesc, String reqType, String reqDate, String personelId, String remarks, String endTime) {
        StartDate = startDate;
        StartTime = startTime;
        StatusDesc = statusDesc;
        ReqTypeDesc = reqTypeDesc;
        ReqType = reqType;
        ReqDate = reqDate;
        PersonelId = personelId;
        Remarks = remarks;
        EndTime = endTime;
        ReqCat=reqCat;
        SoaStatus=soaStatus;
    }

    public String getReqCat() {
        return ReqCat;
    }

    public void setReqCat(String reqCat) {
        ReqCat = reqCat;
    }

    public String getEndDate() {
        return EndDate;

    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getMissionPlace() {
        return MissionPlace;
    }

    public void setMissionPlace(String missionPlace) {
        MissionPlace = missionPlace;
    }

    public String getMissionSubject() {
        return MissionSubject;
    }

    public void setMissionSubject(String missionSubject) {
        MissionSubject = missionSubject;
    }

    public String getPersonelId() {
        return PersonelId;
    }

    public void setPersonelId(String personelId) {
        PersonelId = personelId;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getReqDate() {
        return ReqDate;
    }

    public void setReqDate(String reqDate) {
        ReqDate = reqDate;
    }

    public String getReqType() {
        return ReqType;
    }

    public void setReqType(String reqType) {
        ReqType = reqType;
    }

    public String getReqTypeDesc() {
        return ReqTypeDesc;
    }

    public void setReqTypeDesc(String reqTypeDesc) {
        ReqTypeDesc = reqTypeDesc;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getStatusDesc() {
        return StatusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        StatusDesc = statusDesc;
    }


}
