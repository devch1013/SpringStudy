package devch.springstudy.learningTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockTest {
    // clock을 사용한 LocalDateTime.now
    @Test
    void clock() throws InterruptedException {
        Clock clock = Clock.systemDefaultZone();
        LocalDateTime dt1 = LocalDateTime.now(clock);
        Thread.sleep(1000);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        Assertions.assertThat(dt2).isAfter(dt1);
    }
    // Test에서 Clock을 고정할 수 있는가
    @Test
    void fixedClock() throws InterruptedException {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

        LocalDateTime dt1 = LocalDateTime.now(clock);
        Thread.sleep(1000);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        Assertions.assertThat(dt2).isAfter(dt1);
    }
}
