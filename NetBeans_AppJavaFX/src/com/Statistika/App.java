package com.Statistika;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    final Text sceneTitle = new Text("Program Perhitungan Statistik");
    final Text nama = new Text("72220533 - Patrik Kurniawan Saputra");
    final Label inputLabel = new Label("Masukkan Data");
    final Label hasilLabel = new Label("Hasil Perhitungan :");
    final Label semuaLabel = new Label("Semua data");
    final Label banyakLabel = new Label("Banyak data");
    final Label jumlahLabel = new Label("Jumlah");
    final Label rerataLabel = new Label("Rata-Rata");
    final Label minLabel = new Label("Minimum");
    final Label maxLabel = new Label("Maximum");

    final TextField inputField = new TextField();
    final TextField semuaField = new TextField();
    final TextField banyakField = new TextField();
    final TextField jumlahField = new TextField();
    final TextField rerataField = new TextField();
    final TextField minfField = new TextField();
    final TextField maxField = new TextField();

    final Button btnProcess = new Button("Process");
    final Button btnClose = new Button("Close");
    final Button btnDelete = new Button("Delete");
    Statistik input = new Statistik(1);
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Statistik");
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(10,5,5,5));

        grid.add(sceneTitle,0,0,3,1);
        grid.add(inputLabel,0,1);
        grid.add(inputField,1,1,2,1);
        grid.add(btnProcess,3,1);
        grid.add(btnDelete,4,1);
        grid.add(hasilLabel,0,2);
        grid.add(semuaLabel,0,3);
        grid.add(semuaField,1,3,4,1);
        grid.add(banyakLabel,0,4);
        grid.add(banyakField,1,4);
        banyakField.setMaxWidth(60);
        grid.add(jumlahLabel,0,5);
        grid.add(jumlahField,1,5);
        jumlahField.setMaxWidth(60);
        grid.add(minLabel,2,5);
        grid.add(minfField,3,5);
        minfField.setMaxWidth(60);
        grid.add(rerataLabel,0,6);
        grid.add(rerataField,1,6);
        rerataField.setMaxWidth(60);
        grid.add(maxLabel,2,6);
        grid.add(maxField,3,6);
        maxField.setMaxWidth(60);
        grid.add(nama,0,8,2,1);
        grid.add(btnClose,4,8);

        sceneTitle.setFont(Font.font("Arial Rounded MT Bold", FontWeight.BOLD,20));

        /*Event Handler btnProcess */
        btnProcess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                input.addData(Double.parseDouble(inputField.getText()));
                display();
            }
        }); 

        /*Event Handler btnClose */
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                System.exit(0);
            }
        });

        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                input.deleteData();
                display();
            }
        });

        //grid.setGridLinseVisible(true);
        Scene scene = new Scene(grid,500,400);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    void display(){
        semuaField.setText(input.getData());
        banyakField.setText(String.valueOf(input.getCacah()));
        jumlahField.setText(String.valueOf(input.sum()));
        rerataField.setText(String.valueOf(input.average()));
        minfField.setText(String.valueOf(input.minimum()));
        maxField.setText(String.valueOf(input.maximum()));
    }
}