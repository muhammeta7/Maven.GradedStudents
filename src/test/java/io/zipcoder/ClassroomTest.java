package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        // Given
        Double[] d1 = {100.0};
        Double[] d3 = {80.0};
        Double[] d4 = {70.0};
        Double[] d5 = {60.0};
        Double[] d6 = {50.0};
        Double[] d7 = {20.0};
        Student s1 = new Student("Moe", "A", d1);
        Student s3 = new Student("Not", "Bad", d3);
        Student s4 = new Student("Average", "Guy", d4);
        Student s5 = new Student("Meh", "Eh", d5);
        Student s6 = new Student("Fifty", "Fifty", d6);
        Student s7 = new Student("No", "Show", d7);
        Student[] students = {s7, s6, s5, s3, s4, s1};
        Classroom classroom = new Classroom(students);
        Map<Student, String> expected = new HashMap<>();
        expected.put(s1, "A");
        expected.put(s3, "B");
        expected.put(s4, "C");
        expected.put(s5, "C");
        expected.put(s6, "D");
        expected.put(s7, "D");

        // When
        Map<Student, String> actual = new HashMap<>();
        actual = classroom.getGradebook();

        // Then
        Assert.assertEquals(expected.get(s1), actual.get(s1));
        Assert.assertEquals(expected.get(s3), actual.get(s3));
        Assert.assertEquals(expected.get(s4), actual.get(s4));
        Assert.assertEquals(expected.get(s5), actual.get(s5));
        Assert.assertEquals(expected.get(s6), actual.get(s6));
        Assert.assertEquals(expected.get(s7), actual.get(s7));
    }
}
