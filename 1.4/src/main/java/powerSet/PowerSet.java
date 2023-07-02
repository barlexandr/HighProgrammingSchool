package powerSet;

import java.util.ArrayList;
import java.util.List;

public class PowerSet<T> {

    private final List<T> powerSet;
    private final int size = 20_000;


    public PowerSet() {
        this.powerSet = new ArrayList<>(this.size);
    }


    public PowerSet(List<T> set) {
        this.powerSet = new ArrayList<>(this.size);
        this.powerSet.addAll(set);
    }

    public int size() {
        return this.powerSet.size();
        // количество элементов в множестве
    }

    public void put(T value) {
        if (!this.get(value)) {
            this.powerSet.add(value);
        }
        // всегда срабатывает
    }

    public boolean get(T value) {
        return this.powerSet.contains(value);
        // возвращает true если value имеется в множестве, иначе false
    }

    public boolean remove(T value) {
        return this.powerSet.remove(value);
        // возвращает true если value удалено
    }

    public PowerSet<T> intersection(PowerSet<T> set2) {
        final var result = new PowerSet<T>();
        for (T element : set2.powerSet) {
            if (this.powerSet.contains(element)) {
                result.put(element);
            }
        }
        return result;
        // пересечение текущего множества и set2
    }

    public PowerSet<T> union(PowerSet<T> set2) {
        final var result = new PowerSet<>(this.powerSet);
        for (T element : set2.powerSet) {
            if (!this.powerSet.contains(element)) {
                result.put(element);
            }
        }
        return result;
        // объединение текущего множества и set2
    }

    public PowerSet<T> difference(PowerSet<T> set2) {
        final var result = new PowerSet<>(this.powerSet);
        for (var element : set2.powerSet) {
            if (this.powerSet.contains(element)) {
                result.remove(element);
            }
        }
        return result;
        // разница текущего множества и set2
    }

    public boolean isSubset(PowerSet<T> set2) {
        for (T element : set2.powerSet) {
            if (!this.powerSet.contains(element)) {
                return false;
            }
        }
        return true;
    }
}