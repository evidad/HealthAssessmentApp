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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

            // Create a File object with the entered file name
            File file = new File(fileName);
            System.out.println("Loading file: " + file.getAbsolutePath());

            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            // DEBUGGING: Use BufferedReader to check file contents
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                System.out.println("File content:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);  // Print each line of the XML file to ensure it's being read correctly
                }
            } catch (IOException e) {
                System.out.println("Error reading the file with BufferedReader: " + e.getMessage());
                e.printStackTrace();
            }

            // Use JAXB to unmarshal (load) the XML data into a HealthAssessmentReport object
            JAXBContext context = JAXBContext.newInstance(HealthAssessmentReport.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            HealthAssessmentReport report = (HealthAssessmentReport) unmarshaller.unmarshal(file);

            // Print the loaded values to the console for debugging
            System.out.println("Patient Name: " + report.getPatientName());
            System.out.println("Blood Pressure: " + report.getBloodPressure());

            // ... Continue populating your GUI with the data as before
        } catch (JAXBException e) {
            System.out.println("Error loading the report (JAXBException): " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void handleSaveButtonAction(ActionEvent event) {
//        try {
//            // Get the values from the GUI text fields
//            String patientName = patientNameTextField.getText();
//            double bloodPressure = Double.parseDouble(bloodPressureTextField.getText());
//            double bodyMassIndex = Double.parseDouble(bodyMassIndexTextField.getText());
//            double glucoseBloodSugar = Double.parseDouble(bloodGlucoseLevelTextField.getText());
//            double cholestoralLDL = Double.parseDouble(cholestoralLDLTextField.getText());
//            double cholestoralHDL = Double.parseDouble(cholestoralHDLTextField.getText());
//            double triglyceride = Double.parseDouble(triglycerideTextField.getText());
//
//            // Update the assessment object with the new values
//            assessment.setBloodPressure(bloodPressure);
//            assessment.setBodyMassIndex(bodyMassIndex);
//            assessment.setGlucoseBloodSugar(glucoseBloodSugar);
//            assessment.setCholestoralLDL(cholestoralLDL);
//            assessment.setCholestoralHDL(cholestoralHDL);
//            assessment.setTriglyceride(triglyceride);
//
//            // Now generate the report using the updated assessment object
//            String bloodPressureReport = assessment.bloodPressureReport();
//            String bodyMassIndexReport = assessment.bodyMassIndexReport();
//            String glucoseBloodSugarReport = assessment.glucoseBloodSugarReport();
//            String cholestoralLDLReport = assessment.cholesterolLDLReport();
//            String cholestoralHDLReport = assessment.cholesterolHDLReport();
//            String triglycerideReport = assessment.triglycerideReport();
//
//            // Create a HealthAssessmentReport object with the captured values
//            HealthAssessmentReport report = new HealthAssessmentReport(
//                    patientName,
//                    bloodPressure, bloodPressureReport,
//                    bodyMassIndex, bodyMassIndexReport,
//                    glucoseBloodSugar, glucoseBloodSugarReport,
//                    cholestoralLDL, cholestoralLDLReport,
//                    cholestoralHDL, cholestoralHDLReport,
//                    triglyceride, triglycerideReport
//            );
//
//            // Choose a file to save the XML
//            File file = new File("health_assessment_report.xml");
//
//            // Save the report to an XML file
//            JAXBHelper.saveReportToXML(report, file);
//
//            // Provide feedback to the user
//            System.out.println("Report saved successfully!");
//
//        } catch (NumberFormatException e) {
//            System.out.println("Please enter valid numeric values for health parameters.");
//        } catch (JAXBException e) {
//            System.out.println("Error saving the report: " + e.getMessage());
//        }
    }
}
