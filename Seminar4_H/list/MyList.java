package Seminar4_H.list;

public interface MyList<E> {
    void add(E elT);

    void add(int index, E elT);

    void remove();

    void remove(int index);

    E get(int index);

    int size();
}
