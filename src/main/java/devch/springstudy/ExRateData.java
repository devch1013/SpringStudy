package devch.springstudy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true) // json에 있지만 record에 없는건 무시함
public record ExRateData(
        String result,
        Map<String, BigDecimal> rates
) {
}
