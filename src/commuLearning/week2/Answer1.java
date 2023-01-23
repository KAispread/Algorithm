package commuLearning.week2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Customer {
    final int arrivedAt;
    final String name;

    Customer(String name, String arrivedAt) {
        this.name = name;
        this.arrivedAt = parseTime(arrivedAt);
    }

    private int parseTime(String time) {
        // 시간(String)을 분(Int)으로 변경
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}

public class Answer1{
    public String[] solution(String[][] booked, String[][] unbooked) {
        // Customer 객체로 변환
        Queue<Customer> bookedCustomers = new LinkedList<>();
        for (String[] customer : booked) {
            bookedCustomers.offer(new Customer(customer[1], customer[0]));
        }
        Queue<Customer> unbookedCustomers = new LinkedList<>();
        for (String[] customer : unbooked) {
            unbookedCustomers.offer(new Customer(customer[1], customer[0]));
        }

        List<String> answer = new LinkedList<>();

        // 시간의 시작은 먼저 온 고객의 도착시간
        int currentTime = Math.min(bookedCustomers.peek().arrivedAt, unbookedCustomers.peek().arrivedAt);

        while (!bookedCustomers.isEmpty() || !unbookedCustomers.isEmpty()) {
            if (bookedCustomers.isEmpty()) {
                // 예약된 고객이 없는 경우 예약되지 않은 고객을 모두 추가하고 종료
                for (Customer c : unbookedCustomers) answer.add(c.name);
                break;
            }
            if (unbookedCustomers.isEmpty()) {
                // 예약되지 않은 고객이 없는 경우 예약된 고객을 모두 추가하고 종료
                for (Customer c : bookedCustomers) answer.add(c.name);
                break;
            }

            final Customer bookedCustomer = bookedCustomers.peek();
            final Customer unbookedCustomer = unbookedCustomers.peek();

            if (currentTime >= bookedCustomer.arrivedAt) {
                // 현재시간이 예약된 고객의 도착시간 이후하면 예약 고객을 바로 상담
                answer.add(bookedCustomers.poll().name);
                currentTime += 10; // 다음 평가시간은 상담이 종료되는 10분 후
            } else if (currentTime >= unbookedCustomer.arrivedAt) {
                // 현재시간이 예약되지 않은 고객의 도착시간 이후하면 비예약 고객을 바로 상담
                answer.add(unbookedCustomers.poll().name);
                currentTime += 10; // 다음 평가시간은 상담이 종료되는 10분 후
            } else {
                Customer c;
                // 예약/비예약 고객 중 먼저 온 고객을 상담하고
                if (bookedCustomer.arrivedAt < unbookedCustomer.arrivedAt) {
                    c = bookedCustomers.poll();
                } else {
                    c = unbookedCustomers.poll();
                }
                answer.add(c.name);
                // 다음 평가시간은 고객의 상담이 종료되는 도착시간의 10분 후
                currentTime = c.arrivedAt + 10;
            }
        }

        return answer.toArray(String[]::new);
    }
}
