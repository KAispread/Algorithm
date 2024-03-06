class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        //시간 분 초 를 초로 변환한다.
        int start = toSecond(h1,m1,s1);
        int end = toSecond(h2,m2,s2);
        
        //끝나는 시간까지는 몇번 울리는지 - 시작 시간까지는 몇번울리는지 + 현재 시간에 울리는지
        answer = cal(end) - cal(start) + (alramNow(start)? 1:0); 
        // 현재 시간도 빼버렸기에 현재 시간에 울리는지 확인하고 더해준다.
        															
        
        return answer;
    }
    static int cal(int time){
        int sm = time*59/3600; //분심이 한 바퀴 도는데 초침이랑 59번 겹친다
        					   // 그럼 1번 울리는데 3600/59 초마다 울린다고 볼 수 있다.
                               // 그렇다면 time에 59를 곱하고 3600으로 나눠주면 몇번 울리는지 알 수 있다.
                               // 쉽게 말해서 만약 time == 100 이라면 1초에 59/3600 번 울리는데 
                               // 59 * 100 을 3600으로 나눠주면 5900/3600 = 1.xxxx 이다. 
                               // 즉 1번 울린다는 것!
                               
        int sh = time*719/43200;  // 위와 마찬가지로 시침이 한 바퀴 도는데는 43200초다.
        						 // 60초에 1번 겹치고 60초가 60(분) * 12(시간) 번 겹친다고 볼 수 있다.
                                 // 시침이 한바퀴 도는데 그럼 720-1 = 719 번 겹친다.
                                 // 43200/719 초 마다 겹친다는 것!
        
        
        
        int a = 43200 <= time ? 2 : 1; // 12:00:00 가 몇번 나오는지 계산해서 빼준다. 
        							  // 시침 분침 둘다 더해놨으니 빼야한다.
        							  // 43200 즉 시간이 12시 이상이면 2번 나온다.
                                      // 아니면 1번
                                      
        return sm+sh - a;
    }
    
    static int toSecond(int h,int m,int s){
        int k = h*3600+m*60+s;
        return k;
    }
    static boolean alramNow(int time){
        return time*59%3600==0 || time*719%43200==0; // 현재시간에 알람이 울리는지 체크한다.
    }
}