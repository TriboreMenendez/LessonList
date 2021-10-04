import java.util.*;

public class MyLinkedList <E> {
    MyLinkedList.Node<E> first;
    MyLinkedList.Node<E> last;
    int size;


    public MyLinkedList () {this.size = 0;}

    //курсор на первый элемент
    private void linkFirst(E e) {
        MyLinkedList.Node<E> f = this.first;
        MyLinkedList.Node<E> newNode = new MyLinkedList.Node((MyLinkedList.Node)null, e, f);
        this.first = newNode;
        if (f == null) {
            this.last = newNode;
        } else {
            f.prev = newNode;
        }

        ++this.size;
    }

    //курсор на последний элемент
    void linkLast(E e) {
        MyLinkedList.Node<E> l = this.last;
        MyLinkedList.Node<E> newNode = new MyLinkedList.Node(l, e, (MyLinkedList.Node)null);
        this.last = newNode;
        if (l == null) {
            this.first = newNode;
        } else {
            l.next = newNode;
        }

        ++this.size;
    }

    //курсор на предыдущий элемент
    void linkBefore(E e, MyLinkedList.Node<E> succ) {
        MyLinkedList.Node<E> pred = succ.prev;
        MyLinkedList.Node<E> newNode = new MyLinkedList.Node(pred, e, succ);
        succ.prev = newNode;
        if (pred == null) {
            this.first = newNode;
        } else {
            pred.next = newNode;
        }

        ++this.size;
    }

    //разрывает связь, переставляя курсор на первый элемент
    private E unlinkFirst(MyLinkedList.Node<E> f) {
        E element = f.item;
        MyLinkedList.Node<E> next = f.next;
        f.item = null;
        f.next = null;
        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.prev = null;
        }

        --this.size;
        return element;
    }

    //разрывает связь, переставляя курсор на последний элемент
    private E unlinkLast(MyLinkedList.Node<E> l) {
        E element = l.item;
        MyLinkedList.Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        this.last = prev;
        if (prev == null) {
            this.first = null;
        } else {
            prev.next = null;
        }

        --this.size;
        return element;
    }

    //удаление первого элемента
    public E removeFirst() {
        MyLinkedList.Node<E> f = this.first;
        if (f == null) {
            throw new NoSuchElementException();
        } else {
            return this.unlinkFirst(f);
        }
    }

    //удаление последнего элемента
    public E removeLast() {
        MyLinkedList.Node<E> l = this.last;
        if (l == null) {
            throw new NoSuchElementException();
        } else {
            return this.unlinkLast(l);
        }
    }

    //получение последнего элемента
    public E getLast() {
        MyLinkedList.Node<E> l = this.last;
        if (l == null) {
            throw new NoSuchElementException();
        } else {
            return l.item;
        }
    }

    //получение первого элемента
    public E getFirst() {
        MyLinkedList.Node<E> f = this.first;
        if (f == null) {
            throw new NoSuchElementException();
        } else {
            return f.item;
        }
    }

    //добавление элемента, по умолчанию в конец списка
    public boolean add(E e) {
        this.linkLast(e);
        return true;
    }

    //добавление элемента в начало списка
    public void addFirst(E e) {
        this.linkFirst(e);
    }

    //добавление элемента в конец списка
    public void addLast(E e) {
        this.linkLast(e);
    }

    //вложенный класс текущих положений курсора
    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
