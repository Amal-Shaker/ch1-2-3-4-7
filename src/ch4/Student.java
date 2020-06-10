/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4;

/**
 *
 * @author aashgar
 */
public class Student {
    private Integer id;
    private String name;
    private String major;
    private Double grade;
    private Integer couID;
    private String semester;

    public Student() {
    }   
    public Student(Integer id, String name, String major, Double grade) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }
    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }
    /**
     * @return the grade
     */
    public Double getGrade() {
        return grade;
    }
    /**
     * @param grade the grade to set
     */
    public void setGrade(Double grade) {
        this.grade = grade;
    }
    /**
     * @return the couID
     */
    public Integer getCouID() {
        return couID;
    }
    /**
     * @param couID the couID to set
     */
    public void setCouID(Integer couID) {
        this.couID = couID;
    }
    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }
    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }
      @Override
    public String toString() {
        return String.format("%-5s %-10s %-10s %8.2f %-5s %-10s", id, name, major, grade,couID,semester);
    }
}
