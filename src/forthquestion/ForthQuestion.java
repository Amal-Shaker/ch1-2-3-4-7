/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forthquestion;

import forthquestion.ForthQuestion.comStudent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.nio.file.Files.list;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.Collation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author rant
 */
//forth question in chapter 2 and third question in ch3 part1 and forth question in ch3 part2

public class ForthQuestion extends Application{  
   
    public void start(Stage primaryStage) throws FileNotFoundException, NoSuchAlgorithmException {
 String password = "123456";
       MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest);    
        File file = new File("src/forthquestion/press.data");
        PrintWriter printt = new PrintWriter(file);
        printt.print("ahamed"+myHash);
        printt.close();
 Button add = new Button("Add Student");
add.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
  Button view = new Button("View Student");
view.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
VBox vbox = new VBox(10,add,view);
vbox.setAlignment(Pos.CENTER);
Scene later = new Scene(vbox,250,250);
vbox.setStyle("-fx-background-color:gray");
GridPane grid = new GridPane();
grid.setVgap(10);
grid.setAlignment(Pos.CENTER);
Label wel = new Label("Welcome");
wel.setFont(Font.font("Tahoma", FontWeight.BOLD, 22));
grid.add(wel, 0, 0);
Label username = new Label("username:");
grid.add(username, 0, 1);
TextField user = new TextField();
grid.add(user,1, 1);
Label pass = new Label("password:");
grid.add(pass, 0, 2);
PasswordField passf = new  PasswordField();
grid.add(passf, 1, 2);
Button logic = new Button("sign in");
grid.add(logic, 1, 3);
logic.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
Button exit = new Button("Exit");
grid.add(exit, 1, 3);
exit.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
GridPane.setHalignment(exit, HPos.RIGHT);
GridPane.setHalignment(logic, HPos.CENTER);
logic.setOnAction(event->{
    primaryStage.setTitle("Options page");
     MessageDigest gd = null;
     try {
         gd = MessageDigest.getInstance("MD5");
     } catch (NoSuchAlgorithmException ex) {
         Logger.getLogger(ForthQuestion.class.getName()).log(Level.SEVERE, null, ex);
     }
        gd.update((passf.getText()).getBytes());
        byte[] digestt = gd.digest();
        String myHashh = DatatypeConverter.printHexBinary(digestt);  
     try {
         Scanner s = new Scanner(file);
         while(s.hasNextLine()){
             String line = s.nextLine();
             String w = (user.getText())+ myHashh;
             if(line.equalsIgnoreCase(w))
                  primaryStage.setScene(later); }
     } catch (FileNotFoundException ex) {
         Logger.getLogger(ForthQuestion.class.getName()).log(Level.SEVERE, null, ex); }});
exit.setOnAction(event->{
    primaryStage.close();
});     
GridPane grid1 = new GridPane();
grid1.setVgap(10);
grid1.setAlignment(Pos.CENTER);
Label adddd = new Label("Student Data");
adddd.setFont(Font.font("Tahoma", FontWeight.BOLD, 22));
grid1.add(adddd, 0, 0);
Label id = new Label("id:");
grid1.add(id, 0, 1);
TextField idd = new TextField();
grid1.add(idd,1,1);
Label name = new Label("Name:");
grid1.add(name, 0, 2);
TextField namee = new TextField();
grid1.add(namee, 1, 2);
Label major = new Label("Major:");
grid1.add(major, 0, 3);
TextField maj = new TextField();
grid1.add(maj, 1, 3);
Label grade = new Label("Grade:");
grid1.add(grade, 0, 4);
TextField gra = new TextField();
grid1.add(gra, 1, 4);
Button ad = new Button("Add");
ad.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
Button reset = new Button("Reset");
reset.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
Button ex = new Button("Exit");
ex.setStyle("-fx-background-color:#006666;-fx-text-fill:white;");
HBox vb = new HBox(10,ad,reset,ex);
vb.setAlignment(Pos.CENTER_RIGHT);
vb.setPadding(new Insets(10, 0, 0, 0));
grid1.add(vb, 1, 5);
ListView kkk = new ListView();
TextArea vieww = new TextArea();
Button show = new Button("view");
VBox vs = new VBox(10,vieww,show);

kkk.setPrefSize(300,300);
HBox hb = new HBox(10,grid1,kkk,vs);
hb.setAlignment(Pos.CENTER);
hb.setPadding(new Insets(80, 0, 80, 0));
 Scene scenee = new Scene(hb, 700, 500);
add.setOnAction(event->{
    primaryStage.setTitle("Student Entry page");
    primaryStage.setScene(scenee);
}); 
List<Student> list = new ArrayList<>();


ad.setOnAction((ActionEvent event)->{
   Student   p = new Student(Integer.valueOf(idd.getText()), namee.getText(), maj.getText(), Double.valueOf(gra.getText()));
  list.add(p);
  Collections.sort(list,new comStudent());
  kkk.getItems().clear();
  kkk.getItems().addAll(list);
});  
show.setOnAction((ActionEvent event)->{
    //4....a
    vieww.appendText("sort by name"+"\n");
  list.stream().sorted(Comparator.comparing(Student::getName))
         .forEach(v -> vieww.appendText(v+"\n"));
  //4...b
   vieww.appendText("sorted by grade"+"\n");
 list.stream()        
         .sorted(Comparator.comparing(Student::getGrade).reversed())
         .map(v->v.getName()+"   "+v.getGrade())
         .forEach(v -> vieww.appendText(v+"\n"));
//4.....c
   vieww.appendText("sorted by grade between 80 and 90"+"\n");
list.stream()
        .sorted(Comparator.comparing(Student::getGrade).reversed())
         .filter(v->v.getGrade()>=80&&v.getGrade()<=90)
         .map(v->v.getName()+"   "+v.getGrade())     
         .forEach(v -> vieww.appendText(v+"\n"));
//4.....d
   vieww.appendText("Average***"+"\n");

     double doubl = list.stream().sorted(Comparator.comparing(Student::getGrade))
             .collect(Collectors.averagingDouble(Student :: getGrade));
        vieww.appendText(doubl+"\n");

//4......e

 vieww.appendText("Grouping***"+"\n");
list.stream().collect(Collectors.groupingBy(Student :: getMajor))
        .forEach((majo,stdMaj) -> {
           vieww.appendText(majo+"\n");
           System.out.println("-------");
           stdMaj.forEach(e-> vieww.appendText(e+"\n"));
           }                
      );

    

});
reset.setOnAction((ActionEvent event)->{

 primaryStage.setScene(later);
});
        Scene scene = new Scene(grid, 300, 250);
         grid.setStyle("-fx-background-color:rgba(120, 120, 120);");
         hb.setStyle("-fx-background-color:rgba(120, 120, 120);");

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();     
    }
    
    
       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    private class Student  {
    private int id;
    private String name;
    private  String major;
    private double grade;
    public Student(){
        
    }
     public Student(String name,double grade){
          this.name = name;
           this.grade = grade;   
    }
       public Student(double grade){
          
           this.grade = grade;   
    }
    public Student(int id, String name,String major,double grade){
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;     
    }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getMajor() {
            return major;
        }
        public void setMajor(String major) {
            this.major = major;
        }
        public double getGrade() {
            return grade;
        }
        public void setGrade(double grade) {
            this.grade = grade;
        }
   
    @Override
       public String toString(){
          /* return String.format("%-10d", this.id)+"     "+String.format("%-10s", this.name)+"     "+
                   String.format("%10s", this.major)+"     "+String.format("%10.2f", this.grade)+"     ";*/
         
            return this.id+"    "+this.name+"    "+this.major+"    "+this.grade;   
       }    
}
class comStudent implements Comparator<Student>{
        @Override
        public int compare(Student t, Student t1) {
              return (int) (t1.getGrade() - t.getGrade());   
        }
    }
}
