package devch.springstudy;

import java.math.BigDecimal;

public class CachedExRateProvider implements ExRateProvider {
    private final ExRateProvider target;

    public CachedExRateProvider(ExRateProvider target) {
        this.target = target;
    }

    @Override
    public BigDecimal getExRate(String currency) throws Exception {
        return target.getExRate(currency);
    }
}
