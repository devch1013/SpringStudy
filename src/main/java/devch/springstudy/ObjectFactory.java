package devch.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // bean의 관계 설정
//@ComponentScan // component 찾아봐라
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedExRateProvider()); // exRateProvider()가 OrderService와 똑같은 object로 들어감
    }

    @Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }
    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
