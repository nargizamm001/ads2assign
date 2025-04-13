public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public void add(T element) {
        heap.add(element);
        siftUp(heap.size() - 1);
    }

    public T remove() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        T root = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.add(0, last);
            siftDown(0);
        }
        return root;
    }

    public T peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                T temp = heap.get(index);
                heap.add(index, heap.get(parent));
                heap.remove(index + 1);
                heap.add(parent, temp);
                heap.remove(parent + 1);
                index = parent;
            } else break;
        }
    }

    private void siftDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != index) {
                T temp = heap.get(index);
                heap.add(index, heap.get(smallest));
                heap.remove(index + 1);
                heap.add(smallest, temp);
                heap.remove(smallest + 1);
                index = smallest;
            } else break;
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}
