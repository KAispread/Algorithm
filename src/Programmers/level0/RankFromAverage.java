package Programmers.level0;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
* 등수 구하기
* 등수를 구할 때 indexOf 하면 제일 작은 등수가 return 됨
* */
public class RankFromAverage {
    public static void main(String[] args) {

    }

    public int[] solution(int[][] score) {
        List<Student> students = new ArrayList<>();
        List<Double> averages = new ArrayList<>();
        for (int[] mathAndEng : score) {
            Student student = new Student(mathAndEng[0], mathAndEng[1]);
            students.add(student);
            averages.add(student.getAverage());
        }
        averages.sort(Comparator.reverseOrder());

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            double average = student.getAverage();
            int rank = averages.indexOf(average) + 1;
            student.setRank(rank);
        }

        int[] answer = new int[students.size()];
        for (int count = 0; count < students.size(); count++) {
            answer[count] = students.get(count).getRank();
        }
        return answer;
    }

    static class Student {
        private final int math;
        private final int english;
        private double average;
        private int rank;

        public Student(int math, int english) {
            this.math = math;
            this.english = english;
            setAverage(math, english);
        }

        public void setAverage(int math, int english) {
            this.average = ((double) math + (double) english) / 2;
        }

        public double getAverage() {
            return this.average;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getRank() {
            return this.rank;
        }
    }
}
