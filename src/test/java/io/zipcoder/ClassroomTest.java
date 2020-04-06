package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ClassroomTest {

    @Test
    public void TestClassroomMaxStudentsConstructor(){
        // Given
        Integer maxStudents = 15;

        // When
        Classroom classroom = new Classroom((maxStudents));
        Integer actual = classroom.getStudents().length;

        //Then
        Assert.assertEquals(maxStudents, actual);
    }

    @Test
    public void TestClassroomStudentsConstructor(){
        // Given
        Student[] expected = {new Student("Moe", "Aydin", new Double[]{83.0, 90.0}), new Student("Jack", "Black", new Double[]{90.0, 90.0})};

        // When
        Classroom classroom = new Classroom(expected);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestNullaryConstructor(){
        //Given
        Student[] expected = new Student[30];

        // When
        Classroom classroom = new Classroom();
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestAverageExamScoreTest(){
        // Given
        Double[] scores1 = {100.0, 90.0, 80.0};
        Double[] scores2 = {55.0, 60.0, 65.0};
        Student student1 = new Student("Moe", "Aydin", scores1);
        Student student2 = new Student("Some", "Dude", scores2);
        Student[] students = {student1, student2};
        Classroom classroom = new Classroom();
        Double expected = 75.0;

        // When
        Double actual = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestAddStudent(){
        // Given
        Student[] students = {};
        Classroom classroom = new Classroom(students);
        Double[] examScores = {100.0};
        Student student = new Student("Moe", "Aydin", examScores);
        Student[] expected = {student};

        // When
        classroom.addStudent(student);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestRemoveStudent(){
        // Given
        String firstName = "Moe";
        String lastName = "Aydin";
        Double[] examScores = {100.0};
        Student student = new Student(firstName, lastName, examScores);
        Student student2 = new Student("New", "Student", examScores);
        Student student3 = new Student("Some", "Student", examScores);
        Student[] students = {student, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] expected = {student2, student3, null};

        // When
        classroom.removeStudent("NotUpInHere", "WhosThisGuy");

        // Then
        Assert.assertArrayEquals(students, classroom.getStudents());

        // When
        classroom.removeStudent(firstName, lastName);

        // Then
        Assert.assertArrayEquals(expected, classroom.getStudents());
    }

    @Test
    public void getStudentsByScoreTest(){
        // Given
        Double[] scores1 = {100.0, 80.0};
        Double[] scores2 = {100.0, 100.0};
        Double[] scores3 = {90.0, 90.0};
        Student student1 = new Student("Solid", "Student", scores1);
        Student student2 = new Student("Super", "Nerd", scores2);
        Student student3 = new Student("Consistent", "Guy", scores3);
        Student[] students = {student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] expected = {student2, student3, student1};

        // When
        Student[] actual = classroom.getStudentsByScore();

        // Then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestGetGradebook() {
        Double[] s1Scores = { 100.0, 100.0 };
        Double[] s2Scores = { 85.0, 80.0 };
        Double[] s3Scores = { 68.0, 71.0 };
        Double[] s4Scores = { 49.0, 50.0 };
        Double[] s5Scores = { 0.0, 15.0 };



        Student s1 = new Student("Moe", "As", s1Scores);
        Student s2 = new Student("Moe", "Bs", s2Scores);
        Student s3 = new Student("Girl", "Cs", s3Scores);
        Student s4 = new Student("Guy", "Ds", s4Scores);
        Student s5 = new Student("Person", "Fs", s5Scores);


        Student[] students = {s1,s2,s3,s4,s5};
        Classroom classroom = new Classroom(students);

        // When
        TreeMap<Student,Character> treeMap = classroom.getGradebook();

        // Then
        System.out.println("========================================");
        for(Map.Entry<Student,Character> e : treeMap.entrySet()){
            System.out.println(String.format("     %-13s%s", e.getKey().getFirstName()+" "+e.getKey().getLastName(), e.getValue()));
        }
        System.out.println("========================================");

    }


}

