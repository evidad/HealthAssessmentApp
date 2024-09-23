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
import java.io.File;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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
    private TextField fileNameTextField;

    @FXML
    private Button clearButton;

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
        try {
            String fileName = fileNameTextField.getText();

            if (fileName == null || fileName.isEmpty()) {
                System.out.println("Please enter a valid file name.");
                return;
            }

            if (!fileName.endsWith(".xml")) {
                fileName += ".xml";
            }

            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            XmlMapper xmlMapper = new XmlMapper();
            HealthAssessmentReport report = xmlMapper.readValue(file, HealthAssessmentReport.class);

            patientNameTextField.setText(report.getPatientName());
            bloodPressureTextField.setText(String.valueOf(report.getBloodPressure()));
            bodyMassIndexTextField.setText(String.valueOf(report.getBodyMassIndex()));
            cholestoralLDLTextField.setText(String.valueOf(report.getCholestoralLDL()));
            cholestoralHDLTextField.setText(String.valueOf(report.getCholestoralHDL()));
            bloodGlucoseLevelTextField.setText(String.valueOf(report.getGlucoseBloodSugar()));
            triglycerideTextField.setText(String.valueOf(report.getTriglyceride()));

            bloodPressureLabelComment.setText(report.getBloodPressureComment());
            bodyMassIndexLabelComment.setText(report.getBodyMassIndexComment());
            cholestoralLDLLabelComment.setText(report.getCholestoralLDLComment());
            cholesotralHDLLabelComment.setText(report.getCholestoralHDLComment());
            bloodGlucoseLevelComment.setText(report.getGlucoseBloodSugarComment());
            triglycerideLabelComment.setText(report.getTriglycerideComment());


        } catch (Exception e) {
            System.out.println("Error loading the report: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void handleSaveButtonAction(ActionEvent event) {
        try {
            String patientName = patientNameTextField.getText();
            double bloodPressure = Double.parseDouble(bloodPressureTextField.getText());
            double bodyMassIndex = Double.parseDouble(bodyMassIndexTextField.getText());
            double cholestoralLDL = Double.parseDouble(cholestoralLDLTextField.getText());
            double cholestoralHDL = Double.parseDouble(cholestoralHDLTextField.getText());
            double glucoseBloodSugar = Double.parseDouble(bloodGlucoseLevelTextField.getText());
            double triglyceride = Double.parseDouble(triglycerideTextField.getText());

            assessment.setBloodPressure(bloodPressure);
            assessment.setBodyMassIndex(bodyMassIndex);
            assessment.setCholestoralLDL(cholestoralLDL);
            assessment.setCholestoralHDL(cholestoralHDL);
            assessment.setGlucoseBloodSugar(glucoseBloodSugar);
            assessment.setTriglyceride(triglyceride);

            String bloodPressureComment = assessment.bloodPressureReport();
            String bodyMassIndexComment = assessment.bodyMassIndexReport();
            String cholestoralLDLComment = assessment.cholesterolLDLReport();
            String cholestoralHDLComment = assessment.cholesterolHDLReport();
            String glucoseBloodSugarComment = assessment.glucoseBloodSugarReport();
            String triglycerideComment = assessment.triglycerideReport();

            HealthAssessmentReport report = new HealthAssessmentReport();
            report.setPatientName(patientName);
            report.setBloodPressure(bloodPressure);
            report.setBloodPressureComment(bloodPressureComment);
            report.setBodyMassIndex(bodyMassIndex);
            report.setBodyMassIndexComment(bodyMassIndexComment);
            report.setCholestoralLDL(cholestoralLDL);
            report.setCholestoralLDLComment(cholestoralLDLComment);
            report.setCholestoralHDL(cholestoralHDL);
            report.setCholestoralHDLComment(cholestoralHDLComment);
            report.setGlucoseBloodSugar(glucoseBloodSugar);
            report.setGlucoseBloodSugarComment(glucoseBloodSugarComment);
            report.setTriglyceride(triglyceride);
            report.setTriglycerideComment(triglycerideComment);
            
            String fileName = patientName + "_report.xml";
            File file = new File(fileName);

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(file, report);
            
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        } catch (Exception e) {
            System.out.println("Error saving the report: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void handleClearButtonAction(ActionEvent event) {
        patientNameTextField.clear();
        bloodPressureTextField.clear();
        bodyMassIndexTextField.clear();
        cholestoralLDLTextField.clear();
        cholestoralHDLTextField.clear();
        bloodGlucoseLevelTextField.clear();
        triglycerideTextField.clear();

        bloodPressureLabelComment.setText("");
        bodyMassIndexLabelComment.setText("");
        cholestoralLDLLabelComment.setText("");
        cholesotralHDLLabelComment.setText("");
        bloodGlucoseLevelComment.setText("");
        triglycerideLabelComment.setText("");

        fileNameTextField.clear();
        reportStatusLabel.setText("");
    }

}
