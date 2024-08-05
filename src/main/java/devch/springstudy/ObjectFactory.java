package devch.springstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // bean의 관계 설정
@ComponentScan // component 찾아봐라
public class ObjectFactory {
//    @Bean
//    public PaymentService paymentService() {
//        return new PaymentService(exRateProvider());
//    }
//
//    @Bean
//    public ExRateProvider exRateProvider() {
//        return new SimpleExRateProvider();
//    }
}
