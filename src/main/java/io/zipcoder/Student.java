package io.zipcoder;

import java.util.ArrayList;

public class Student {

    String firstName;
    String lastName;
    ArrayList<Double> examScores = new ArrayList<>();


    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }


    public Double addExamScore(Double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, Double newScore){
        examScores.set(examNumber-1, newScore);
    }

    public String getExamScores(){
        String scores = "Exam Scores: \n";
        int count = 1;

        for (Double d : examScores) {
            String examReturn = String.format("%1.0f", d);
            scores += "  Exam " + count + " -> "+ examReturn + "\n";
            count++;
        }

        return scores;
    }


    public Double getAverageExamScore(){
        double sum = 0;

        for(double d : examScores){
            sum += d;
        }

        return sum / examScores.size();
    }

    @Override
    public String toString(){
        String output = "Student Name: "+ this.firstName + " " + this.lastName+"\n";
        output += "> Average Score: "+ this.getAverageExamScore() + "\n";
        output += "> "+ this.getExamScores();
        return output;
    }

}
