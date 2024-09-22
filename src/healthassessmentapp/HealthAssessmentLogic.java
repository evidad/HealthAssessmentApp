/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthassessmentapp;

/**
 *
 * @author errol
 */
public class HealthAssessmentLogic {

    private String patientName;
    private double bloodPressure;
    private double bodyMassIndex;
    private double cholestoralLDL;
    private double cholestoralHDL;
    private double glucoseBloodSugar;
    private double triglyceride;

    private final String[] bloodPressureComments = {"Very severe", "Severe", "Moderate", "Mild", "Normal", "Low"};
    private final String[] bodyMassIndexComments = {"Underweight", "Normal", "Overweight", "Obese"};
    private final String[] cholesterolLDLComments = {"Very High", "High", "Borderline High", "Optimal"};
    private final String[] cholesterolHDLComments = {"Poor", "Fair", "Good", "Optimal"};
    private final String[] glucoseBloodSugarComments = {"Excellent", "Good", "Marginal", "Poor", "Out of control"};
    private final String[] triglycerideComments = {"Very High", "High", "Borderline High", "Optimal"};

    public HealthAssessmentLogic() {
    }

    ;

    public HealthAssessmentLogic(String patientName, double bloodPressure, double bodyMassIndex, double cholestoralLDL, double cholestoralHDL, double glucoseBloodSugar, double triglyceride) {
        this.patientName = patientName;
        this.bloodPressure = bloodPressure;
        this.bodyMassIndex = bodyMassIndex;
        this.cholestoralLDL = cholestoralLDL;
        this.cholestoralHDL = cholestoralHDL;
        this.glucoseBloodSugar = glucoseBloodSugar;
        this.triglyceride = triglyceride;
    }

