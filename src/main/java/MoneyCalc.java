import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoneyCalc {

    short qtyOfPeople;
    double sumOfMoney;
    List<Item> listOfItems;


    MoneyCalc(short qty) {
        qtyOfPeople = qty;
        listOfItems = new ArrayList<>();
    }


    void addItems() {

        do {

            String name;
            double price;

            System.out.println("Введите название товара №" + (listOfItems.size() + 1) + ":");
            Scanner scName = new Scanner(System.in);
            name = scName.next();

            System.out.println("Введите цену товара №" + (listOfItems.size() + 1) + " в формате \"рубли.копейки\":");
            price = inputItemPrice();

            listOfItems.add(new Item(name, price));
            sumOfMoney += price;

            System.out.println("Товар \"" + name + "\" успешно добавлен! Текущая сумма: " + printRoubles(sumOfMoney));

        } while (!stopAddingItems());

    }

    boolean stopAddingItems () {

        System.out.println("Чтобы продолжить добавление, введите любые символы. Или наберите \"Завершить\", чтобы выйти");

        Scanner sc = new Scanner(System.in);

        return (sc.next().equalsIgnoreCase("завершить"));

    }

    double inputItemPrice() {

        while (true) {

            Scanner scPrice = new Scanner(System.in);

            if (scPrice.hasNextDouble()) {

                double price = scPrice.nextDouble();

                if (price > 0) {
                    return price;
                }
            }

            System.out.println("Неверное значение цены в формате \"рубли.копейки\". Введите еще раз: ");
        }
    }

    void printItems() {

        System.out.println("Добавленные товары:");

        for (Item it : listOfItems) {

            System.out.println(it.itemName + ": " + String.format("%.2f", it.itemPrice));

        }

        System.out.println("Общая сумма: " + printRoubles(sumOfMoney));
    }

    void printDividedSum() {

        System.out.println("Каждый из " + qtyOfPeople + " человек должен заплатить " + printRoubles(sumOfMoney / qtyOfPeople));

    }

    String printRoubles(double rub) {

        String ending;

        int r = ( (int) Math.floor(rub) ) % 100;

        if (r >= 11 && r <= 14) ending = " рублей";
        else {
            switch (r % 10) {
                case 1:
                    ending = " рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    ending = " рубля";
                    break;
                default:
                    ending = " рублей";
            }
        }

        return String.format("%.2f", rub) + ending;
    }
}
