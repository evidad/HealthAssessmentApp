/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package healthassessmentapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.xml.bind.JAXBException;
import java.io.File;

/**
 *
 * @author errol
 */

public class FXMLDocumentController implements Initializable {

    HealthAssessmentLogic assessment;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assessment = new HealthAssessmentLogic();
    }
    @FXML
    private TextField bloodGlucoseLevelTextField;

    @FXML
    private Button bloodGlucoseLevelButton;

    @FXML
    private Label bloodGlucoseLevelComment;

    @FXML
    private Button bloodPressureButton;

    @FXML
    private Label bloodPressureLabelComment;

    @FXML
    private TextField bloodPressureTextField;

    @FXML
    private Button bodyMassIndexButton;

    @FXML
    private Label bodyMassIndexLabelComment;

    @FXML
    private TextField bodyMassIndexTextField;

    @FXML
    private Label cholesotralHDLLabelComment;

    @FXML
    private Button cholestoralHDLButton;

    @FXML
    private TextField cholestoralHDLTextField;

    @FXML
    private Button cholestoralLDLButton;

    @FXML
    private Label cholestoralLDLLabelComment;

    @FXML
    private TextField cholestoralLDLTextField;

    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Button triglycerideButton;

    @FXML
    private Label triglycerideLabelComment;

    @FXML
    private TextField triglycerideTextField;
    
    @FXML
    private Label reportStatusLabel;

    @FXML
    void handleBloodGlucoseLevelButtonAction(ActionEvent event) {
        try {
            double bloodGlucoseLevel = Double.parseDouble(bloodGlucoseLevelTextField.getText());

            assessment.setGlucoseBloodSugar(bloodGlucoseLevel);

            String bloodGlucoseLevelReport = assessment.glucoseBloodSugarReport();

            bloodGlucoseLevelComment.setText(bloodGlucoseLevelReport);

        } catch (NumberFormatException e) {
            bloodGlucoseLevelComment.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    void handleBloodPressureButtonAction(ActionEvent event) {
        try {
            double bloodPressure = Double.parseDouble(bloodPressureTextField.getText());

            assessment.setBloodPressure(bloodPressure);

            String bloodPressureReport = assessment.bloodPressureReport();

            bloodPressureLabelComment.setText(bloodPressureReport);

        } catch (NumberFormatException e) {
            bloodPressureLabelComment.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    void handleBodyMassIndexButtonAction(ActionEvent event) {
        try {
            double bodyMassIndex = Double.parseDouble(bodyMassIndexTextField.getText());

            assessment.setBodyMassIndex(bodyMassIndex);

            String bodyMassIndexReport = assessment.bodyMassIndexReport();

            bodyMassIndexLabelComment.setText(bodyMassIndexReport);

        } catch (NumberFormatException e) {
            bodyMassIndexLabelComment.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    void handleCholestoralHDLButtonAction(ActionEvent event) {
        try {
            double cholestoralHDL = Double.parseDouble(cholestoralHDLTextField.getText());

            assessment.setCholestoralHDL(cholestoralHDL);

            String cholestoralHDLReport = assessment.cholesterolHDLReport();

            cholesotralHDLLabelComment.setText(cholestoralHDLReport);

        } catch (NumberFormatException e) {
            cholesotralHDLLabelComment.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    void handleCholestoralLDLButtonAction(ActionEvent event) {
        try {
            double cholestoralLDL = Double.parseDouble(cholestoralLDLTextField.getText());

            assessment.setCholestoralLDL(cholestoralLDL);

            String cholestoralLDLReport = assessment.cholesterolLDLReport();

            cholestoralLDLLabelComment.setText(cholestoralLDLReport);

        } catch (NumberFormatException e) {
            cholestoralLDLLabelComment.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    void handleTriglycerideButtonAction(ActionEvent event) {
        try {
            double triglyceride = Double.parseDouble(triglycerideTextField.getText());

            assessment.setTriglyceride(triglyceride);

            String triglycerideReport = assessment.triglycerideReport();

            triglycerideLabelComment.setText(triglycerideReport);

        } catch (NumberFormatException e) {
            triglycerideLabelComment.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    void handleExitButtonAction(ActionEvent event) {
        javafx.application.Platform.exit();
    }

    @FXML
    void handleLoadButtonAction(ActionEvent event) {

    }

    @FXML
    void handleSaveButtonAction(ActionEvent event) {
        try {
            // Prepare the health assessment report object
            HealthAssessmentReport report = new HealthAssessmentReport(
                    patientNameTextField.getText(),
                    assessment.getBloodPressure(),
                    assessment.bloodPressureReport(),
                    assessment.getBodyMassIndex(),
                    assessment.bodyMassIndexReport(),
                    assessment.getGlucoseBloodSugar(),
                    assessment.glucoseBloodSugarReport(),
                    assessment.getCholestoralLDL(),
                    assessment.cholesterolLDLReport(),
                    assessment.getCholestoralHDL(),
                    assessment.cholesterolHDLReport(),
                    assessment.getTriglyceride(),
                    assessment.triglycerideReport()
            );

            // Choose a file to save the XML
            File file = new File("health_assessment_report.xml");

            // Save the report to an XML file
            JAXBHelper.saveReportToXML(report, file);

            // Provide feedback to the user (you can show a label or alert)
            System.out.println("Report saved successfully!");
            
            reportStatusLabel.setText("Report saved sucessfully!");

        } catch (JAXBException e) {
            System.out.println("Error saving the report: " + e.getMessage());
            reportStatusLabel.setText("Error saving the report, please try again!");
        }
    }
    
}
