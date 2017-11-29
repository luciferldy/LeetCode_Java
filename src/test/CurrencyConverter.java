package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public interface CurrencyConverter {
    BigDecimal convert(Currency from, Currency to, BigDecimal amount);

    default List convert(Currency from, Currency to, List<BigDecimal> amounts) {
        List result = new ArrayList();
        amounts.forEach(v -> result.add(convert(from, to, v)));
        return result;
    }
}
