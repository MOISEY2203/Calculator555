import java.io.IOException;

public class Action {
    public static String calculate (Number number1 , Number number2, String operator) throws IOException {
        Number result;
//        try {
        switch (operator) {
            case "+":
                result = new Number(number1.getValue()+number2.getValue(),number1.getType());
                break;
            case "-":
                result = new Number(number1.getValue()-number2.getValue(),number1.getType());
                break;
            case "*":
                result = new Number(number1.getValue()*number2.getValue(),number1.getType());
                break;
            case "/":
                result = new Number(number1.getValue()/number2.getValue(),number1.getType());
                break;
            default:
                throw new IOException();
        }
//       }
//        catch (IOException e){
//            System.out.println("недопустимый ввод");
//            System. exit(0);
//        }
        return String.valueOf(result.getValue());
    }

}

