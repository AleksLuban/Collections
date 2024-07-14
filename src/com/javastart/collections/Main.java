package com.javastart.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(280 );
        customLinkedList.add(130);
        customLinkedList.add(120);
        customLinkedList.add(1100);
        customLinkedList.add(13);
        customLinkedList.add(56000);
         customLinkedList.bubbleSorter();
         customLinkedList.bubbleSorter();
        customLinkedList.printCollection();

    }
}
