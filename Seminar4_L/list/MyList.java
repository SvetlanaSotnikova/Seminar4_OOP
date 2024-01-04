package Seminar4_L.list;

public interface MyList<T extends Comparable<T>> extends Iterable<T> {
    void add(T elT);

    void delete(T delT);

    void delete(int index);

    T get(int index);

    int size();
}
