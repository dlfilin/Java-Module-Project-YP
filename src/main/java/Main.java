import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

        MoneyCalc calc = new MoneyCalc(getPeopleQty());

        calc.addItems();
        calc.printItems();
        calc.printDividedSum();

    }

    private static short getPeopleQty() {

        System.out.println("На сколько человек разделить счёт?");

        while (true) {

            Scanner sc = new Scanner(System.in);

            if (sc.hasNextShort()) {

                short qty = sc.nextShort();

                if (qty > 1 && qty < Short.MAX_VALUE) {
                    System.out.println("Принято! Число гостей: " + qty);
                    return qty;
                }
            }

            System.out.println("Пожалуйста, введите корректное количество:");
        }
    }
}
