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
        Double[] expected1 = {95.0, 80.0, 75.0, 80.0, scoreToAdd};
        Double[] expected2 = {scoreToAdd};

        // When
        student1.addExamScore(scoreToAdd);
        student2.addExamScore(scoreToAdd);

        // Then
        Assert.assertArrayEquals(expected1,student1.getExamScoresArray());
        Assert.assertArrayEquals(expected2,student2.getExamScoresArray());
    }

    @Test
    public void TestSetExamGrade(){

        // Given
        Double[] examScores = {100.0, 80.0, 90.0};
        Student student = new Student("Moe", "Aydin", examScores);
        int examToSet = 2;
        Double scoreToSet = 87.0;
        Double[] expected = {100.0, 87.0, 90.0};

        // When
        student.setExamScore(examToSet, scoreToSet);
        Double[] actual = student.getExamScoresArray();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestAverageExamScores(){

        // Given
        Double[] examScores1 = {85.0, 80.0, 75.0, 85.0};
        Double[] examScores2 = {50.0};
        Student student1 = new Student("Moe", "Aydin", examScores1);
        Student student2 = new Student("Moe", "Aydin", examScores2);
        Double expected1 = 81.25;
        Double expected2 = 50.0;

        // When
        Double actual1 = student1.getAverageExamScore();
        Double actual2 = student2.getAverageExamScore();

        // Then
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void TestToString(){

        // Given
        Double[] examScores = {90.0, 80.0};
        Student student = new Student("Moe", "Aydin", examScores);
        String expected = "Student Name: Moe Aydin\n> Average Score: 85.0\n> Exam Scores: \n  Exam 1 -> 90.0\n  Exam 2 -> 80.0";

        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

}