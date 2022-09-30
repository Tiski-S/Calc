import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {

            try {
                Scanner scan = new Scanner(System.in);
                String s = scan.nextLine();
                s = s.replaceAll(" ", "");
                System.out.println("Резуьтат " + calc(s));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }
    }

        public static String calc (String input) throws Exception {
            String[] stl = input.split("\\+|-|\\*|/");
            if(stl.length < 2){
                throw new Exception("Строка не является математической операцией");
            }
            String oper = input.replaceAll("\\w", "");
            if(oper.length() != 1){
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один " + "оператор (+, -, /, *)");
            }
            String snum1 = stl[0];
            String snum2 = stl[1];
            int num1;
            int num2;
            boolean isRome = false;
            if (Rome.isRoman(snum1) && Rome.isRoman(snum2)) {
                num1 = Rome.convToArab(snum1);
                num2 = Rome.convToArab(snum2);
                isRome = true;
            } else if (Rome.isRoman(snum1) || Rome.isRoman(snum2)) {
                throw new Exception("Используются одновременно разные системы счисления");
            } else {
                num1 = Integer.parseInt(snum1);
                num2 = Integer.parseInt(snum2);
                if(num1 < 0 || num1 > 10 || num2 < 0 || num2 > 10){
                    throw new Exception("Выход за диапазон чисел (от 1 до 10)");
                }
            }
            int res = 0;
            switch (oper) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
            }
            if(isRome){
                if(res < 0){
                    throw new Exception("В римской системе нет отрицательных чисел");
                }
                return Rome.convToRome(res);
            }
            return String.valueOf(res);
    }

    }







