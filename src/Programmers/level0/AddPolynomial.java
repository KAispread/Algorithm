package Programmers.level0;

/*
* 다항식 더하기
* */
public class AddPolynomial {
    public static void main(String[] args) {
        String na = "3 + 1";
        System.out.println(solution(na));
    }

    public static String solution(String polynomial) {
        int xNum = 0;
        int normalNum = 0;
        String poly = polynomial;
        while (poly.contains("+")) {
            int operatorIndex = poly.indexOf("+");
            String number = poly.substring(0, operatorIndex);
            poly = poly.substring(operatorIndex + 1);

            if (containX(number)) {
                if (number.length() == 0) {
                    xNum += 1;
                } else {
                    xNum += getNumber(number);
                }
            } else {
                normalNum += getNumber(number);
            }
        }
        if (containX(poly)) {
            if (poly.length() == 0) {
                xNum += 1;
            } else {
                xNum += getNumber(poly);
            }
        } else {
            normalNum += getNumber(poly);
        }
        StringBuilder builder = new StringBuilder();
        if (xNum == 1) {
            builder.append("x");
        } else if (xNum > 1) {
            builder.append(xNum).append("x");
        }
        if (normalNum > 0 && xNum != 0) {
            builder.append(" + ").append(normalNum);
        } else if (normalNum > 0 && xNum == 0) {
            builder.append(normalNum);
        }
        return builder.toString();
    }

    private static boolean containX(String number) {
        number = number.trim();
        int before = number.length();
        number = number.replace("x", "");
        int after = number.length();
        return before - after > 0;
    }

    private static int getNumber(String number) {
        number = number.trim().replace("x", "");
        if (number.length() == 0) {
            return 1;
        }
        return Integer.parseInt(number);
    }
}
