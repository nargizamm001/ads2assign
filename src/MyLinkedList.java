public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T value;
        MyNode next;
        MyNode prev;

        MyNode(T value) {
            this.value = value;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public void add(T element) {
        MyNode node = new MyNode(element);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        MyNode node = new MyNode(element);
        if (index == 0) {
            node.next = head;
            if (head != null) head.prev = node;
            head = node;
            if (tail == null) tail = node;
        } else if (index == size) {
            add(element);
            return;
        } else {
            MyNode current = getNode(index);
            MyNode prev = current.prev;
            prev.next = node;
            node.prev = prev;
            node.next = current;
            current.prev = node;
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    public T remove(int index) {
        MyNode node = getNode(index);
        T value = node.value;

        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
        return value;
    }

    public boolean remove(T element) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(element)) {
                remove(i);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T element) {
        MyNode current = head;
        while (current != null) {
            if (current.value.equals(element)) return true;
            current = current.next;
        }
        return false;
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            MyNode current = head;
            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
