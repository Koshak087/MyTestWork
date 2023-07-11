import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println( "Клалькулятор целых чисел и цифры 10, кроме 0\n" +
                            "\nМатематичесике операции: + - * /" );
        Scanner in = new Scanner(System.in);
        try{
            System.out.println( Calculator.calc(in.nextLine()) );
        }catch (InputException e){
            System.err.println(e.getMessage());
        }
    }

}
