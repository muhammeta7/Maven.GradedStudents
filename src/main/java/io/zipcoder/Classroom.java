package io.zipcoder;

import java.lang.reflect.Array;
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

    public Double getHighestScore(){
        double result = 0;
        for (int i = 1; i < students.length ; i++) {
            if(students[i-1].getAverageExamScore() > students[i].getAverageExamScore()){
                result = students[i-1].getAverageExamScore();
            }
        }
        return result;
    }

    public Student[] getStudentsByScore(){

        Comparator<Student> compareStudent = Comparator.comparing(Student::getAverageExamScore).reversed().thenComparing(Student::getLastName);
        Student[] sortedStudent = getStudents();
        Arrays.sort(sortedStudent, compareStudent);
        return sortedStudent;

    }

    public TreeMap<String, ArrayList<Student>> getGradebook(){

        // Figure out percentile
        Double a = getHighestScore() * 0.90;
        Double b = getHighestScore() * 0.71;
        Double c = getHighestScore() * 0.50;
        Double d = getHighestScore() * 0.11;

        // Create arrayList for each type of student
        ArrayList<Student> aStudents = new ArrayList<>();
        ArrayList<Student> bStudents = new ArrayList<>();
        ArrayList<Student> cStudents = new ArrayList<>();
        ArrayList<Student> dStudents = new ArrayList<>();
        ArrayList<Student> fStudents = new ArrayList<>();

        for(Student s : students){
            if( s.getAverageExamScore() < d){
                fStudents.add(s);
            } else if(s.getAverageExamScore() >= d && s.getAverageExamScore() < c){
                dStudents.add(s);
            } else if(s.getAverageExamScore() >= c && s.getAverageExamScore() < b){
                cStudents.add(s);
            } else if(s.getAverageExamScore() >= b && s.getAverageExamScore() < a){
                bStudents.add(s);
            } else{
                aStudents.add(s);
            }
        }

        // Insert studentsList into proper Grade
        TreeMap<String, ArrayList<Student>> gradebook = new TreeMap<>();
        gradebook.put("A", aStudents);
        gradebook.put("B", bStudents);
        gradebook.put("C", cStudents);
        gradebook.put("D", dStudents);
        gradebook.put("F", fStudents);

        return gradebook;

    }


}
