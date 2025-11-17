package com.example.ahnafsadi_cvbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShowCVController {

    @FXML private ImageView profileImageView;
    @FXML private Label nameLabel;
    @FXML private Label phoneLabel;
    @FXML private Label emailLabel;
    @FXML private Label addressLabel;
    @FXML private Label educationLabel;
    @FXML private Label skillsLabel;
    @FXML private Label workLabel;
    @FXML private Label projectsLabel;

    public void initData(CVData data) {
        nameLabel.setText(data.fullName);
        emailLabel.setText(data.email);
        phoneLabel.setText(data.phone);
        addressLabel.setText(data.address);
        educationLabel.setText(toBullets(data.education));
        skillsLabel.setText(toBullets(data.skills));
        workLabel.setText(toBullets(data.experience));
        projectsLabel.setText(toBullets(data.projects));

        if (data.imagePath != null) {
            Image img = new Image(data.imagePath);
            profileImageView.setImage(img);
            profileImageView.setFitWidth(100);
            profileImageView.setFitHeight(100);
            profileImageView.setPreserveRatio(true);
        }
    }

    private String toBullets(String text) {
        if (text == null || text.isEmpty()) return "";
        String[] items = text.split(",");
        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            sb.append("• ").append(item.trim()).append("\n");
        }
        return sb.toString();
    }

    public static class CVData {
        public final String fullName;
        public final String email;
        public final String phone;
        public final String address;
        public final String education;
        public final String skills;
        public final String experience;
        public final String projects;
        public final String imagePath;

        public CVData(
                String fullName,
                String email,
                String phone,
                String address,
                String education,
                String skills,
                String experience,
                String projects,
                String imagePath
        ) {
            this.fullName = fullName;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.education = education;
            this.skills = skills;
            this.experience = experience;
            this.projects = projects;
            this.imagePath = imagePath;
        }
    }
}
