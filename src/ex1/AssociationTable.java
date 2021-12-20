package ex1;

import java.util.*;


public class AssociationTable<K extends Comparable, V> implements Iterable<K> {
    Map<K, V> associationTable;

    public AssociationTable() {
        associationTable = new HashMap<>();
    }

    public AssociationTable(K keys[], V[] values) throws IllegalArgumentException {
        associationTable = new HashMap<>();

        if (keys.length != values.length) {
            throw new IllegalArgumentException("Arguments length are not equals!!!");
        }
        int length = keys.length;

        for (int i = 0; i < length; i++) {
            associationTable.put(keys[i], values[i]);
        }
    }

    private static <K, V extends Comparable<V>> Map<K, V> valueSort(final Map<K, V> map) {
        Comparator<K> valueComparator = (k1, k2) -> {
            int comp = map.get(k1).compareTo(map.get(k2));

            if (comp == 0)
                return 1;
            else
                return comp;
        };
        // SortedMap created using the comparator through TreeMap
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }

    public void add(K key, V value) {
        this.associationTable.put(key, value);
    }

    public V get(K key) {
        if (associationTable.containsKey(key))
            return associationTable.get(key);
        else
            return null;
    }

    public boolean contains(K key) {
        return associationTable.containsKey(key);
    }

    public boolean remove(K key) {
        if (associationTable.containsKey(key)) {
            associationTable.remove(key);
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return associationTable.size();
    }

    private Map reverseMap(Map<K, V> map) {
        Map<V, K> myReverseHashMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            myReverseHashMap.put(entry.getValue(), entry.getKey());
        }
        return myReverseHashMap;
    }

    public Iterator<K> keyIterator() {
      return iterator();
    }

    public Iterator<K> iterator() {
        Map<V, K> reversedMap = reverseMap(associationTable);
        Map sortedMap = valueSort(reversedMap);
        return new CustomIterator<>(sortedMap);
    }

    public class CustomIterator<K> implements Iterator<K> {
        int indexPosition = 0;
        List<K> internalList;

        public CustomIterator(Map<V, K> associationTable) {
            internalList = new ArrayList<>(associationTable.values());
        }

        @Override
        public boolean hasNext() {
            if (internalList.size() > indexPosition) {
                return true;
            }
            return false;
        }

        @Override
        public K next() {
            K val = internalList.get(indexPosition);
            indexPosition++;
            return val;
        }
    }

}


