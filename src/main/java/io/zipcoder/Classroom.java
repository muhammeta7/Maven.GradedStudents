package io.zipcoder;

import java.util.*;

public class Classroom {

    private Student[] students;

    public Classroom(Student[] students){
        this.students = students;
    }

    public Classroom(int maxStudents){
        this.students = new Student[maxStudents];
    }

    public Classroom(){
        this.students = new Student[30];
    }

    public Student[] getStudents(){
        return students;
    }

    public Double getAverageExamScore(){

        Double sumAll = 0.0;

        for(Student s : students){
            sumAll += s.getAverageExamScore();
        }

        return sumAll / students.length;

    }

    public void addStudent(Student student){

        Student[] newStudents = new Student[students.length+1];
        int index = 0;

        for (Student s : students){
            newStudents[index] = s;
            index++;
        }

        newStudents[index] = student;
        this.students = newStudents;
    }

    public void removeStudent(String firstName, String lastName){

        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        Student studentToRemove = null;

        for (Student s : studentList){
            if ( s.getLastName().equals(lastName) && s.getFirstName().equals(firstName) ){
                studentToRemove = s;
            }
        }

        if (studentToRemove != null){
            studentList.remove(studentToRemove);
            studentList.add(null);
        }

        students = studentList.toArray(students);

    }

    public Student[] getStudentsByScore(){

        Comparator<Student> compareStudent = Comparator.comparing(Student::getAverageExamScore).reversed().thenComparing(Student::getLastName);
        Student[] sortedStudent = getStudents();
        Arrays.sort(sortedStudent, compareStudent);
        return sortedStudent;

    }

    public Character assignGrade(Double rank){
        Character grade = ' ';
        if(rank/students.length < 0.1){
            grade = 'A';
        } else if(rank/students.length < 0.29){
            grade = 'B';
        }else if(rank/students.length < 0.5){
            grade = 'C';
        }else if(rank/students.length < 0.89){
            grade = 'D';
        }else{
            grade = 'F';
        }

        return grade;
    }



    public TreeMap<Student, Character> getGradebook(){

        TreeMap<Student, Character> gradebook = new TreeMap<>();
        Student[] array = getStudentsByScore();
        Character grade = ' ';

        int counter = 1;
        double tempStudent = array[0].getAverageExamScore();
        gradebook.put(array[0], assignGrade(0.0));

        for (double i = 1; i < students.length; i++) {
            if(tempStudent == array[(int) i].getAverageExamScore()){
                grade = assignGrade(counter - 1.0);
            } else {
                grade = assignGrade(i);
                tempStudent = array[(int) i].getAverageExamScore();
                counter++;
            }
            gradebook.put(array[(int) i], grade);
        }

        return gradebook;

    }


}
