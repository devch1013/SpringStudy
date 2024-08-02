package devch.springstudy;

import java.math.BigDecimal;

public class SimpleExRateProvider {
    BigDecimal getExRate(String currency) throws Exception {
        if (currency.equals("USD")) return BigDecimal.valueOf(1000);
        throw new IllegalAccessException("지원하지 않는 통화입니다");
    }
}
