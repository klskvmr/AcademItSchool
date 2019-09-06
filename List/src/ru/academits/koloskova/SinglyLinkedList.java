package ru.academits.koloskova;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getSize() {
        return count;
    }

    public T getFirstElem() {
        return head.getData();
    }

    public T getData(int index) {
        ListItem<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }

        return p.getData();
    }

    public T setData(int index, T data) {
        ListItem<T> p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }

        T prevData = p.getNext().getData();

        p.getNext().setData(data);

        return prevData;
    }

    public T remove(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Элементом с заданным индексом в списке не существует");
        }

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> p = head;
        //цикл доходит до элемента перед удаляемым
        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }

        T data = p.getNext().getData();
        p.setNext(p.getNext().getNext());

        count--;
        return data;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        count++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Нельзя вставить элемент с заданным индексом");
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        ListItem<T> p = head;

        for (int i = 0; i < index - 1; i++) {
            p = p.getNext();
        }
        p.setNext(new ListItem<>(data, p.getNext()));

        count++;
    }

    public boolean removeByData(T data) {
        boolean isRemove = false;

        while (head.getData().equals(data)) {
            removeFirst();

            isRemove = true;
        }

        for (ListItem<T> p = head;
//             prev = head;
             p.getNext() != null;
//             prev = p,
             p = p.getNext()) {

            if (p.getNext().getData().equals(data)) {
                p.setNext(p.getNext().getNext());

                isRemove = true;
                count--;
            }
        }

        return isRemove;
    }

    public T removeFirst() {
        T data = head.getData();

        head = head.getNext();
        count--;

        return data;
    }

    public void revert() {
        int count1 = count;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            addFirst(p.getData());
        }
    }

    public SinglyLinkedList<T> copy() {
        return null;
    }

    public void print() {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }
    }
}
