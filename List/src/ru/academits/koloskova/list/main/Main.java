package ru.academits.koloskova.list.main;

import ru.academits.koloskova.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst(6);
        singlyLinkedList.addFirst(77);
        singlyLinkedList.addFirst(88);

        System.out.println();
        System.out.println("List was created and 3 elements was added:");
        singlyLinkedList.print();

        System.out.println();
        System.out.println("First elem in list: " + singlyLinkedList.getFirst());
        System.out.println("Data of the second elem in list: " + singlyLinkedList.getData(1));

        System.out.println();
        System.out.print("Set data of second elem: ");
        System.out.println("previous data = " + singlyLinkedList.setData(1, 6) +
                ", " + "new data = " + singlyLinkedList.getData(1));

        System.out.println();
        System.out.println("Remove first elem with data = " + singlyLinkedList.removeFirst());
        System.out.println();

        System.out.println("Update list: ");
        singlyLinkedList.print();
        System.out.println();

        System.out.println("Add 3 elem's first..");
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(1);
        System.out.println("Current list: ");
        singlyLinkedList.print();
        System.out.println("New size: " + singlyLinkedList.getSize());
        System.out.println();

        System.out.println("Add 2 elem's by indexes 3 and 4.");
        singlyLinkedList.add(3, 333);
        singlyLinkedList.add(4, 4444);
        singlyLinkedList.add(0, null);

        System.out.println("Current list:");
        System.out.println(singlyLinkedList);

        System.out.println();
        System.out.println("Delete elem by index 2 with data: " + singlyLinkedList.remove(2));
        System.out.println("Current list: ");
        singlyLinkedList.print();
        System.out.println();

        System.out.println("Items with data were existed? " + singlyLinkedList.removeByData(null));
        singlyLinkedList.print();

        System.out.println();
        System.out.println("Revert list:");
        singlyLinkedList.revert();
        singlyLinkedList.print();
        System.out.println();

        System.out.println("Copy constructor:");
        SinglyLinkedList<Integer> copiedByConstructorList = new SinglyLinkedList<>(singlyLinkedList);
        copiedByConstructorList.print();

        SinglyLinkedList<Integer> emptyList = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> copiedByConstructorEmptyList = new SinglyLinkedList<>(emptyList);

        System.out.println();
        copiedByConstructorEmptyList.addFirst(null);
        copiedByConstructorEmptyList.addFirst(1);
        copiedByConstructorEmptyList.removeByData(null);
        copiedByConstructorEmptyList.print();
    }
}
