package alex.zhurylo.com;

public class Main {
    public static void main(String[] args) {
        String currency = DetermineData.defineCurrency();
        int amounts[] = DetermineData.defineAmount();
        int numberBeforeComma = amounts[0];
        int numberAfterComma = amounts[1];
        String result = ConvertedNumber.transformingIntoString(currency, numberBeforeComma, numberAfterComma);
        System.out.println(result);
    }
}
