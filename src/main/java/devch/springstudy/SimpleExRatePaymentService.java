package devch.springstudy;

import java.math.BigDecimal;

public class SimpleExRatePaymentService extends PaymentService{
    @Override
    BigDecimal getExRate(String currency) throws Exception {
        if (currency.equals("USD")) return BigDecimal.valueOf(1000);
        throw new IllegalAccessException("지원하지 않는 통화입니다");
    }
}
