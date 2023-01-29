package commuLearning.week3.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Member {
    int visit = -1; // -1 이 아닌것으로 visit 여부 확인
    int groupNumber = -1; // -1 이 아닌 것으로 그룹 확정 확인
}

class Solution {
    static Stack<Integer> stack;
    static int visitDepth;
    static int groupCount;

    public static void main(String[] args) {
        solution(new int[][] {{0}, {8}, {1, 3}, {2}, {1}, {1, 4, 6}, {2, 5}, {3, 6}, {4}});
    }

    public static int solution(int[][] reply) {
        // 변수들 초기화
        visitDepth = 0;
        groupCount = 0;
        stack = new Stack<>();

        Member[] members = new Member[reply.length];

        // graph 구조 - List<Integer>[] node 배열에 List 를 넣는 구조와 동일
        List<List<Integer>> replies = new ArrayList<>();
        for (int i = 0; i < members.length; i++) {
            members[i] = new Member();
            replies.add(new ArrayList<>());
        }

        // 회장(0)은 제외 하고 graph 생성
        // k가 가면 i도 감
        for (int i = 1; i < reply.length; i++) {
            for (int k : reply[i]) {
                replies.get(k).add(i);
            }
        }

        for (int i = 1; i < reply.length; i++) {
            if (members[i].groupNumber == -1) {
                // 그룹이 결정 되지 않은 멤버들 그룹 짓기
                groupingDFS(members, replies, i);
            }
        }

        boolean[] skip = new boolean[groupCount];
        for (int i = 1; i < replies.size(); i++) {
            for (int k : replies.get(i)) {
                if (members[i].groupNumber != members[k].groupNumber) {
                    // 같은 그룹이 아닌데 그래프 연결점이 있는 경우 skip한다.
                    skip[members[k].groupNumber] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < groupCount; i++) {
            if (!skip[i]) {
                answer++; // skip되지 않은 그룹들만 카운트
            }
        }
        return answer;
    }


    private static int groupingDFS(Member[] members, List<List<Integer>> replies, int num) {
        members[num].visit = visitDepth;
        stack.push(num);

        int ret = visitDepth;
        visitDepth += 1;

        for (int k : replies.get(num)) {
            if (members[k].visit == -1) {
                // 방문하지 않았으면 DFS로 연결된 모든 곳을 방문
                ret = Math.min(ret, groupingDFS(members, replies, k)); // 여러 그룹과 연결된 경우 첫번째 그룹을 선택
            }
            if (members[k].groupNumber == -1) {
                // 이미 그룹이 결정된 경우
                ret = Math.min(ret, members[k].visit); // 더 먼저 방문했던 쪽으로 결정
            }
        }

        // 순환루프를 찾은 경우
        if (ret == members[num].visit) {
            while (true) {
                int now = stack.pop();
                // 순환하는 동아리원들에게 같은 그룹값(groupCount)을 갖도록 함
                members[now].groupNumber = groupCount;
                if (now == num) break;
            }
            // 순환그룹 개수 증가
            groupCount++;
        }

        return ret;
    }
}