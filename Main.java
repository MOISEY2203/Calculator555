import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); // создали объект класса Scanner
        while (true){ //цикл while с условием true
            String input = in.nextLine(); //поместили в строку input считываемую строку с консоли
            System.out.println(calc(input) );//вызвали метод calc и подали на вход строку input
        }
    }
    public static String calc (String input){

        String[] symbols = input.split(" "); //      input "4 + 19"  == > symbols ["4", "+", "19"]
        try {
            if (symbols.length != 3){
                throw new IOException();
            }
            Number number1 = new Number(symbols[0]);
            Number number2 = new Number(symbols[2]);
            Number.typeCheck(number1, number2);
            if (number1.getType()== NumberType.ARABIC){
                return Action.calculate(number1,number2,symbols[1]);
            }
            else {
                String result = Action.calculate(number1,number2,symbols[1]);
                try {
                    return Number.fromArabicToRoman(Integer.parseInt(result));
                }
                catch (Exception e){
                    System.out.println("недопустимый результат римских чисел");
                    System. exit(0);
                }
            }

        } catch (IOException e) {
            System.out.println("недопустимый ввод");
            System. exit(0);
        }
        return "0";
    }

}