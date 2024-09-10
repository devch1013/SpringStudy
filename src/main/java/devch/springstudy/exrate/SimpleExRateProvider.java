package devch.springstudy.exrate;

import devch.springstudy.payment.ExRateProvider;

import java.math.BigDecimal;

//@Component // ExRateProvider를 상속받은 Component가 두개 있으면 에러
public class SimpleExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) {
        if (currency.equals("USD")) return BigDecimal.valueOf(1000);
        throw new RuntimeException("지원하지 않는 통화입니다");
    }
}
