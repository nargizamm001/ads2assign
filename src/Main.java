public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println("ArrayList size: " + arr.size());

        MyStack<String> stack = new MyStack<>();
        stack.push("hello");
        stack.push("world");
        System.out.println("Stack pop: " + stack.pop());

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Queue dequeue: " + queue.dequeue());

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(5);
        heap.add(3);
        heap.add(7);
        System.out.println("Heap peek: " + heap.peek());
    }
}
