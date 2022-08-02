import java.io.IOException;
import java.util.Objects;

public class Number {
    private int value;
    private NumberType type;
    static final private String[] roman = {"I","II","III","IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public Number(String input) throws IOException{
        try {
            this.value = Integer.parseInt(input);
            this.type = NumberType.ARABIC;
        }catch (NumberFormatException e) {
            this.value = fromRomanToArabic(input);
            this.type = NumberType.ROMAN;
        }

        if (value < 1 || value > 10) {
            throw new IOException();
        }
    }
    public Number (int value, NumberType type){
        this.type = type;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public NumberType getType() {
        return type;
    }

    public static int fromRomanToArabic(String input) throws IOException{
        for (int i = 0; i < 10 ; i++ ){
            if(Objects.equals(input, roman[i])){
                return i+1;
            }
        }
        throw new IOException();
    }

    public static void typeCheck (Number number1 , Number number2) throws IOException{
        if (number1.type != number2.type ){
            throw new IOException();
        }
    }
    public static String fromArabicToRoman(int input) throws Exception{
        if(input<1){
            throw new Exception("В римских цифрах нет отрицательных и нуля");
        }
        String result= "";

        while (input>0){
            if (input == 100){
                return "C";
            }
            else if (input>=90){
                input = input - 90;
                result = result + "XC";
            }
            else if (input>=50){
                input= input- 50;
                result = result+"L";
            }
            else if (input >=40){
                input= input-40;
                result = result + "XL";
            }
            else if (input >= 10){
                input = input - 10;
                result = result + "X";
            }
            else  if (input >=9){
                input= input - 9;
                result = result + "IX";
            }
            else if(input >=5){
                input = input - 5;
                result = result+ "V";
            }
            else if (input >=4){
                input = input - 4 ;
                result= result + "IV";
            }
            else {
                input = input-1 ;
                result = result + "I";
            }

        }
        return result;
    }



}