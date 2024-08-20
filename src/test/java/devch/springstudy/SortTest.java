package devch.springstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    @Test
    void sort(){
        // 준비
        Sort sort = new Sort();
        // 실행
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));
        // 검증
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }
    @Test
    void sort3Items(){
        Sort sort = new Sort();
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }
    @Test
    void sortAlreadySorted(){
        Sort sort = new Sort();
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));
        Assertions.assertThat(list).isEqualTo(List.of("c", "aa", "ccc"));
    }
}
