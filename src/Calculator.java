import java.util.ArrayList;

public class Calculator {

    public static boolean isOperation(char c){
        return c == '+' || c == '-' ||c == '*' || c == '/';
    }
    public static boolean isValidInput(int num){
        return num>=1 && num<=10;
    }
    public static boolean isValidNumber(int num){
        return num>=1 && num<=100;
    }


    public static String calc(String inp) throws InputException {
        inp = inp.replaceAll(" ", "");


        if(inp.isEmpty()){
            throw new InputException("Ошибка ввода! Пустая входная строка.");
        }


        ArrayList<String> inputs = new ArrayList();
        for(int i = 0; i < inp.length(); ++i){
            if( isOperation(inp.charAt(i)) ){
                inputs.add(inp.substring(0,i));
                inputs.add(inp.substring(i,i+1));
                inputs.add(inp.substring(i+1));
                break;
            }
        }

        if(inputs.isEmpty()){
            throw new InputException("Ошибка ввода! Не найдена допустимая операция.");
        }else if(inputs.size() == 1){
            throw new InputException("Ошибка ввода! Отсутствуют значения.");
        }else if(inputs.size() == 2){
            throw new InputException("Ошибка ввода! Одно из значений отсутствует.");
        }

        int left, right;
        boolean isRoman = false;


        try{

            left = Integer.parseInt(inputs.get(0));
            try{

                right = Integer.parseInt(inputs.get(2));
            }
            catch (NumberFormatException e){
                throw new InputException("Ошибка ввода! Неожиданное значение '" + inputs.get(2) + "'.");
            }
        }
        catch (NumberFormatException e){
            try{

                left = IsRoman.toRoman(inputs.get(0)).getNumber();
            }
            catch (IllegalArgumentException e1){
                throw new InputException("Ошибка ввода! Неожиданное значение '" + inputs.get(0) + "'.");
            }
            try{

                right = IsRoman.toRoman(inputs.get(2)).getNumber();
            }
            catch (IllegalArgumentException e1){
                throw new InputException("Ошибка ввода! Неожиданное значение '" + inputs.get(2) + "'.");
            }
            isRoman = true;
        }


        if (!isValidInput(left) || !isValidInput(right)) {

            throw new InputException("Ошибка ввода! Недопустимое значение'" + (isValidInput(right) ?
                    (isRoman ? IsRoman.toRoman(left): left) :
                    (isRoman ? IsRoman.toRoman(right): right)
            ) + "'.");

        }
        else{
            int result;

            switch (inputs.get(1).charAt(0)) {
                case '+':
                    result = left + right;
                    break;
                case '-':
                    result = left - right;
                    break;
                case '*':
                    result = left * right;
                    break;
                case '/':
                    result = left / right;
                    break;
                default:
                    throw new InputException("Ошибка ввода! Неожиданный оператор '" + inputs.get(1) + "'.");
            }
            int b = (int)Math.round(result);
            result = b;

            if(isValidNumber(result)){
                return isRoman ? IsRoman.toRoman(result).toString() :
                                 Integer.toString(result);

            }else{
                throw new InputException("Результат вычисления не поддерживается калькулятором.");
            }
        }

    }

}
