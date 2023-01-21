package commuLearning.week2;

import java.util.*;

public class Question1 {
    public String[] solution(String[][] booked, String[][] unbooked) {
        Queue<Register> book = new LinkedList<>();
        Queue<Register> unbook = new LinkedList<>();
        Queue<Register> wait = new PriorityQueue<>((o1, o2) ->
        {
            if (o2.book != o1.book) {
                if (o2.book) {
                    return 1;
                }
                return -1;
            }
            if (o2.isAble(o1.time)) {
                return 1;
            }
            return -1;
        }
        );

        for (String[] b : booked) {
            book.offer(new Register(b[0], b[1], true));
        }
        for (String[] u : unbooked) {
            unbook.offer(new Register(u[0], u[1], false));
        }

        wait.offer(pollEarly(book, unbook));

        List<String> answer = new ArrayList<>();
        String time = wait.peek().time;

        while (!wait.isEmpty()) {
            Register r = wait.poll();
            answer.add(r.name);
            time = runTime(time);

            while (!book.isEmpty() && book.peek().isAble(time)) {
                wait.offer(book.poll());
            }

            while (!unbook.isEmpty() && unbook.peek().isAble(time)) {
                wait.offer(unbook.poll());
            }

            if (wait.isEmpty()) {
                if (!book.isEmpty() && !unbook.isEmpty()) {
                    r = pollEarly(book, unbook, time);
                } else if (!book.isEmpty()) {
                    r = book.poll();
                } else if (!unbook.isEmpty()) {
                    r = unbook.poll();
                } else {
                    break;
                }
                wait.offer(r);
                time = r.time;
            }
        }

        return answer.toArray(new String[0]);
    }

    private String runTime(String time) {
        String[] t = time.split(":");
        int tt = Integer.parseInt(t[1]);

        StringBuffer sb = new StringBuffer();
        if (tt >= 50) {
            sb.append(Integer.parseInt(t[0]) + 1)
                    .append(":").append(tt + 10 - 60);
        } else {
            sb.append(t[0]).append(":").append(tt + 10);
        }
        return sb.toString();
    }

    private Register pollEarly(Queue<Register> b, Queue<Register> u) {
        Register bt = b.peek();
        String ut = u.peek().time;
        if (bt.isAble(ut)) {
            return b.poll();
        } else {
            return u.poll();
        }
    }

    private Register pollEarly(Queue<Register> b, Queue<Register> u, String time) {
        Register bt = b.peek();
        if (bt.isAble(time)) {
            return b.poll();
        }

        String ut = u.peek().time;
        if (bt.isAble(ut)) {
            return b.poll();
        } else {
            return u.poll();
        }
    }

    static class Register {
        String time;
        String name;
        boolean book;

        public Register(String time, String name, boolean book) {
            this.time = time;
            this.name = name;
            this.book = book;
        }

        public boolean isAble(String cTime) {
            String[] a = time.split(":");
            String[] b = cTime.split(":");
            int at = Integer.parseInt(a[0]);
            int bt = Integer.parseInt(b[0]);

            if (at < bt) {
                return true;
            } else if (at > bt) {
                return false;
            }

            int am = Integer.parseInt(a[1]);
            int bm = Integer.parseInt(b[1]);

            if (am > bm) {
                return false;
            }
            return true;
        }
    }
}
