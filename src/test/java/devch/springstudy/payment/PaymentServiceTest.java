package devch.springstudy.payment;

import devch.springstudy.exrate.WebApiExRateProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    @DisplayName("prepare가 잘 돌아가는지 검증")
    void prepare() throws Exception {
        // 준비
        PaymentService paymentService = new PaymentService(new WebApiExRateProvider());
        // 실행
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        // 환율정보 가져오기
        assertThat(payment.getExRate()).isNotNull();
        // 금액계산
        assertThat(payment.getConvertedAmount())
                .isEqualTo(
                        payment
                                .getExRate()
                                .multiply(payment.getForeignCurrencyAmount()
                                )
                );
        // 원화환산 금액 유효시간
        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
    }
}