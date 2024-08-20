package devch.springstudy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/// 전략 패턴 예시
public class Sort {
    public List<String> sortByLength(List<String> list){
        list.sort((o1, o2) -> o1.length() - o2.length());
        return list;
    }
}
