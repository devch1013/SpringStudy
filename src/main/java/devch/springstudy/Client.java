package devch.springstudy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactory.class); // object factory를 사용해서 bean factory를 구성해라!
        // ObjectFactory에도 annotation 달아줘야함
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);
        PaymentService paymentService2 = beanFactory.getBean(PaymentService.class);
        System.out.println(paymentService);
        System.out.println(paymentService2);
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
