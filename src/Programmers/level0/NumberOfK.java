package Programmers.level0;

public class NumberOfK {
    public static void main(String[] args) {

    }

    public int solution(int i, int j, int k) {
        StringBuilder builder = new StringBuilder();
        for (int count = i; count <= j; count++) {
            String number = String.valueOf(count);
            builder.append(number);
        }
        String totalNumber = builder.toString();
        return totalNumber.length() - totalNumber.replaceAll(String.valueOf(k), "").length();
    }
}
