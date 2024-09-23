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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            // Get the file name from the fileNameTextField
            String fileName = fileNameTextField.getText();

            if (fileName == null || fileName.isEmpty()) {
                System.out.println("Please enter a valid file name.");
                return;
            }

            if (!fileName.endsWith(".xml")) {
                fileName += ".xml";
            }

            // Load the XML file
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            XmlMapper xmlMapper = new XmlMapper();
            HealthAssessmentReport report = xmlMapper.readValue(file, HealthAssessmentReport.class);

            // Populate the GUI fields with the loaded data
            patientNameTextField.setText(report.getPatientName());
            bloodPressureTextField.setText(String.valueOf(report.getBloodPressure()));
            bodyMassIndexTextField.setText(String.valueOf(report.getBodyMassIndex()));
            cholestoralLDLTextField.setText(String.valueOf(report.getCholestoralLDL()));
            cholestoralHDLTextField.setText(String.valueOf(report.getCholestoralHDL()));
            bloodGlucoseLevelTextField.setText(String.valueOf(report.getGlucoseBloodSugar()));
            triglycerideTextField.setText(String.valueOf(report.getTriglyceride()));

            // Populate the comments section
            bloodPressureLabelComment.setText(report.getBloodPressureComment());
            bodyMassIndexLabelComment.setText(report.getBodyMassIndexComment());
            cholestoralLDLLabelComment.setText(report.getCholestoralLDLComment());
            cholesotralHDLLabelComment.setText(report.getCholestoralHDLComment());
            bloodGlucoseLevelComment.setText(report.getGlucoseBloodSugarComment());
            triglycerideLabelComment.setText(report.getTriglycerideComment());

            System.out.println("Report loaded successfully!");

        } catch (Exception e) {
            System.out.println("Error loading the report: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void handleSaveButtonAction(ActionEvent event) {
        try {
            // Get the values from the GUI text fields
            String patientName = patientNameTextField.getText();
            double bloodPressure = Double.parseDouble(bloodPressureTextField.getText());
            double bodyMassIndex = Double.parseDouble(bodyMassIndexTextField.getText());
            double cholestoralLDL = Double.parseDouble(cholestoralLDLTextField.getText());
            double cholestoralHDL = Double.parseDouble(cholestoralHDLTextField.getText());
            double glucoseBloodSugar = Double.parseDouble(bloodGlucoseLevelTextField.getText());
            double triglyceride = Double.parseDouble(triglycerideTextField.getText());

            // Update the assessment object with the new values
            assessment.setBloodPressure(bloodPressure);
            assessment.setBodyMassIndex(bodyMassIndex);
            assessment.setCholestoralLDL(cholestoralLDL);
            assessment.setCholestoralHDL(cholestoralHDL);
            assessment.setGlucoseBloodSugar(glucoseBloodSugar);
            assessment.setTriglyceride(triglyceride);

            // Generate the comments based on the entered values
            String bloodPressureComment = assessment.bloodPressureReport();
            String bodyMassIndexComment = assessment.bodyMassIndexReport();
            String cholestoralLDLComment = assessment.cholesterolLDLReport();
            String cholestoralHDLComment = assessment.cholesterolHDLReport();
            String glucoseBloodSugarComment = assessment.glucoseBloodSugarReport();
            String triglycerideComment = assessment.triglycerideReport();

            // Create the HealthAssessmentReport object with the data and comments
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

            // Choose a file to save the XML (you can allow user input for the file name)
            File file = new File("health_assessment_report.xml");

            // Use Jackson's XmlMapper to write the object to the XML file
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(file, report);

            // Provide feedback to the user
            System.out.println("Report saved successfully!");

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

        // Clear all comment labels
        bloodPressureLabelComment.setText("");
        bodyMassIndexLabelComment.setText("");
        cholestoralLDLLabelComment.setText("");
        cholesotralHDLLabelComment.setText("");
        bloodGlucoseLevelComment.setText("");
        triglycerideLabelComment.setText("");

        // Optionally clear the file name input and report status label
        fileNameTextField.clear();
        reportStatusLabel.setText("");
    }

}
