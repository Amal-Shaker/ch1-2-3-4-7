/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rant
 */
public class StudentApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        student[] studentss = {new ItStudent(111,"amal","a",20,30,35),
            new ItStudent(222,"nour","n",10,23,25),
            new ArtStudent(333,"heba","h",20,7,22),
             new ArtStudent(444,"soso","s",25,10,32), 
        };
         for (student d:studentss){
            System.out.println(d);
        }
       List<student> studentList = Arrays.asList(studentss);
       studentList= studentList.stream().sorted(Comparator.comparing(student :: getGrade)).collect(Collectors.toList());
        System.out.println("sorting------------");
        for (student d:studentList){
            System.out.println(d);
        }
          
          PrintWriter output = new PrintWriter(new File("src/StudentApp/stu.data"));
          for(student n:studentList)
              output.println(n);
          output.close();
          
    }
    
}
