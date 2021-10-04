import java.util.Arrays;

class MyArrayList<T> {
    private static final Object[] defaultArray = new Object[0];
    public Object[] items;
    int maxSize, newItem, sizeItem;

    //конструктор с входящим размером списка
    public MyArrayList(int init) {
        if (init > 0) {
            this.items = new Object[init];
            maxSize = init;
        } else {
            if (init != 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + init);
            }
            this.items = defaultArray;
        }
    }
    //конструктор без указания размера списка
    public MyArrayList() {this.items = defaultArray;}

    //добавление элемента по индексу
    public void myAdd (int index, T element) {
        //в случае если указываемый индекс выходит за пределы списка
        if (index >= maxSize || index <0) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы массива");
        }
        //в случае если ячейка пуста
        else if (items[index] == null) {
            items[index] = element;
            ++sizeItem;
        }
        //в случае если в ячейке есть запись
        else {
            addItemsRight(items, index);
            items[index] = element;
            ++sizeItem;
        }
    }

    //добавление элемента в пустую ячейку списка
    public void myAdd (T element) {
        if (expArray(items)) {
            items[newItem]= element;
            ++sizeItem;
        }
        else {
            addItems(items);
            items[sizeItem] = element;
            ++sizeItem;
        }
    }

    //расширение массива в случае нехватки свободных ячеек на 5
    private Object[] addItems (Object[] oldArray) {
        int newArray = oldArray.length + 5;
        oldArray = Arrays.copyOf(oldArray, newArray);
        maxSize = newArray;
        items = oldArray;
        return oldArray;
    }

    //добавление элемента по индексу, при наличии данных в ячейке
    private Object[] addItemsRight (Object[] oldArray, int index) {
        if (sizeItem<maxSize) {
            System.arraycopy(oldArray, index, oldArray, index + 1, sizeItem - index);
            return oldArray;
        }
        else {
            Object[] oldArray1 = addItems(oldArray);
            System.arraycopy(oldArray1, index, oldArray1, index+1, sizeItem - index);
            return oldArray1;
        }
    }
    //метод удаления
    public void deletItemPublic (int index) {
        if (index >=sizeItem) throw new IndexOutOfBoundsException("Индекс выходит за пределы массива");
        else {
            deleteItem(items, index);
            --sizeItem;
            for (int i=sizeItem; i<maxSize; i++) {
                items[i] = null;
            }
        }
    }

    private Object[] deleteItem (Object[] oldArray, int index) {
        System.arraycopy(oldArray, index + 1, oldArray, index, maxSize - 1 - index);
        return oldArray;
    }

    //метод для проверки наличия пустой ячейки, возвращает true или false, переменная newItem получает индекс первого пустого элемента
    private boolean expArray (Object[] expItems) {
        boolean x = false;
        for (int i=expItems.length-1; i>=0; i--){
            if (expItems[i] == null) {
                newItem = i;
                x = true;
            }
        }
        return x;
    }

    //получение элемента списка по индексу
    public T getItems (int index) {
        return (T) items[index];
    }

    //вывод всего списка на экран
    public void printList () {
        System.out.println("Количество элементов списка: " + sizeItem);
        for (int i=0; i<maxSize; ++i) {
            if (items[i] != null) System.out.println(items[i]);
        }
    }
}
