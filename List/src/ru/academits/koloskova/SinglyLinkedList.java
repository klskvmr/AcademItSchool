package ru.academits.koloskova;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
        head = null;
        count = 0;
    }

    public SinglyLinkedList(SinglyLinkedList<T> list) {
        list.checkHead();

        head = new ListItem<>(list.head.getData());

        ListItem<T> listItemCopy = head;

        for (ListItem<T> p = list.head; p.getNext() != null;
             listItemCopy = listItemCopy.getNext(), p = p.getNext()) {
            listItemCopy.setNext(new ListItem<>(p.getNext().getData()));
        }

        count = list.count;
    }

    private void checkHead() {
        if (head == null) {
            throw new NullPointerException("List is empty");
        }
    }

    private void checkInputIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index is out of list's bounds");
        }
    }

    public int getSize() {
        return count;
    }

    public T getFirst() {
        return head.getData();
    }

    public T getData(int index) {
        checkInputIndex(index);

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
        checkInputIndex(index);

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
            throw new IllegalArgumentException("You cannot add an item with such an index");
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
            head = head.getNext();

            isRemove = true;
            count--;
        }

        for (ListItem<T> p = head.getNext(), prev = head;
             p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {

                prev.setNext(p.getNext());

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
        checkHead();

        ListItem<T> prev = null;

        for (ListItem<T> p = head; p != null; ) {
            ListItem<T> next = p.getNext();

            p.setNext(prev);

            prev = p;
            p = next;
        }

        head = prev;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copiedList = new SinglyLinkedList<>();

        copiedList.head = new ListItem<>(head.getData());

        ListItem<T> listItemCopy = copiedList.head;

        for (ListItem<T> p = head; p.getNext() != null;
             listItemCopy = listItemCopy.getNext(), p = p.getNext()) {
            listItemCopy.setNext(new ListItem<>(p.getNext().getData()));
        }

        copiedList.count = count;

        return copiedList;
    }

    public void print() {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            System.out.println(p.getData());
        }
    }
}