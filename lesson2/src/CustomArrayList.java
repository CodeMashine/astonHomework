
public class CustomArrayList<T extends Object> {

    private int capacity = 16;
    private T[] inner = (T[]) new Object[capacity];
    private int last = 0;

    public CustomArrayList() {
        inner = (T[]) new Object[capacity];
    }

    public CustomArrayList(T... elements) {
        if (elements.length >= inner.length) {
            capacity = elements.length + elements.length / 2;
            this.inner = (T[]) new Object[capacity];
        }
        for (int i = 0; i < elements.length; i += 1) {
            inner[i] = elements[i];
        }

        last = elements.length;
    }


    public T set(int index, T elem) {
        checkIndex(index);
        inner[index] = elem;
        return elem;
    }


    public int add(T element) {
        this.inner[last] = element;
        last += 1;
        if (last == capacity - 2) {
            addCapacity();
        }
        return last;
    }


    public int add(int index, T element) {
        checkIndex(index);
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(inner, 0, tmp, 0, index);
        System.arraycopy(inner, index, tmp, index + 1, last);
        tmp[index] = element;
        inner = tmp;
        last += 1;

        return last;

    }


    public int size() {
        return last;
    }

    public T get(int index) {
        checkIndex(index);
        return inner[index];
    }

    public int indexOf(T elem) {
        int index = -1;
        for (int j = 0; j < last; j++) {
            if (inner[j].equals(elem) || inner[j] == elem) {
                index = j;
            }
        }
        return index;
    }

    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    public T remove(Integer index) {
        checkIndex(index);
        T deleted = inner[index];

        if (index == last - 1) {
            inner[index] = null;
            return deleted;
        }


        T[] tmp = (T[]) new Object[capacity];

        System.arraycopy(inner, 0, tmp, 0, index);
        System.arraycopy(inner, index + 1, tmp, index, last);
        last -= 1;
        inner = tmp;
        return deleted;
    }


    public boolean equals(CustomArrayList<T> other) {

        if (other == null) {
            return false;
        }

        if (other == this) {
            return true;
        }

        if (this.hashCode() != other.hashCode()) {
            return false;
        }


        if (!(other.get(0).getClass().equals(inner[0].getClass()))) {
            return false;
        }

        if (last != other.size()) {
            return false;
        }
        ;
        int count = 0;

        for (int i = 0; i < last; i++) {
            if (inner[i] == other.get(i) || inner[i].equals(other.get(i))) {
                count += 1;
            }
        }

        return count == last;

    }

    @Override
    public int hashCode() {
        int hash = last * 33 + capacity * 12;
        return hash;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < last - 1; i++) {
            output += String.valueOf(inner[i]);
            output += " ";
        }
        output += inner[last - 1];
        return output;
    }

    private void addCapacity() {
        capacity += (capacity / 2);
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(inner, 0, tmp, 0, inner.length);
        inner = tmp;
    }

    private void checkIndex(int index) {
        if (index > last - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


}
