package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;


    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores =  new ArrayList<>();
        examScores.addAll(Arrays.asList(testScores));
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


    public void addExamScore(Double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examToSet, Double newScore){
        examScores.set(examToSet-1, newScore);
    }

    public Double[] getExamScoresArray(){
        Double[] scoresArray = new Double[this.examScores.size()];
        int index = 0;
        for(Double d : this.examScores){
            scoresArray[index]= d;
            index++;
        }
        return scoresArray;
    }

    public String getExamScores(){
        String scores = "Exam Scores: \n";
        int count = 1;

        for (int d = 0; d < examScores.size(); d++ ) {
            String examScore = String.format("%.2f", examScores.get(d));
            if(d >= examScores.size()-1) {
                scores += "  Exam " + count + " -> "+ examScore;
            } else {
                scores += "  Exam " + count + " -> "+ examScore + "\n";
            }
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
        output += "> Average Score: "+ String.format("%.2f" ,this.getAverageExamScore()) + "\n";
        output += "> "+ this.getExamScores();
        return output;
    }

}
