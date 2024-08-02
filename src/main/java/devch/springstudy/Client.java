package devch.springstudy;

import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws Exception {
        PaymentService paymentService = new WebApiExRatePaymentService(); // abstract라서 불가능
        Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