    public String getPatientName() {
        return patientName;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public double getBodyMassIndex() {
        return bodyMassIndex;
    }

    public double getCholestoralLDL() {
        return cholestoralLDL;
    }

    public double getCholestoralHDL() {
        return cholestoralHDL;
    }

    public double getGlucoseBloodSugar() {
        return glucoseBloodSugar;
    }

    public double getTriglyceride() {
        return triglyceride;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setBodyMassIndex(double bodyMassIndex) {
        this.bodyMassIndex = bodyMassIndex;
    }

    public void setCholestoralLDL(double cholestoralLDL) {
        this.cholestoralLDL = cholestoralLDL;
    }

    public void setCholestoralHDL(double cholestoralHDL) {
        this.cholestoralHDL = cholestoralHDL;
    }

    public void setGlucoseBloodSugar(double glucoseBloodSugar) {
        this.glucoseBloodSugar = glucoseBloodSugar;
    }

    public void setTriglyceride(double triglyceride) {
        this.triglyceride = triglyceride;
    }

    public String bloodPressureReport() {
        if (this.bloodPressure > 210) {
            return bloodPressureComments[0]; // Very severe
        } else if (this.bloodPressure > 180) {
            return bloodPressureComments[1]; // Severe
        } else if (this.bloodPressure > 160) {
            return bloodPressureComments[2]; // Moderate
        } else if (this.bloodPressure > 140) {
            return bloodPressureComments[3]; // Mild
        } else if (this.bloodPressure > 90) {
            return bloodPressureComments[4]; // Normal
        } else if (this.bloodPressure > 50) {
            return bloodPressureComments[5]; // Low
        } else {
            return "Please enter a valid blood pressure value";
        }
    }

    public String bodyMassIndexReport() {
        if (this.bodyMassIndex < 18.5) {
            return bodyMassIndexComments[0]; // Underweight
        } else if (this.bodyMassIndex >= 18.5 && this.bodyMassIndex <= 24.9) {
            return bodyMassIndexComments[1]; // Normal
        } else if (this.bodyMassIndex >= 25.0 && this.bodyMassIndex <= 29.9) {
            return bodyMassIndexComments[2]; // Overweight
        } else if (this.bodyMassIndex >= 30.0) {
            return bodyMassIndexComments[3]; // Obese
        } else {
            return "Please enter a valid BMI value";
        }
    }

    public String glucoseBloodSugarReport() {
        if (this.glucoseBloodSugar >= 80 && this.glucoseBloodSugar <= 120) {
            return glucoseBloodSugarComments[0]; // Excellent
        } else if (this.glucoseBloodSugar >= 150 && this.glucoseBloodSugar <= 180) {
            return glucoseBloodSugarComments[1]; // Good
        } else if (this.glucoseBloodSugar >= 210 && this.glucoseBloodSugar <= 240) {
            return glucoseBloodSugarComments[2]; // Marginal
        } else if (this.glucoseBloodSugar >= 270 && this.glucoseBloodSugar <= 310) {
            return glucoseBloodSugarComments[3]; // Poor
        } else if (this.glucoseBloodSugar >= 340 && this.glucoseBloodSugar <= 370) {
            return glucoseBloodSugarComments[4]; // Out of control
        } else {
            return "Please enter a valid glucose value";
        }
    }

    public String cholesterolLDLReport() {
        if (this.cholestoralLDL > 160) {
            return cholesterolLDLComments[0]; // Very High
        } else if (this.cholestoralLDL > 130) {
            return cholesterolLDLComments[1]; // High
        } else if (this.cholestoralLDL >= 100) {
            return cholesterolLDLComments[2]; // Borderline High
        } else if (this.cholestoralLDL < 100) {
            return cholesterolLDLComments[3]; // Optimal
        } else {
            return "Please enter a valid LDL cholesterol value";
        }
    }

    public String cholesterolHDLReport() {
        if (this.cholestoralHDL < 40) {
            return cholesterolHDLComments[0]; // Poor
        } else if (this.cholestoralHDL >= 40 && this.cholestoralHDL < 50) {
            return cholesterolHDLComments[1]; // Fair
        } else if (this.cholestoralHDL >= 50 && this.cholestoralHDL < 60) {
            return cholesterolHDLComments[2]; // Good
        } else if (this.cholestoralHDL >= 60) {
            return cholesterolHDLComments[3]; // Optimal
        } else {
            return "Please enter a valid HDL cholesterol value";
        }
    }

    public String triglycerideReport() {
        if (this.triglyceride > 500) {
            return triglycerideComments[0]; // Very High
        } else if (this.triglyceride >= 250 && this.triglyceride <= 499) {
            return triglycerideComments[1]; // High
        } else if (this.triglyceride >= 150 && this.triglyceride <= 249) {
            return triglycerideComments[2]; // Borderline High
        } else if (this.triglyceride < 150) {
            return triglycerideComments[3]; // Optimal
        } else {
            return "Please enter a valid triglyceride value";
        }
    }

    public static void main(String[] args) {
        HealthAssessmentLogic assessment = new HealthAssessmentLogic(
                "John Doe",       // Patient name
                190.0,            // Blood pressure
                26.5,             // Body Mass Index (BMI)
                105.0,            // Cholesterol LDL
                45.0,             // Cholesterol HDL
                160.0,            // Glucose blood sugar
                200.0             // Triglyceride
        );
        
        // Testing the blood pressure report
        System.out.println("Blood Pressure Report: " + assessment.bloodPressureReport());

        // Testing the BMI report
        System.out.println("BMI Report: " + assessment.bodyMassIndexReport());

        // Testing the cholesterol LDL report
        System.out.println("Cholesterol LDL Report: " + assessment.cholesterolLDLReport());

        // Testing the cholesterol HDL report
        System.out.println("Cholesterol HDL Report: " + assessment.cholesterolHDLReport());

        // Testing the glucose blood sugar report
        System.out.println("Glucose Blood Sugar Report: " + assessment.glucoseBloodSugarReport());

        // Testing the triglyceride report
        System.out.println("Triglyceride Report: " + assessment.triglycerideReport());

        // Update some values and test again
        assessment.setPatientName("Jane Smith");
        assessment.setBloodPressure(220);  // Set a value in the "Very severe" range for blood pressure

        // Testing after updating values
        System.out.println("\nUpdated Patient Info:");
        System.out.println("Updated Blood Pressure Report: " + assessment.bloodPressureReport());
    }
}
