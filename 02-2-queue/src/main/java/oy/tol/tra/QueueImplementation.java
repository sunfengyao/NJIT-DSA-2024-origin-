package oy.tol.tra;

import java.util.Arrays;

public class QueueImplementation<E> implements QueueInterface<E> {
    private static final int init_capacity = 10;
    private Object[] elements;
    private int size;

    public QueueImplementation() {
        this.size = 0;
        this.elements = new Object[init_capacity];
    }

    public QueueImplementation(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be greater than or equal to 0.");
        }
        this.elements = new Object[capacity];
        this.size = 0;
    }


    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        if (element == null) {
            throw new NullPointerException("The queue cannot add empty values.");
        }
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public E dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("The queue array is empty.");
        }
        E dequeuedElement = getElement(0);
        System.arraycopy(elements, 1, elements, 0, --size);
        elements[size] = null;
        return dequeuedElement;
    }

    @Override
    public E element() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("The queue array is empty.");
        }
        return getElement(0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private E getElement(int index) {
        return (E) elements[index];
    }
}
