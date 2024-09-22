/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthassessmentapp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author errol
 */

@XmlRootElement(name = "HealthAssessmentReport")
public class HealthAssessmentReport {
    
    private String patientName;
    private double bloodPressure;
    private String bloodPressureReport;
    private double bodyMassIndex;
    private String bodyMassIndexReport;
    private double glucoseBloodSugar;
    private String glucoseBloodSugarReport;
    private double cholestoralLDL;
    private String cholestoralLDLReport;
    private double cholestoralHDL;
    private String cholestoralHDLReport;
    private double triglyceride;
    private String triglycerideReport;

    public HealthAssessmentReport() {}

    public HealthAssessmentReport(String patientName, double bloodPressure, String bloodPressureReport, 
                                  double bodyMassIndex, String bodyMassIndexReport,
                                  double glucoseBloodSugar, String glucoseBloodSugarReport, 
                                  double cholestoralLDL, String cholestoralLDLReport,
                                  double cholestoralHDL, String cholestoralHDLReport, 
                                  double triglyceride, String triglycerideReport) {
        this.patientName = patientName;
        this.bloodPressure = bloodPressure;
        this.bloodPressureReport = bloodPressureReport;
        this.bodyMassIndex = bodyMassIndex;
        this.bodyMassIndexReport = bodyMassIndexReport;
        this.glucoseBloodSugar = glucoseBloodSugar;
        this.glucoseBloodSugarReport = glucoseBloodSugarReport;
        this.cholestoralLDL = cholestoralLDL;
        this.cholestoralLDLReport = cholestoralLDLReport;
        this.cholestoralHDL = cholestoralHDL;
        this.cholestoralHDLReport = cholestoralHDLReport;
        this.triglyceride = triglyceride;
        this.triglycerideReport = triglycerideReport;
    }

    @XmlElement
    public String getPatientName() {
        return patientName;
    }

    @XmlElement
    public double getBloodPressure() {
        return bloodPressure;
    }

    @XmlElement
    public String getBloodPressureReport() {
        return bloodPressureReport;
    }

    @XmlElement
    public double getBodyMassIndex() {
        return bodyMassIndex;
    }

    @XmlElement
    public String getBodyMassIndexReport() {
        return bodyMassIndexReport;
    }

    @XmlElement
    public double getGlucoseBloodSugar() {
        return glucoseBloodSugar;
    }

    @XmlElement
    public String getGlucoseBloodSugarReport() {
        return glucoseBloodSugarReport;
    }

    @XmlElement
    public double getCholestoralLDL() {
        return cholestoralLDL;
    }

    @XmlElement
    public String getCholestoralLDLReport() {
        return cholestoralLDLReport;
    }

    @XmlElement
    public double getCholestoralHDL() {
        return cholestoralHDL;
    }

    @XmlElement
    public String getCholestoralHDLReport() {
        return cholestoralHDLReport;
    }

    @XmlElement
    public double getTriglyceride() {
        return triglyceride;
    }

    @XmlElement
    public String getTriglycerideReport() {
        return triglycerideReport;
    }
}
