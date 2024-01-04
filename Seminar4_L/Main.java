package Seminar4_L;

import Seminar4_L.list.MyArrayList;
import Seminar4_L.list.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyArrayList<>();
        myList.add(12);
        myList.add(40);
        myList.add(4);
        System.out.println(myList.get(2));
        myList.delete(1);
        System.out.println(myList);
    }
}
