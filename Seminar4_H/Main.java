package Seminar4_H;

import Seminar4_H.list.MyLinkedList;
import Seminar4_H.list.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyLinkedList<>(null, 0); // только с 0 работает
        myList.add(15);
        myList.add(10);
        myList.add(20);
        myList.add(14);
        myList.add(35);
        System.out.println("get value " + myList.get(2));
        System.out.println(myList);
        myList.add(3, 11);
        System.out.println(myList);
        System.out.println("size " + myList.size());
        myList.remove();
        System.out.println(myList);
        myList.remove(4);  // вот эта штука очеень странно удаляет элемент
        System.out.println(myList);
        System.out.println("size " + myList.size());
        // не понимаю зачем я тогда размер объявляю в объявлении списка если он в любом случае
        // меняется и проверки не срабатывают
    }
}
