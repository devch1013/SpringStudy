package devch.springstudy;

import devch.springstudy.exrate.ExRateProvider;
import devch.springstudy.exrate.WebApiExRateProvider;
import devch.springstudy.payment.ExRateProviderStub;
import devch.springstudy.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration // bean의 관계 설정
//@ComponentScan // component 찾아봐라
public class TestObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider()); // exRateProvider()가 OrderService와 똑같은 object로 들어감
    }
@Bean
    public ExRateProvider exRateProvider() {
        return new ExRateProviderStub(BigDecimal.valueOf(1_000));
    }
}
