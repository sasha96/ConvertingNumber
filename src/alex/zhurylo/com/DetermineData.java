package alex.zhurylo.com;

import java.util.Scanner;

public class DetermineData {
    private static Scanner scanner = new Scanner(System.in);

    public static String defineCurrency() {
        System.out.println("Please enter your national currency");
        String nationalityCurrency = scanner.next();
        while (!nationalityCurrency.equals("en") && !nationalityCurrency.equals("ukr") &&
                !nationalityCurrency.equals("dollars") && !nationalityCurrency.equals("гривня")) {
            System.out.println("Sorry, but this currency is not correct");
            System.out.println("The program can be converted into only гривні or dollars");
            System.out.println("Please enter dollars or гривня");
            nationalityCurrency = scanner.next();
        }
        if (nationalityCurrency.equals("dollars")) {
            nationalityCurrency = "en";
        } else if (nationalityCurrency.equals("гривня")) {
            nationalityCurrency = "ukr";
        }
        return nationalityCurrency;
    }

    public static int[] defineAmount() {
        int[] result = new int[2];
        System.out.println("Please enter your amount, we will convert it into a String version");
        String number = "";
        number = scanner.next();
        String amount = String.valueOf(number);
        String afterComma = "";
        if (amount.contains(",")) {
            afterComma = amount.substring(amount.indexOf(",") + 1);
            amount = amount.substring(0, amount.indexOf(","));
        } else if (amount.contains(".")) {
            afterComma = amount.substring(amount.indexOf(".") + 1);
            amount = amount.substring(0, amount.indexOf("."));
        }
        Integer numberBeforeComma = Integer.parseInt(amount);
        Integer numberAfterComma = 0;
        if (!afterComma.equals("")) {
            numberAfterComma = Integer.parseInt(afterComma);
        }
        result[0] = numberBeforeComma;
        result[1] = numberAfterComma;
        return result;
    }
}
