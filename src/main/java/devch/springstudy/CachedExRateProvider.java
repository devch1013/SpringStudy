package devch.springstudy;

import java.math.BigDecimal;

public class CachedExRateProvider implements ExRateProvider {
    private final ExRateProvider target;
    private BigDecimal cachedExRate;

    public CachedExRateProvider(ExRateProvider target) {
        this.target = target;
    }

    @Override
    public BigDecimal getExRate(String currency) throws Exception {
        if (cachedExRate == null) {
            cachedExRate = this.target.getExRate(currency);
            System.out.println("Cache Updated");
        }
        return cachedExRate;
    }
}
