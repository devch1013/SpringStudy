package devch.springstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    Sort sort;
    @BeforeEach // 각 테스트를 실행할 때 준비되는 함수
    void beforeEach(){
        // 준비
        sort = new Sort();
    }
    @Test
    void sort(){
        // 실행
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));
        // 검증
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }
    @Test
    void sort3Items(){
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }
    @Test
    void sortAlreadySorted(){
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }
}
