package framework.util;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebElementsParser {
    public static List<Double> parseDiscountsToDouble(List<WebElement> discounts) {
        List<Double> doubleDiscount = new ArrayList<Double>();

        for (int i = 0; i < discounts.size(); i++) {
            doubleDiscount.add(Double.parseDouble(discounts.get(i).getText().substring(0, 3)));
        }
        return doubleDiscount;
    }

    public static List<Integer> parseRatesToInt(List<WebElement> rates) {
        List<Integer> intRates = new ArrayList<Integer>();

        for (int i = 0; i < rates.size(); i++) {
            intRates.add(Integer.parseInt(rates.get(i).getText()));
        }
        return intRates;
    }

    public static List<Integer> parsePricesToInt(List<WebElement> prices) {
        List<Integer> intPrices = new ArrayList<Integer>();

        for (int i = 0; i < prices.size(); i++) {
            intPrices.add(Integer.parseInt(StringUtils
                    .substringBefore(prices.get(i).getText()
                            .replaceAll("\\s+", ""), "тг")));
        }
        return intPrices;
    }
}
