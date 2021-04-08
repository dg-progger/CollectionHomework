import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {

    private int size;

    private Object[] elementData = new Object[10];

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.size; i++)
            if(elementData[i].equals(o))
                return true;
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, elementData.length);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length < this.size) {
            return (T[]) this.toArray();
        }
        for(int i = 0; i < a.length; i++) {
            a[i] = (T) elementData[i];
        }
        return a;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < this.size; i++)
            if(elementData[i].equals(o)) {
                for (int j = i; j < size - 1; j++) {
                    elementData[j] = elementData[j+1];
                    i++;
                }
                elementData[size - 1] = null;
                size--;
                return true;
            }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> query) {
        Iterator<?> queryIterator = query.iterator();
        while(queryIterator.hasNext()) {
            if(!this.contains(queryIterator.next()))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> query) {
        Iterator<?> queryIterator = query.iterator();

        while(queryIterator.hasNext()) {
            this.add((E) queryIterator.next());
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> query) {
        boolean isAtLeastOneRemoved = false;
        Iterator<?> queryIterator = query.iterator();

        while(queryIterator.hasNext()) {
            if(this.remove(queryIterator.next()))
                isAtLeastOneRemoved = true;
        }
        return isAtLeastOneRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> query) {
        boolean isAtLeastOneRemoved = false;

        for(int i = 0; i < size; i++) {
            if(!query.contains(elementData[i])) {
                isAtLeastOneRemoved = this.remove(elementData[i]);
            }
        }
        return isAtLeastOneRemoved;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    private class MyIterator<T> implements Iterator<T> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if(cursor >= size){
                throw new NoSuchElementException();
            }
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            if(cursor==0 || elementData[cursor] == null)
                throw new IllegalStateException();
            else
                MyCollection.this.remove((T) elementData[cursor]);
        }
    }
}
