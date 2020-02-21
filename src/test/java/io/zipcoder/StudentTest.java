package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {

    @Test
    public void TestStudent(){
        // Given
        String actualFirstName = "Moe";
        String actualLastName ="Aydin";
        Double[] actualExamScores = { 100.0, 95.0, 80.0, 95.0, 85.0 };

        // When
        Student student = new Student(actualFirstName, actualLastName, actualExamScores);
        String expectedFirstName = student.getFirstName();
        String expectedLastName = student.getLastName();
        Double[] expectedExamScores = student.getExamScoresArray();

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertArrayEquals(expectedExamScores, actualExamScores);
    }


    @Test
    public void TestGetExamScores(){
        // Given
        Double[] examScores1 = {95.0, 80.0};
        Double[] examScores2 = {};
        Student student1 = new Student("Moe", "Aydin", examScores1);
        Student student2 = new Student("Moe", "Aydin", examScores2);
        String expected1 = "Exam Scores: \n  Exam 1 -> 95.0\n  Exam 2 -> 80.0";
        String expected2 = "Exam Scores: \n";

        // When
        String actual1 = student1.getExamScores();
        String actual2 = student2.getExamScores();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void TestGetNumberOfExamsTaken(){
        // Given
        Double[] examScores1 = {95.0, 80.0, 75.0, 80.0};
        Double[] examScores2 = {};
        Student student1 = new Student("Moe", "Aydin", examScores1);
        Student student2 = new Student("Moe", "Aydin", examScores2);
        Integer expected1 = 4;
        Integer expected2 = 0;

        // When
        Integer actual1 = student1.getNumberOfExamsTaken();
        Integer actual2 = student2.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, expected2);
    }

    @Test
    public void TestAddExamScoreTest() {
        // Given
        Double[] examScores1 = {95.0, 80.0, 75.0, 80.0};
        Double[] examScores2 = {};
        Student student1 = new Student("Moe", "Aydin", examScores1);
        Student student2 = new Student("Moe", "Aydin", examScores2);
        Double scoreToAdd = 70.0;
        Double expected1 = {95.0, 80.0, 75.0, 80.0, scoreToAdd};
        Double expected2 = {scoreToAdd};

        // When
        Integer actual1 = student1.getNumberOfExamsTaken();
        Integer actual2 = student2.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, expected2);
    }


    /*@Test
    public void addExamScoreTest(){

    }


    @Test
    public void setExamGradeTest(){

    }


    @Test
    public void getAverageExamScoreTest(){

    }

    @Test
    public void toStringTest(){


    }*/



}