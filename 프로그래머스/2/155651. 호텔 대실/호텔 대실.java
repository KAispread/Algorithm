import java.util.*;

class Solution {
    Queue<Room> queue;
    
    public int solution(String[][] book_time) {
        queue = new PriorityQueue<>((r1, r2) -> {return r1.end - r2.end;});
        Time[] timeArr = new Time[book_time.length];
        
        for (int i = 0; i < book_time.length; i++) {
            timeArr[i] = new Time(book_time[i]);
        }
        
        Arrays.sort(timeArr, (t1, t2) -> {return t1.start - t2.start;});
        
        // 제일 먼저 온 손님 넣기
        queue.offer(new Room(timeArr[0].end));
        
        for (int i = 1; i < timeArr.length; i++) {
            boolean available = false;
            Time next = timeArr[i];
            
            for (Room r : queue) {
                if (r.isAvailable(next.start, next.end)) {
                    available = true;
                    break;
                }
            }
            
            if (!available) {
                queue.offer(new Room(timeArr[i].end));
            }
        }
        
        return queue.size();
    }
    
    static class Time {
        int start;
        int end;
            
        public Time(String[] time) {
            this.start = convertTime(time[0]);
            this.end = convertTime(time[1]);
        }
        
        public static int convertTime(String time) {
            String[] hourMinute = time.split(":");
            return (Integer.parseInt(hourMinute[0]) * 60) 
                + Integer.parseInt(hourMinute[1]);
        }
    }
    
    static class Room {
        int end;
        
        public Room(int end) {
            this.end = end;
        }
        
        public boolean isAvailable(int start, int endtime) {
            if (start >= this.end + 10) {
                this.end = endtime;
                return true;
            }
            
            return false;
        }
    }
}