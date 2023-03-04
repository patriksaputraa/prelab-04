package com.ManipulasiString;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    final Text sceneTitle = new Text("Manipulasi String");
    final Text nama = new Text("72220533 - Patrik Kurniawan Saputra");
    final Label stringLabel = new Label("Tulis String yang akan diproses");
    final Label manipulasiLabel = new Label("Manipulasi yang diinginkan");
    final Label hasilLabel = new Label("Hasil diproses");

    final TextField inputTextField = new TextField();
    final TextField outpuTextField = new TextField();

    final Button btnProcess = new Button("Process");
    final Button btnClose = new Button("Close");
    final ComboBox stringComboBox = new ComboBox<>();
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Manipulasi String");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,5,5,5));

        grid.add(sceneTitle,0,0,2,1);
        grid.add(stringLabel,0,1);
        grid.add(inputTextField,1,1,4,1);
        grid.add(manipulasiLabel,0,2);
        stringComboBox.getItems().addAll(
            "Balik Kalimat", 
            "Menjadi Huruf Kapital", 
            "Menjadi Huruf Kecil"
        );
        sceneTitle.setFont(Font.font("Arial Rounded MT Bold", FontWeight.BOLD,20));
        stringComboBox.setValue("Balik Kalimat");
        grid.add(stringComboBox,1,2);
        grid.add(hasilLabel,0,3);
        grid.add(outpuTextField,1,3,4,1);
        outpuTextField.setMaxWidth(400);
        grid.add(btnProcess,0,4,2,1);
        /*Event Handler btnProcess */
        btnProcess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                String string = inputTextField.getText();
                String output = "";
                if(stringComboBox.getValue().equals("Balik Kalimat")){
                    for(int i=string.length()-1;i>=0;i--){
                        output = output + string.charAt(i);
                    }
                    outpuTextField.setText(output);
                }else if(stringComboBox.getValue().equals("Menjadi Huruf Kecil")){
                    outpuTextField.setText(string.toLowerCase());
                }else if(stringComboBox.getValue().equals("Menjadi Huruf Kapital")){
                    outpuTextField.setText(string.toUpperCase());
                }
            }
        }); 

        grid.add(btnClose,2,4,2,1);
        /*Event Handler btnClose */
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                System.exit(0);
            }
        });
        grid.add(nama,0,5);
        //grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid,500,200);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}