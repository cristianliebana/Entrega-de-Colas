public class QueueImpl<E> implements Queue<E> {

    private E[] data;
    private int borrar;

    private int size;

    public QueueImpl(int Capacidad) {
        data = (E[]) new Object[Capacidad];
        borrar = 0;
        size = 0;
    }

    public void push(E e) throws FullQueueException {
        if (size == data.length) {
            throw new FullQueueException("La cola esta llena");
        }
        data[size++]=e;
    }

    public E pop() throws EmptyQueueException {
        if (size == 0) {
            throw new EmptyQueueException("La cola esta vacia");
        }
        E e = data[0];
        for (int i = 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return e;
    }

    public int size() {
        return size;
    }
}