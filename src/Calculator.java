import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Calculator {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение для вычисления");
        String formula = reader.readLine();   // считываем формулу для вычисления
        reader.close();
        int num1 = 0;
        int num2 = 0;
        String[] values = new String[2];
        if (formula.contains("+")) {                         // разбиваем формулу на значения и помещаем в массив
            values = formula.split("\\+", 2);
        } else if (formula.contains("-")) {
            values = formula.split("\\-", 2);
        } else if (formula.contains("*")) {
            values = formula.split("\\*", 2);
        } else if (formula.contains("/")) {
            values = formula.split("\\/", 2);
        }
        try {
            num1 = Integer.parseInt(values[0]); // пробуем с арабскими цифрами
            num2 = Integer.parseInt(values[1]);
            if (num1 > 10 || num1 < 0 || num2 < 0 || num2 > 10) {
                System.out.println("Число должно быть больше 0 и меньше 10");
            } else {
                int result = Result.getResult(formula, num1, num2);  // метод result общий
                System.out.println("Результат " + result);
            }
        } catch (NumberFormatException e) {
            num1 = Arrays.asList(RomanianNumbers.romanian).indexOf(values[0]);  // возвращает арабскую цифру или -1
            num2 = Arrays.asList(RomanianNumbers.romanian).indexOf(values[1]);
            if (num1 == -1 || num2 == -1) {
                System.out.println("Некорректный тип операции");
            } else if (num1 > 10 || num1 < 0 || num2 < 0 || num2 > 10) {
                System.out.println("Число должно быть больше 0 и меньше 10");
            } else {
                int result = Result.getResult(formula, num1, num2); // метод result общий
                System.out.println("Результат " + RomanianNumbers.romanian[result]);
            }
        }
    }
}

