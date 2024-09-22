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

    public HealthAssessmentReport() {
    }

    public HealthAssessmentReport(String patientName, double bloodPressure) {
        this.patientName = patientName;
        this.bloodPressure = bloodPressure;
    }

    @XmlElement
    public String getPatientName() {
        return patientName;
    }

    @XmlElement
    public double getBloodPressure() {
        return bloodPressure;
    }
}
