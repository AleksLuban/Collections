package com.javastart.collections;

import java.util.ArrayList;
import java.util.Collection;

public class CustomLinkedList<Element extends Comparable<Element>> {

    private Node<Element> first;
    private Node<Element> last;
    private int N;
    private boolean sortedFlaq;
    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public void add(Element element) {
        if (first == null) {
            Node<Element> node = new Node<>(element, null, null);
            first = node;
            last = node;
        } else {
            Node<Element> node = new Node<>(element, null, last);
            last.next = node;
            last = node;
        }
        N++;
        sortedFlaq = false;
    }

    public void addAll(Collection<Element> collection) {
        for (Element element : collection) {
            if (first == null) {
                Node<Element> node = new Node<>(element, null, null);
                first = node;
                last = node;
                N++;
            } else {
                Node<Element> node = new Node<>(element, null, last);
                last.next = node;
                last = node;
                N++;
            }
        }
        sortedFlaq = false;

    }

    public Element getElement(int index) {
        Node<Element> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }

    public Node<Element> get(int index) {
        Node<Element> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    public boolean contains(Element element) {
        Node<Element> result = first;
        while (result != null) {
            if (result.item == element)
                return true;
            else result = result.next;
        }
        return false;
    }

    public void printCollection() {
        Node<Element> element = first;
        for (int i = 0; i < N; i++)
            System.out.println(this.getElement(i));
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean remove(Element item) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove() from and empty list.");
        }
        boolean result = false;
        Node<Element> prev = first;
        Node<Element> curr = first;
        while (curr.next != null || curr == last) {
            if (curr.item.equals(item)) {
                // remove the last remaining element
                if (N == 1) {
                    first = null;
                    last = null;
                }
                // remove first element
                else if (curr.equals(first)) {
                    first = first.next;
                }
                // remove last element
                else if (curr.equals(last)) {
                    last = prev;
                    last.next = null;
                }
                // remove element
                else {
                    prev.next = curr.next;
                }
                N--;
                result = true;
                break;
            }
            prev = curr;
            curr = prev.next;
        }
        return result;
    }

    public void bubbleSorter() {
        if (!sortedFlaq) {

            for (int out = N - 1; out >= 1; out--) {

                for (int in = 0; in < out; in++) {
                    Node<Element> element1 = this.get(in);
                    Node<Element> element2 = this.get(in + 1);

                    if (element1.item.compareTo(element2.item) > 0) {
                        Element change = element1.item;
                        element1.item = element2.item;
                        element2.item = change;
                    }

                }

            }

            sortedFlaq = true;
        } else System.out.println("Коллекция уже отсортирована");
    }

    private static class Node<Element> {
        Element item;
        Node<Element> next;
        Node<Element> prev;

        public Node(Element item, Node<Element> next, Node<Element> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
