package Lectures.lesson_3;

import java.lang.System.Logger.Level;
import java.util.Stack;
import javax.swing.*;

import com.apple.eawt.Application;

public class Gui extends Application {
    @Override
    public void start(Stack primaryStage) throws Exception {
        Button button = new Button("Save");

        button.setOnAction((event) -> {
            SaveService saveService = new SaveService();
            try {
                saveService.save();                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATTION, "seved successfully", ButtonType.OK);;
                alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
                alert.showAndWait();
            } catch (SavedException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "seved failed at " + e.getStartDate(), ButtonType.OK);;
                alert.getDialogPane().setStyle("-fx-font-family: 'serif'");
                alert.showAndWait();
                // e.printStackTrace;
            }
        });

        prepareStage(button, primaryStage);

        primaryStage.show();
    }



    public static void main(String[] args) { Application.launch(Gui.class);}
        

    private void prepareStage(Button button, Stage stage) {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefHeight(200);
        vBox.setPrefWidth(300);
        Level testGuiApplication = new Label("File save application");
        VBox innerVbox = new VBox();
        innerVbox.setPrefHeight(60);
        vBox.getChildren().addAll(testGuiApplication, innerVbox, button);
        Scene scene = new Scene(vBox);
    }
        
}