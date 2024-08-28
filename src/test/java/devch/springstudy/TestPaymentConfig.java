package devch.springstudy;

import devch.springstudy.payment.ExRateProvider;
import devch.springstudy.payment.ExRateProviderStub;
import devch.springstudy.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@Configuration // bean의 관계 설정
//@ComponentScan // component 찾아봐라
public class TestPaymentConfig {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider(), clock()); // exRateProvider()가 OrderService와 똑같은 object로 들어감
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }
    @Bean
    public Clock clock(){
        // 특정 시간으로 고정
        return Clock.fixed(Instant.now(), ZoneId.systemDefault());
    }
}
