package dynArray;

import java.lang.reflect.Array;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    private static final int INITIAL_CAPACITY = 16;
    Class clazz;

    public DynArray(Class clz) {
        this.clazz = clz;
        count = 0;
        makeArray(INITIAL_CAPACITY);
    }

    public void makeArray(int new_capacity) {
        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        int oldCapacity = this.capacity;
        this.capacity = new_capacity;
        if (array != null && count != 0) {
            for (int i = 0, j = 0; i < oldCapacity && j < new_capacity; i++, j++) {
                while (this.array[i] == null && i < oldCapacity - 1) {
                    i++;
                }
                newArray[j] = this.array[i];
            }
        }
        this.array = newArray;
    }

    public T getItem(int index) {
        this.checkIndexAgainstArrayBounds(index);
        return array[index];
    }

    public void append(T itm) {
        this.resizeIfNeeded();
        this.array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index > count) {
            throw new IndexOutOfBoundsException("Enter an index that is less than or equal to the current array dimension.");
        }
        this.checkIndexAgainstArrayBounds(index);
        this.resizeIfNeeded();

        if (index == this.capacity) {
            this.insert(itm, capacity - 1);
        } else {
            T tempElement = this.array[index];
            this.array[index] = itm;
            T next = null;
            for (int i = 1; i <= count - index; i++) {
                if (index + i < capacity) {
                    next = this.array[index + i];
                }
                array[index + i] = tempElement;
                tempElement = next;
            }
            count++;
        }
    }

    public void remove(int index) {
        this.checkIndexAgainstArrayBounds(index);
        if (this.array[index] != null) {
            count--;
        }
        this.array[index] = null;
        double coefficient = (double) count / capacity;
        int newCapacity = (int) (this.capacity / 1.5);
        if (newCapacity < INITIAL_CAPACITY) {
            newCapacity = INITIAL_CAPACITY;
        }
        if (coefficient < 0.5 && this.capacity != newCapacity) {
            makeArray(newCapacity);
        }
    }

    private void resizeIfNeeded() {
        if (count == capacity) {
            this.makeArray(this.capacity * 2);
        }
    }

    private void checkIndexAgainstArrayBounds(int index) {
        if (index < 0 || index > capacity) {
            throw new IndexOutOfBoundsException("Enter an index that is less than or equal to the current array dimension.");
        }
    }

}
