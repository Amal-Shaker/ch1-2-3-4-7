/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4;


import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class streamm extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception  {
       //  Pane paneTableView =  FXMLLoader.load(getClass().getResource("TableViewPane.fxml")); 
         Pane studentTableView =  FXMLLoader.load(getClass().getResource("studentView.fxml")); 
        // Pane CourseTableView =  FXMLLoader.load(getClass().getResource("CurseView.fxml")); 

         Map<String,Pane> mapPane   = new TreeMap<>();
        mapPane.put("studenttableView", studentTableView);
        Scene scene = new Scene(mapPane.get("studenttableView"));
                primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
