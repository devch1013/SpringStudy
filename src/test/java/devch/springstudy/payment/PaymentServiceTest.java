package devch.springstudy.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.*;

class PaymentServiceTest {

    Clock clock;
    @BeforeEach
    void beforeEach() {
        this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }

    @Test
    @DisplayName("prepare가 잘 돌아가는지 검증")
    void convertedAmount() throws Exception {
        // 준비
        testAmount(valueOf(500), valueOf(5_000), this.clock);
        testAmount(valueOf(1_000), valueOf(10_000), this.clock);
        testAmount(valueOf(3_000), valueOf(30_000), this.clock);
    }

    @Test
    void validUntil() throws Exception {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(valueOf(1_000)), this.clock);
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        LocalDateTime now = LocalDateTime.now(clock);

        LocalDateTime expectedValidUntil = now.plusMinutes(30);

        Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);

    }

    private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount, Clock clock) throws Exception {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate), clock);
        // 실행
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        // 환율정보 가져오기
        assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
        // 금액계산
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
    }
}