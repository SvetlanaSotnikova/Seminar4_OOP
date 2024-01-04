package Seminar4_H.list;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head;
    private int size;

    public MyLinkedList(Node<E> head, int size) {
        this.head = head;
        this.size = size;
    }

    @Override
    public void add(E elT) {
        Node<E> node = new Node<>(null, elT, null);
        if (head == null) {
            head = node;
        } else {
            Node<E> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
            node.prev = currentNode;
        }
        size++;
        // throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void add(int index, E elT) {
        if (index < 0 || index > size) {
            throw new UnsupportedOperationException("Unimplemented method 'add'");
        }
        Node<E> newNode = new Node<>(null, elT, null);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            Node<E> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            if (currentNode.next != null) {
                currentNode.next.prev = newNode;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    @Override
    public void remove() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
        } else
            throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new UnsupportedOperationException("Unimplemented method 'remove'");
        }
        if (index == 0) {
            remove();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new UnsupportedOperationException("Unimplemented method 'get'");
        }

        Node<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.item);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

}
