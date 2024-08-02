package devch.springstudy;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentService {
    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws Exception {
        WebApiExRateProvider exRateProvider = new WebApiExRateProvider();
        BigDecimal exRate = exRateProvider.getWebExRate(currency);
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }
}
