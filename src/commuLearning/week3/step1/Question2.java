package commuLearning.week3.step1;

/*
* 장식 - 실패
* */
public class Question2 {
    public int solution(int[] bell) {
        int red = 0;
        int green = 0;

        for (int b : bell) {
            if (b == 1) {
                red++;
            } else {
                green++;
            }
        }

        if (red == 0 || green == 0 || bell.length == 1) {
            return 0;
        }

        return Math.max(leftCut(bell, red, green), rightCut(bell, red, green));
    }

    private int leftCut(int[] bell, int red, int green) {
        System.out.println("left Start");
        int left = 0;
        int right = bell.length - 1;

        while (left < right) {
            if (red < green) {
                if (bell[left] == 2) {
                    left++;
                    green--;
                } else if (bell[right] == 2) {
                    right--;
                    green--;
                } else {
                    left++;
                    red--;
                }
            } else if (red > green) {
                if (bell[left] == 1) {
                    left++;
                    red--;
                } else if (bell[right] == 1) {
                    right--;
                    red--;
                } else {
                    left++;
                    green--;
                }
            }

            if (red == green) {
                break;
            }
        }

        return right - left + 1;
    }

    private int rightCut(int[] bell, int red, int green) {
        System.out.println("right Start");
        int left = 0;
        int right = bell.length - 1;

        while (left < right) {
            if (red < green) {
                if (bell[right] == 2) {
                    right--;
                    green--;
                } else if (bell[left] == 2) {
                    left++;
                    green--;
                } else {
                    right--;
                    red--;
                }
            } else if (red > green) {
                if (bell[right] == 1) {
                    right--;
                    red--;
                } else if (bell[left] == 1) {
                    left++;
                    red--;
                } else {
                    right--;
                    green--;
                }
            }

            if (red == green) {
                break;
            }
        }


        return right - left + 1;
    }
}
