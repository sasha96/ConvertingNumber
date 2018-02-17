package alex.zhurylo.com;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

public class ConvertedNumber {

    public static String transformingIntoString(String currency, Integer numberBeforeComma, Integer numberAfterComma) {
        String result = "";
        String lastNumber = "";
        if (currency.equals("ukr")) {
            if (numberBeforeComma != 0) {
                RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(Locale.forLanguageTag(currency), RuleBasedNumberFormat.SPELLOUT);
                result = ruleBasedNumberFormat.format(numberBeforeComma);
                lastNumber = result.substring(result.lastIndexOf(" ") + 1, result.length());
                if (lastNumber.equals("один")) {
                    result = result.replaceAll("один", "одна") + " гривня ";
                } else if (lastNumber.equals("два")) {
                    result = result.replaceAll("два", "дві") + " гривні ";
                } else {
                    result += " гривень ";
                }
            }
            if (numberAfterComma != 0) {
                RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(Locale.forLanguageTag(currency), RuleBasedNumberFormat.SPELLOUT);
                result += ruleBasedNumberFormat.format(numberAfterComma);
                lastNumber = result.substring(result.lastIndexOf(" ") + 1, result.length());
                if (lastNumber.equals("один")) {
                    result = result.replaceAll("один", "одна") + " копійка  ";
                } else if (lastNumber.equals("два")) {
                    result = result.replaceAll("два", "дві") + " копійки  ";
                } else {
                    result += " копійок ";
                }
                return result;
            }
            return result;
        } else {
            if (numberBeforeComma != 0) {
                RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(Locale.forLanguageTag(currency), RuleBasedNumberFormat.SPELLOUT);
                result = ruleBasedNumberFormat.format(numberBeforeComma) + " dollars ";
            }
            if (numberAfterComma != 0) {
                RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(Locale.forLanguageTag(currency), RuleBasedNumberFormat.SPELLOUT);
                if (ruleBasedNumberFormat.format(numberAfterComma).equals("one")) {
                    if (numberBeforeComma != 0) {
                        result += "and " + ruleBasedNumberFormat.format(numberAfterComma) + " cent ";
                    } else {
                        result += ruleBasedNumberFormat.format(numberAfterComma) + " cent ";
                    }
                } else {
                    result += "and " + ruleBasedNumberFormat.format(numberAfterComma) + " cents ";
                }
            }
            return result;
        }
    }

}
