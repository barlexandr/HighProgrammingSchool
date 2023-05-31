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
        this.count = 0;
        makeArray(INITIAL_CAPACITY);
    }

    public void makeArray(int new_capacity) {
        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        int oldCapacity = this.capacity;
        this.capacity = new_capacity;
        if (array != null && this.count != 0) {
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
        return this.array[index];
    }

    public void append(T itm) {
        this.resizeIfNeeded();
        this.array[this.count] = itm;
        this.count++;
    }

    public void insert(T itm, int index) {
        if (index < 0 || index > this.array.length || index > this.count) {
            throw new IndexOutOfBoundsException("Enter an index that is less than or equal to the current array dimension.");
        }
        this.resizeIfNeeded();

        if (index == this.capacity) {
            this.insert(itm, this.capacity - 1);
        } else {
            T tempElement = this.array[index];
            this.array[index] = itm;
            T next = null;
            for (int i = 1; i <= this.count - index; i++) {
                if (index + i < this.capacity) {
                    next = this.array[index + i];
                }
                this.array[index + i] = tempElement;
                tempElement = next;
            }
            this.count++;
        }
    }

    public void remove(int index) {
        this.checkIndexAgainstArrayBounds(index);
        if (index >= this.count || this.array[index] == null) {
            throw new IndexOutOfBoundsException("Enter an index that is less than or equal to the current array dimension.");
        }
        if (this.array[index] != null) {
            this.count--;
        }
        this.array[index] = null;

        while (index < this.count && this.array[index + 1] != null) {
            this.array[index] = this.array[index + 1];
            this.array[index + 1] = null;
            index++;
        }

        double coefficient = (double) this.count / this.capacity;
        int newCapacity = (int) (this.capacity / 1.5);
        if (newCapacity < INITIAL_CAPACITY) {
            newCapacity = INITIAL_CAPACITY;
        }
        if (coefficient < 0.5 && this.capacity != newCapacity) {
            makeArray(newCapacity);
        }
    }

    private void resizeIfNeeded() {
        if (this.count == this.capacity) {
            this.makeArray(this.capacity * 2);
        }
    }

    private void checkIndexAgainstArrayBounds(int index) {
        if (index < 0 || index >= this.array.length) {
            throw new IndexOutOfBoundsException("Enter an index that is less than or equal to the current array dimension.");
        }
    }

}
