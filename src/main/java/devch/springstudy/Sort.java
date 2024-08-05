package devch.springstudy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/// 전략 패턴 예시
public class Sort {
    public static void main(String[] args) {
        List<String> scores = Arrays.asList("z", "x", "spring", "java");
        Collections.sort(scores, (o1, o2) -> o1.length() - o2.length()); // 내부 알고리즘을 외부에서 받아 사용함

        scores.forEach(System.out::println);
    }
}
