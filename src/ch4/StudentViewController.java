/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rant
 */
public class StudentViewController implements Initializable {

    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TableView<Student> tableView;
    @FXML 
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    @FXML
    private Button buttonShow;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    Statement statement;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonAddCourse;
    @FXML
    private TextField txtFieldStdID;
    @FXML
    private TextField txtFieldCouID;
    @FXML
    private TextField txtFieldSemesterID;
    @FXML
    private TableView<Student> CourseView;
    @FXML
    private TableColumn<Student, Integer> tcStdID;
    @FXML
    private TableColumn<Student, Integer> tcCouID;
    @FXML
    private TableColumn<Student, String> tcSemester;
    @FXML
    private TextArea textArea;
    @FXML
    private Button buttonShowTextArea;
    @FXML
    private Button buttonShowCourse;
    @FXML
    private Button buttonUpdateText;
  
    /**
     * Initializes the controller class.
     * @param url
     */
    
       
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentdb?serverTimezone=UTC",
                        "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        tcStdID.setCellValueFactory(new PropertyValueFactory("id"));
        tcCouID.setCellValueFactory(new PropertyValueFactory("couID"));
        tcSemester.setCellValueFactory(new PropertyValueFactory("semester"));


         tableView.getSelectionModel().selectedItemProperty().addListener(
            event -> showSelectedStudent() );

    }    

    @FXML
    private void buttonShowHandle(ActionEvent event) throws Exception {
         ResultSet rs = this.statement.executeQuery("Select * From student");
        tableView.getItems().clear();
        while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMajor(rs.getString("major"));
            student.setGrade(rs.getDouble("grade"));
            tableView.getItems().add(student);      
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception {
         Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "insert into student values( "+id+",'"+name+"','"+major+
                "',"+grade+")";
        this.statement.executeUpdate(sql);
    }
    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws Exception {     
           Integer id = Integer.parseInt(txtFieldID.getText());
            String sql = "Delete from student where id = "+id;
            this.statement.executeUpdate(sql);
  }

    @FXML
    private void buttonResetHandle(ActionEvent event) throws Exception {
        
        resetControls();
    }
      private void resetControls(){
        txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldMajor.setText("");
        txtFieldGrade.setText("");
        txtFieldStdID.setText("");
        txtFieldCouID.setText("");
        txtFieldSemesterID.setText("");
        tableView.getItems().clear();
        CourseView.getItems().clear();
        
    }
    
    

    @FXML
    private void buttonEditHandle(ActionEvent event) throws Exception {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Update student Set name = '"+name+"',major = '"+major+"',grade = "+grade
                +"where id = "+id;
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonAddCourseHandle(ActionEvent event) throws Exception {
          Integer stdid = Integer.parseInt(txtFieldStdID.getText());
          Integer couid = Integer.parseInt(txtFieldCouID.getText());
        String semester = txtFieldSemesterID.getText();
        String sql = "insert into registration values( "+stdid+","+couid+",'"+semester+
                "')";
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonShowTextAreaHandle(ActionEvent event) throws Exception {
        String result = textArea.getText();
      ResultSet rs = this.statement.executeQuery(result);
      tableView.getItems().clear();
      while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMajor(rs.getString("major"));
            student.setGrade(rs.getDouble("grade"));
            tableView.getItems().add(student);      
        }        
    }

    @FXML
    private void buttonShowCourseHandle(ActionEvent event) throws Exception {
         ResultSet rs = this.statement.executeQuery("Select * From registration");
        CourseView.getItems().clear();
        while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("studentid"));
            student.setCouID(rs.getInt("courseid"));
            student.setSemester(rs.getString("semester"));
            CourseView.getItems().add(student);      
        }
    }

    @FXML
    private void buttonUpdateTextHandle(ActionEvent event) throws Exception {
        
          String sql = textArea.getText();
         this.statement.executeUpdate(sql);
         
        
        
    }
private void showSelectedStudent(){
        Student student = tableView.getSelectionModel().getSelectedItem();
        if(student != null){
         txtFieldID.setText(String.valueOf(student.getId()));
        txtFieldName.setText(student.getName());
        txtFieldMajor.setText(student.getMajor());
        txtFieldGrade.setText(String.valueOf(student.getGrade()));
    }
}
        
    }

    

