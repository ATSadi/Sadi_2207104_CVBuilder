package com.example.ahnafsadi_cvbuilder;



import javafx.event.ActionEvent;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.control.Alert;

import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import javafx.stage.FileChooser;

import javafx.stage.Stage;



import java.io.File;

import java.io.IOException;



public class FormController {



    @FXML private TextField inputName;

    @FXML private TextField inputEmail;

    @FXML private TextField inputNumber;

    @FXML private TextArea inputAdd;

    @FXML private TextArea inputEducation;

    @FXML private TextArea inputSkills;

    @FXML private TextArea inputWork;

    @FXML private TextArea inputProject;

    @FXML private ImageView profileImageView;



    private File selectedImageFile;
    private final CVRepository repository = CVRepository.getInstance();

    @FXML

    void onChooseImage(ActionEvent event) {

        FileChooser chooser = new FileChooser();

        chooser.setTitle("Select Profile Picture");

        chooser.getExtensionFilters().add(

                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")

        );



        Stage stage = (Stage) profileImageView.getScene().getWindow();

        selectedImageFile = chooser.showOpenDialog(stage);



        if (selectedImageFile != null) {

            profileImageView.setImage(new Image(selectedImageFile.toURI().toString()));

        }

    }



    @FXML

    void onBuildCv(ActionEvent event) throws IOException {

        if (inputName.getText().isBlank() || inputEmail.getText().isBlank()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setHeaderText(null);

            alert.setContentText("Please enter at least your name and email.");

            alert.showAndWait();

            return;

        }

        
        String imagePath = selectedImageFile != null ? selectedImageFile.toURI().toString() : null;
        
        // Save to database asynchronously
        repository.insertAsync(
                inputName.getText(),
                inputEmail.getText(),
                inputNumber.getText(),
                inputAdd.getText(),
                inputEducation.getText(),
                inputSkills.getText(),
                inputWork.getText(),
                inputProject.getText(),
                imagePath,
                insertedCV -> {
                    // Success: Show CV preview
                    try {
                        FXMLLoader loader =
                                new FXMLLoader(getClass().getResource("/com/example/ahnafsadi_cvbuilder/showcv.fxml"));
                        Scene scene = new Scene(loader.load());
                        ShowCVController controller = loader.getController();

                        ShowCVController.CVData data = new ShowCVController.CVData(
                                inputName.getText(),
                                inputEmail.getText(),
                                inputNumber.getText(),
                                inputAdd.getText(),
                                inputEducation.getText(),
                                inputSkills.getText(),
                                inputWork.getText(),
                                inputProject.getText(),
                                imagePath
                        );

                        controller.initData(data);

                        Stage stage = (Stage) inputName.getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setContentText("CV created and saved successfully!");
                        alert.showAndWait();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setContentText("Failed to load CV preview: " + e.getMessage());
                        err.showAndWait();
                    }
                },
                error -> {
                    // Error: Still show CV preview but with warning
                    error.printStackTrace();
                    try {
                        FXMLLoader loader =
                                new FXMLLoader(getClass().getResource("/com/example/ahnafsadi_cvbuilder/showcv.fxml"));
                        Scene scene = new Scene(loader.load());
                        ShowCVController controller = loader.getController();

                        ShowCVController.CVData data = new ShowCVController.CVData(
                                inputName.getText(),
                                inputEmail.getText(),
                                inputNumber.getText(),
                                inputAdd.getText(),
                                inputEducation.getText(),
                                inputSkills.getText(),
                                inputWork.getText(),
                                inputProject.getText(),
                                imagePath
                        );

                        controller.initData(data);

                        Stage stage = (Stage) inputName.getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setHeaderText(null);
                        alert.setContentText("CV created but failed to save to database: " + error.getMessage());
                        alert.showAndWait();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Alert err = new Alert(Alert.AlertType.ERROR);
                        err.setContentText("Failed to create CV: " + e.getMessage());
                        err.showAndWait();
                    }
                }
        );

    }

}
