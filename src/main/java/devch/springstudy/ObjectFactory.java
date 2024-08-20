package devch.springstudy;

import devch.springstudy.exrate.CachedExRateProvider;
import devch.springstudy.exrate.ExRateProvider;
import devch.springstudy.exrate.WebApiExRateProvider;
import devch.springstudy.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // bean의 관계 설정
//@ComponentScan // component 찾아봐라
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider()); // exRateProvider()가 OrderService와 똑같은 object로 들어감
    }
@Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
