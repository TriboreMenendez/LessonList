import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>(2);
        MyLinkedList<String> myList2 = new MyLinkedList();

        //работа с MyLinkedList
        myList2.addLast("Средний элемент");
        myList2.add("Последний элемент");
        myList2.addFirst("Первый элемент");

        int sizeList = myList2.size;
        System.out.println(myList2.getFirst());
        System.out.println(myList2.getLast());
        System.out.println(sizeList);

        /*
        //работа с MyArrayList
        //добавляем элементы в список
        myList.myAdd("Petr");
        myList.myAdd("Fedr");
        myList.myAdd(1,"Sidr");
        myList.myAdd(1,"Kedr");
        myList.myAdd("Metr");

        //выводим инициализированный список
        System.out.println("Исходный список ArrayList: ");
        myList.printList();

        //удаление элемента
        myList.deletItemPublic(1);
        myList.printList();
        System.out.println();
        /*

        /*использование стандартных LinkedList и ArrayList:
        //списки валют
        LinkedList<String> currencyLinkedList = new LinkedList<>();
        ArrayList<String> currencyArratList = new ArrayList<>();
        String euro = ("EUR"), dollar = ("USD"), ruble = ("RUB");

        //добавление эл-ов в списки и вывод значений на экран
        currencyLinkedList.add(euro);
        currencyLinkedList.add(dollar);
        currencyLinkedList.add(ruble);
        System.out.println("Вывод LinkedList:");
        for (String value : currencyLinkedList) {
            System.out.println(value);
        }

        currencyArratList.add(euro);
        currencyArratList.add(dollar);
        currencyArratList.add(ruble);
        System.out.println("Вывод ArrayList:");
        for (String s : currencyArrayList) {
            System.out.println(s);
        }

        //удаление эл-ов в списках и вывод результата на экран
        currencyLinkedList.removeLast();
        System.out.println("Вывод редактированного LinkedList:");
        for (String s : currencyLinkedList) {
            System.out.println(s);
        }

        currencyArratList.remove(0);
        System.out.println("Вывод редактированного ArrayList:");
        for (String s : currencyArratList) {
            System.out.println(s);
        }

        //поиск введенного элемента в списках
        System.out.print("Введите элемент который требуется найти в LinkedList: ");
        Scanner inSearchL = new Scanner(System.in);
        if (currencyLinkedList.contains(inSearchL.next()))
            System.out.println("Элемент есть в списке");
                    else System.out.println("Элемента нет в списке");

        System.out.print("Введите элемент который требуется найти в ArrayList: ");
        Scanner inSearchA = new Scanner(System.in);
        if (currencyArratList.contains(inSearchA.next()))
            System.out.println("Элемент есть в списке");
        else System.out.println("Элемента нет в списке");
    */
    }
}