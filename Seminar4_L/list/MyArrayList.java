package Seminar4_L.list;

// import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E extends Comparable<E>> implements MyList<E> {

    private E[] valeues;
    private int index;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.index = 0;
        this.size = 0;
        this.capacity = 10;
        try {
            this.valeues = (E[]) new Comparable[capacity];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    private void addCapasity() {
        E[] temp = (E[]) new Comparable[capacity + capacity / 2];
        System.arraycopy(valeues, 0, temp, 0, valeues.length);
        valeues = temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            @Override
            public boolean hasNext() {
                return index < valeues.length;
            }

            @Override
            public E next() {
                return valeues[index++];
            }

        };
    }

    @Override
    public void add(E elT) {
        if (size == capacity) {
            addCapasity();
        }
        valeues[size] = elT;
        size++;
    }

    @Override
    public void delete(E delT) {
        for (int i = 0; i < valeues.length; i++) {
            E elE = valeues[i];
            if (elE.equals(delT)) {
                delete(i);
            }
        }
    }

    @Override
    public void delete(int index) {
        E[] temp = (E[]) new Comparable[capacity - 1];
        System.arraycopy(valeues, 0, temp, 0, index);
        int emoveEl = temp.length - index - 1;
        System.arraycopy(valeues, index + 1, temp, index, emoveEl);
        valeues = temp;
        size--;
    }

    @Override
    public E get(int index) {
        return valeues[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(valeues[i]).append(", ");
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

}
