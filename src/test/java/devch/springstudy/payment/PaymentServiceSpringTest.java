package devch.springstudy.payment;

import devch.springstudy.ObjectFactory;
import devch.springstudy.TestObjectFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceSpringTest {

    @Test
    @DisplayName("prepare가 잘 돌아가는지 검증")
    void convertedAmount() throws Exception {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(TestObjectFactory.class); // object factory를 사용해서 bean factory를 구성해라!
        // ObjectFactory에도 annotation 달아줘야함
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        // 실행
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        // 환율정보 가져오기
        assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(1_000));
        // 금액계산
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(valueOf(10_000));
    }

}