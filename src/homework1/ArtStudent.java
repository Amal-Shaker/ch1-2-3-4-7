/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;



/**
 *
 * @author rant
 */
public class ArtStudent extends student{
     public ArtStudent(int id,String name ,String major,double mid,double report,double finall){
         this.id = id;
        this.name = name;
        this.major = major;
  this.grade = mid*0.30 + report*0.30 + finall*40;
}
    
}
