package devch.springstudy;

import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) throws Exception {
        if (currency.equals("USD")) return BigDecimal.valueOf(1000);
        throw new IllegalAccessException("지원하지 않는 통화입니다");
    }
}
