package com.larrykin.appmanager.models;

import javafx.beans.property.SimpleStringProperty;

public class Details {
    private SimpleStringProperty imei;
    private SimpleStringProperty operatorName;
    private SimpleStringProperty signalQuality;
    private SimpleStringProperty callStatus;
    private SimpleStringProperty dailedNumber;
    private SimpleStringProperty imeiAcd;
    private SimpleStringProperty imeiAsr;
    private SimpleStringProperty remainingMinutes;
    private SimpleStringProperty lastConnected;
    private SimpleStringProperty codec;
    private SimpleStringProperty audioFlow;
    private SimpleStringProperty phoneModel;
    private SimpleStringProperty modemName;
    private SimpleStringProperty audioPort;
    private SimpleStringProperty comPort;
    private SimpleStringProperty responseTime;

    public Details(SimpleStringProperty imei, SimpleStringProperty operatorName, SimpleStringProperty signalQuality, SimpleStringProperty callStatus, SimpleStringProperty dailedNumber, SimpleStringProperty imeiAcd, SimpleStringProperty imeiAsr, SimpleStringProperty remainingMinutes, SimpleStringProperty lastConnected, SimpleStringProperty codec, SimpleStringProperty audioFlow, SimpleStringProperty phoneModel, SimpleStringProperty modemName, SimpleStringProperty audioPort, SimpleStringProperty comPort, SimpleStringProperty responseTime) {
        this.imei = imei;
        this.operatorName = operatorName;
        this.signalQuality = signalQuality;
        this.callStatus = callStatus;
        this.dailedNumber = dailedNumber;
        this.imeiAcd = imeiAcd;
        this.imeiAsr = imeiAsr;
        this.remainingMinutes = remainingMinutes;
        this.lastConnected = lastConnected;
        this.codec = codec;
        this.audioFlow = audioFlow;
        this.phoneModel = phoneModel;
        this.modemName = modemName;
        this.audioPort = audioPort;
        this.comPort = comPort;
        this.responseTime = responseTime;
    }

    public Details() {
        this.imei = new SimpleStringProperty("");
        this.operatorName = new SimpleStringProperty("");
        this.signalQuality = new SimpleStringProperty("");
        this.callStatus = new SimpleStringProperty("");
        this.dailedNumber = new SimpleStringProperty("");
        this.imeiAcd = new SimpleStringProperty("");
        this.imeiAsr = new SimpleStringProperty("");
        this.remainingMinutes = new SimpleStringProperty("");
        this.lastConnected = new SimpleStringProperty("");
        this.codec = new SimpleStringProperty("");
        this.audioFlow = new SimpleStringProperty("");
        this.phoneModel = new SimpleStringProperty("");
        this.modemName = new SimpleStringProperty("");
        this.audioPort = new SimpleStringProperty("");
        this.comPort = new SimpleStringProperty("");
        this.responseTime = new SimpleStringProperty("");
    }

    public String getImei() {
        return imei.get();
    }

    public SimpleStringProperty imeiProperty() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei.set(imei);
    }

    public String getOperatorName() {
        return operatorName.get();
    }

    public SimpleStringProperty operatorNameProperty() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName.set(operatorName);
    }

    public String getSignalQuality() {
        return signalQuality.get();
    }

    public SimpleStringProperty signalQualityProperty() {
        return signalQuality;
    }

    public void setSignalQuality(String signalQuality) {
        this.signalQuality.set(signalQuality);
    }

    public String getCallStatus() {
        return callStatus.get();
    }

    public SimpleStringProperty callStatusProperty() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus.set(callStatus);
    }

    public String getDailedNumber() {
        return dailedNumber.get();
    }

    public SimpleStringProperty dailedNumberProperty() {
        return dailedNumber;
    }

    public void setDailedNumber(String dailedNumber) {
        this.dailedNumber.set(dailedNumber);
    }

    public String getImeiAcd() {
        return imeiAcd.get();
    }

    public SimpleStringProperty imeiAcdProperty() {
        return imeiAcd;
    }

    public void setImeiAcd(String imeiAcd) {
        this.imeiAcd.set(imeiAcd);
    }

    public String getImeiAsr() {
        return imeiAsr.get();
    }

    public SimpleStringProperty imeiAsrProperty() {
        return imeiAsr;
    }

    public void setImeiAsr(String imeiAsr) {
        this.imeiAsr.set(imeiAsr);
    }

    public String getRemainingMinutes() {
        return remainingMinutes.get();
    }

    public SimpleStringProperty remainingMinutesProperty() {
        return remainingMinutes;
    }

    public void setRemainingMinutes(String remainingMinutes) {
        this.remainingMinutes.set(remainingMinutes);
    }

    public String getLastConnected() {
        return lastConnected.get();
    }

    public SimpleStringProperty lastConnectedProperty() {
        return lastConnected;
    }

    public void setLastConnected(String lastConnected) {
        this.lastConnected.set(lastConnected);
    }

    public String getCodec() {
        return codec.get();
    }

    public SimpleStringProperty codecProperty() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec.set(codec);
    }

    public String getAudioFlow() {
        return audioFlow.get();
    }

    public SimpleStringProperty audioFlowProperty() {
        return audioFlow;
    }

    public void setAudioFlow(String audioFlow) {
        this.audioFlow.set(audioFlow);
    }

    public String getPhoneModel() {
        return phoneModel.get();
    }

    public SimpleStringProperty phoneModelProperty() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel.set(phoneModel);
    }

    public String getModemName() {
        return modemName.get();
    }

    public SimpleStringProperty modemNameProperty() {
        return modemName;
    }

    public void setModemName(String modemName) {
        this.modemName.set(modemName);
    }

    public String getAudioPort() {
        return audioPort.get();
    }

    public SimpleStringProperty audioPortProperty() {
        return audioPort;
    }

    public void setAudioPort(String audioPort) {
        this.audioPort.set(audioPort);
    }

    public String getComPort() {
        return comPort.get();
    }

    public SimpleStringProperty comPortProperty() {
        return comPort;
    }

    public void setComPort(String comPort) {
        this.comPort.set(comPort);
    }

    public String getResponseTime() {
        return responseTime.get();
    }

    public SimpleStringProperty responseTimeProperty() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime.set(responseTime);
    }
}
