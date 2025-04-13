public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T element) {
        list.add(element);
    }

    public T dequeue() {
        if (list.isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.remove(0);
    }

    public T peek() {
        if (list.isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
