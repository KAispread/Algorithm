package Programmers.level0;

public class HateEnglish {
    public static void main(String[] args) {
        solution("onetwothreefourfivesixseveneightnine");
    }

    public static long solution(String numbers) {
        Number[] enumValues = Number.values();
        for (Number num : enumValues) {
            String word = num.getWord();
            String number = String.valueOf(num.getNumber());
            numbers = numbers.replaceAll(word, number);
        }
        return Long.parseLong(numbers);
    }

    enum Number {
        ZERO(0, "zero"),
        ONE(1, "one"),
        TWO(2, "two"),
        THREE(3, "three"),
        FOUR(4, "four"),
        FIVE(5, "five"),
        SIX(6, "six"),
        SEVEN(7, "seven"),
        EIGHT(8, "eight"),
        NINE(9, "nine");

        private final int number;
        private final String word;

        Number (int number, String word) {
            this.number = number;
            this.word = word;
        }

        public int getNumber() {
            return number;
        }

        public String getWord() {
            return word;
        }
    }
}
