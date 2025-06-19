package data_structure;

public class HashSet<V> {

    private static final Object EMPTY_VALUE = new Object();

    private final HashMap<V, Object> hashMap;

    public HashSet() {
        this.hashMap = new HashMap<>();
    }

    public void add(V value) {
        hashMap.put(value, EMPTY_VALUE);
    }

    public boolean contains(V value) {
        return hashMap.contains(value);
    }

    public boolean delete(V value) {
        if (hashMap.contains(value)) {
            hashMap.delete(value);
            return true;
        }
        return false;
    }

    public int size() {
        return hashMap.entrySet().size();
    }

    /*
    * for test
    * */
    public void print() {
        hashMap.entrySet().forEach(entry -> {
            System.out.println("value : " + entry.getKey());
        });
    }

    public static void main(String[] args) {
        HashSet<String> stringSet = new HashSet<>();

        stringSet.add("contents");
        stringSet.add("valuable");
        stringSet.add("mvp");
        stringSet.add("claude");
        stringSet.add("gpt");
        stringSet.add("valuable");

        stringSet.print();
        System.out.println("size = " + stringSet.size());
        System.out.println("--- cut ---");

        stringSet.delete("valuable");
        stringSet.delete("none value");

        stringSet.print();
        System.out.println("size = " + stringSet.size());
        System.out.println("--- cut ---");

        stringSet.add("valuable");
        stringSet.add("none value");

        stringSet.print();
        System.out.println("size = " + stringSet.size());
        System.out.println("--- cut ---");
    }
}
