package devch.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // bean의 관계 설정
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new SimpleExRateProvider();
    }
}
