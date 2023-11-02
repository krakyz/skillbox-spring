package com.mod7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> measure_unit;

    @FXML
    private TextField user_input;

    @FXML
    private Label value_g;

    @FXML
    private Label value_kg;

    @FXML
    private Label value_ton;

    private String[] units = {"Тонны", "Килограммы", "Граммы"};

    @FXML
    void initialize() {
        measure_unit.getItems().addAll(units);
        measure_unit.getSelectionModel().select("Тонны");

        user_input.setOnKeyTyped(event -> {
            calculateWeight();
        });

        measure_unit.setOnAction(event -> {
            calculateWeight();
        });
    }


    void calculateWeight() {
        System.out.println(measure_unit.getSelectionModel().getSelectedItem());
        System.out.println(user_input.getText());

        if (measure_unit.getSelectionModel().getSelectedItem() == "Тонны") {
            measure_unit.getSelectionModel().select("Тонны");

            value_ton.setText(user_input.getText());

            double kgOfTons = Double.parseDouble(user_input.getText()) * 1000;
            if (kgOfTons % 1 == 0) {
                value_kg.setText(String.valueOf((int) kgOfTons));
            }

            else {
                value_kg.setText(String.valueOf(kgOfTons));
            }

            double gOfTons = Double.parseDouble(user_input.getText()) * 1000000;
            if (gOfTons % 1 == 0) {
                value_g.setText(String.valueOf((int) gOfTons));
            }

            else {
                value_g.setText(String.valueOf(gOfTons));
            }
        }

        if (measure_unit.getSelectionModel().getSelectedItem() == "Килограммы") {
            measure_unit.getSelectionModel().select("Килограммы");
            value_kg.setText(user_input.getText());

            double tonsOfKg = Double.parseDouble(user_input.getText()) * 0.01;
            if (tonsOfKg % 1 == 0) {
                value_ton.setText(String.valueOf((int) tonsOfKg));
            }

            else {
                value_ton.setText(String.valueOf(tonsOfKg));
            }

            double gOfKg = Double.parseDouble(user_input.getText()) * 1000;
            if (gOfKg % 1 == 0) {
                value_g.setText(String.valueOf((int) gOfKg));
            }

            else {
                value_g.setText(String.valueOf(gOfKg));
            }
        }

        if (measure_unit.getSelectionModel().getSelectedItem() == "Граммы") {
            measure_unit.getSelectionModel().select("Граммы");
            value_g.setText(user_input.getText());

            double tonsOfG = Double.parseDouble(user_input.getText()) * 0.000001;
            if (tonsOfG % 1 == 0) {
                value_ton.setText(String.valueOf((int) tonsOfG));
            }

            else {
                value_ton.setText(String.valueOf(tonsOfG));
            }

            double kgOfG = Double.parseDouble(user_input.getText()) * 0.001;
            if (kgOfG % 1 == 0) {
                value_kg.setText(String.valueOf((int) kgOfG));
            }

            else {
                value_kg.setText(String.valueOf(kgOfG));
            }
        }

//        switch (measure_unit.getSelectionModel().getSelectedItem()) {
//            case "Тонны":
//                System.out.println("t");

//                value_ton.setText(user_input.getText().toString());
//
//                double gOfTons = (Double.parseDouble(user_input.getText()) * 1000000);
//                if (gOfTons % 1 == 0 & gOfTons < Integer.MAX_VALUE) {
//                    value_g.setText(String.valueOf((int) gOfTons));
//                }
//                else {
//                    value_g.setText(String.valueOf(gOfTons));
//                }
//
//                double kgOfTons = (Double.parseDouble(user_input.getText()) * 1000);
//                if (kgOfTons % 1 == 0 & kgOfTons < Integer.MAX_VALUE) {
//                    value_kg.setText(String.valueOf((int) kgOfTons));
//                }
//                else {
//                    value_kg.setText(String.valueOf(kgOfTons));
//                }
//            case "Килограммы":
//                System.out.println("kg");

//                float tonsOfKg = (float) (Float.parseFloat(user_input.getText()) * 0.001);
//                if (tonsOfKg % 1 == 0) {
//                    value_ton.setText(String.valueOf((int) tonsOfKg));
//                }
//                else {
//                    value_ton.setText(String.valueOf(tonsOfKg));
//                }
//
//
//                value_kg.setText(user_input.getText());
//            case "Граммы":
//                System.out.println("g");
//        }
    }

}
