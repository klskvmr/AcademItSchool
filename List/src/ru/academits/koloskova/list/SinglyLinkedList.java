package ru.academits.koloskova.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(SinglyLinkedList<T> list) {
        if (list.head == null) {
            return;
        }

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
            throw new IllegalArgumentException("List is empty!");
        }
    }

    private void checkInputIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index is out of list's bounds!");
        }
    }

    private ListItem<T> getNode(int index) {
        ListItem<T> p = head;

        for (int i = 0; i < index; i++) {
            p = p.getNext();
        }

        return p;
    }

    public int getSize() {
        return count;
    }

    public T getFirst() {
        checkHead();

        return head.getData();
    }

    public T getData(int index) {
        checkHead();
        checkInputIndex(index);

        return getNode(index).getData();
    }

    public T setData(int index, T data) {
        checkHead();
        checkInputIndex(index);

        ListItem<T> p = getNode(index);

        T prevData = p.getData();
        p.setData(data);

        return prevData;
    }

    public T remove(int index) {
        checkHead();
        checkInputIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> prev = getNode(index - 1);

        T data = prev.getNext().getData();
        prev.setNext(prev.getNext().getNext());

        count--;

        return data;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        count++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("You cannot add an item with such an index");
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        ListItem<T> prev = getNode(index - 1);
        prev.setNext(new ListItem<>(data, prev.getNext()));

        count++;
    }

    public boolean removeByData(T data) {
        checkHead();

        if (data == null) {
            if ((head.getData() == null)) {
                head = head.getNext();

                count--;
                return true;
            }

            for (ListItem<T> p = head.getNext(), prev = head;
                 p != null; prev = p, p = p.getNext()) {
                if (p.getData() == null) {
                    prev.setNext(p.getNext());

                    count--;
                    return true;
                }
            }

            return false;
        }

        if (head.getData().equals(data)) {
            head = head.getNext();

            count--;
            return true;
        }

        for (ListItem<T> p = head.getNext(), prev = head;
             p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {
                prev.setNext(p.getNext());

                count--;
                return true;
            }
        }

        return false;
    }

    public T removeFirst() {
        checkHead();

        T data = head.getData();

        head = head.getNext();
        count--;

        return data;
    }

    public void revert() {
        ListItem<T> prev = null;

        for (ListItem<T> p = head; p != null; ) {
            ListItem<T> next = p.getNext();

            p.setNext(prev);

            prev = p;
            p = next;
        }

        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            string.append(p.getData()).append(", ");
        }

        if (count > 0) {
            string.delete(string.length() - 2, string.length());
        }

        return string.append("}").toString();
    }

    public void print() {
        System.out.println(toString());
    }
}