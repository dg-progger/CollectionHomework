import java.util.Iterator;

public class CollectionHomework {
    public static void main(final String[] args) {
        checkToArray();
    }

    public static void checkAddAndRemove() {
        MyCollection<Integer> myCollection = new MyCollection<>();
        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(3);

        myCollection.remove(1);

        Iterator<Integer> it = myCollection.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(myCollection.size());
    }

    public static void checkClear() {
        MyCollection<Integer> myCollection = new MyCollection<>();
        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(3);

        myCollection.clear();

        Iterator<Integer> it = myCollection.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(myCollection.size());
    }

    public static void checkContainsAll() {
        MyCollection<Integer> destCollection = new MyCollection<>();
        destCollection.add(1);
        destCollection.add(2);
        destCollection.add(3);
        destCollection.add(4);

        MyCollection<Integer> queryCollection = new MyCollection<>();
        queryCollection.add(1);
        queryCollection.add(5);

        System.out.println(destCollection.containsAll(queryCollection));
    }

    public static void checkRemoveAll() {
        MyCollection<Integer> destCollection = new MyCollection<>();
        destCollection.add(1);
        destCollection.add(2);
        destCollection.add(3);
        destCollection.add(4);

        MyCollection<Integer> queryCollection = new MyCollection<>();
        queryCollection.add(6);
        queryCollection.add(5);

        System.out.println(destCollection.removeAll(queryCollection));
    }

    public static void checkToArray() {
        MyCollection<Integer> destCollection = new MyCollection<>();
        destCollection.add(1);
        destCollection.add(2);
        destCollection.add(3);

        Integer[] queryArray = new Integer[5];

        Object[] res1 = destCollection.toArray();
        Integer[] res2 = destCollection.toArray(queryArray);

        System.out.println(res1);
        System.out.println(res2);
    }
}
