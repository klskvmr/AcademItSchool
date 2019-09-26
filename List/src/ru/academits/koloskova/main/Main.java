package ru.academits.koloskova.main;

import ru.academits.koloskova.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst(77);
        singlyLinkedList.addFirst(88);

        System.out.println(singlyLinkedList.getFirstElem());
        System.out.println(singlyLinkedList.getData(1));

        System.out.println();
        System.out.println("Previous data: " + singlyLinkedList.setData(1, 6));
        System.out.println("New data: " + singlyLinkedList.getData(1));

        singlyLinkedList.print();
        System.out.println();

        System.out.println("Remove first elem: " + singlyLinkedList.removeFirst());
        System.out.println();

        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(1);

        singlyLinkedList.print();

        singlyLinkedList.add(3, 999);
        singlyLinkedList.add(4, 6);


        System.out.println();
        singlyLinkedList.print();

        System.out.println();
        System.out.println("Was deleted: " + singlyLinkedList.remove(2));

        System.out.println("Current list: ");
        singlyLinkedList.print();
        System.out.println();

        System.out.println("is delete? " + singlyLinkedList.removeByData(6));
        singlyLinkedList.print();

        System.out.println();
        singlyLinkedList.revert();
        singlyLinkedList.print();


    }
}
