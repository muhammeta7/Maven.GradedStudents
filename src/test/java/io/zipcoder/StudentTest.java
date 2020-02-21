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



}