/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthassessmentapp;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author errol
 */

public class HealthAssessmentReport {
    @JacksonXmlProperty
    private String patientName;
    
    @JacksonXmlProperty
    private double bloodPressure;
    @JacksonXmlProperty
    private String bloodPressureComment;
    
    @JacksonXmlProperty
    private double bodyMassIndex;
    @JacksonXmlProperty
    private String bodyMassIndexComment;

    @JacksonXmlProperty
    private double cholestoralLDL;
    @JacksonXmlProperty
    private String cholestoralLDLComment;

    @JacksonXmlProperty
    private double cholestoralHDL;
    @JacksonXmlProperty
    private String cholestoralHDLComment;

    @JacksonXmlProperty
    private double glucoseBloodSugar;
    @JacksonXmlProperty
    private String glucoseBloodSugarComment;

    @JacksonXmlProperty
    private double triglyceride;
    @JacksonXmlProperty
    private String triglycerideComment;

    // Getters and setters for all fields
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public double getBloodPressure() {
        return bloodPressure;
    }
    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    public String getBloodPressureComment() {
        return bloodPressureComment;
    }
    public void setBloodPressureComment(String bloodPressureComment) {
        this.bloodPressureComment = bloodPressureComment;
    }

    public double getBodyMassIndex() {
        return bodyMassIndex;
    }
    public void setBodyMassIndex(double bodyMassIndex) {
        this.bodyMassIndex = bodyMassIndex;
    }
    public String getBodyMassIndexComment() {
        return bodyMassIndexComment;
    }
    public void setBodyMassIndexComment(String bodyMassIndexComment) {
        this.bodyMassIndexComment = bodyMassIndexComment;
    }

    public double getCholestoralLDL() {
        return cholestoralLDL;
    }
    public void setCholestoralLDL(double cholestoralLDL) {
        this.cholestoralLDL = cholestoralLDL;
    }
    public String getCholestoralLDLComment() {
        return cholestoralLDLComment;
    }
    public void setCholestoralLDLComment(String cholestoralLDLComment) {
        this.cholestoralLDLComment = cholestoralLDLComment;
    }

    public double getCholestoralHDL() {
        return cholestoralHDL;
    }
    public void setCholestoralHDL(double cholestoralHDL) {
        this.cholestoralHDL = cholestoralHDL;
    }
    public String getCholestoralHDLComment() {
        return cholestoralHDLComment;
    }
    public void setCholestoralHDLComment(String cholestoralHDLComment) {
        this.cholestoralHDLComment = cholestoralHDLComment;
    }

    public double getGlucoseBloodSugar() {
        return glucoseBloodSugar;
    }
    public void setGlucoseBloodSugar(double glucoseBloodSugar) {
        this.glucoseBloodSugar = glucoseBloodSugar;
    }
    public String getGlucoseBloodSugarComment() {
        return glucoseBloodSugarComment;
    }
    public void setGlucoseBloodSugarComment(String glucoseBloodSugarComment) {
        this.glucoseBloodSugarComment = glucoseBloodSugarComment;
    }

    public double getTriglyceride() {
        return triglyceride;
    }
    public void setTriglyceride(double triglyceride) {
        this.triglyceride = triglyceride;
    }
    public String getTriglycerideComment() {
        return triglycerideComment;
    }
    public void setTriglycerideComment(String triglycerideComment) {
        this.triglycerideComment = triglycerideComment;
    }
}

