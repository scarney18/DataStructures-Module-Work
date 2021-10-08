import java.util.ArrayList;
import java.util.Arrays;

/*
 * Map implementation using hash table with separate chaining.
 */

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    // a fixed capacity array of UnsortedTableMap that serve as buckets
    private UnsortedTableMap<K, V>[] table; // initialized within createTable

    /**
     * Creates a hash table with capacity 11 and prime factor 109345121.
     */
    public ChainHashMap() {
        super();
    }

    /**
     * Creates a hash table with given capacity and prime factor 109345121.
     */
    public ChainHashMap(int cap) {
        super(cap);
    }

    /**
     * Creates a hash table with the given capacity and prime factor.
     */
    public ChainHashMap(int cap, int p) {
        super(cap, p);
    }
    
    /*private void resize(int newCap) {
    	UnsortedTableMap<K,V>[] newTable = new UnsortedTableMap[newCap];
    	K key = null;
    	for(int i=0; i<this.capacity; i++) {
    		UnsortedTableMap<K,V> bucket = table[i];
    		int hash = hashValue(bucket.get(0));
    		newTable[hash] = bucket;
    	}
    	table = newTable;
    }*/

    public static void main(String[] args) {
        //HashMap<Integer, String> m = new HashMap<Integer, String>();
        ChainHashMap<Integer, String> m = new ChainHashMap<Integer, String>(10);
        
        m.put(1, "One");
        m.put(10, "Ten");
        m.put(11, "Eleven");
        m.put(20, "Twenty");

        System.out.println("m: " + m);

        m.remove(11);
        System.out.println("m: " + m);
        
        System.out.println(m.get(1));
        
        //m.resize(20);
        //System.out.println("m: " + m);
        
//		ChainHashMap<String, Integer> counter = new ()//;
//		// Scanner from file
//		for(String word : scanner) {
//			Integer old_count = counter.get(word);
//			counter.put(old_count + 1);
//		}
    }

    /**
     * Creates an empty table having length equal to current capacity.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    protected void createTable() {
        //initialise table with current capacity
    	table = new UnsortedTableMap[this.capacity];
    }

    /**
     * Returns value associated with key k in bucket with hash value h. If no such
     * entry exists, returns null.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @return associate value (or null, if no such entry)
     */
    @Override
    protected V bucketGet(int h, K k) {
    	//create bucket variable and return the hash value in the given key
    	UnsortedTableMap<K,V> bucket = table[h];
    	if(bucket == null) {
    		return null;
    	}
    	return bucket.get(k);
    }

    /**
     * Associates key k with value v in bucket with hash value h, returning the
     * previously associated value, if any.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @param v the value to be associated
     * @return previous value associated with k (or null, if no such entry)
     */
    @Override
    protected V bucketPut(int h, K k, V v) {
    	UnsortedTableMap<K,V> bucket = table[h];
    	if(bucket == null) {
    		//create the bucket if it doesn't exist
    		bucket = new UnsortedTableMap<K,V>();
    		table[h] = bucket;
    	}
    	V removed = bucket.put(k, v);
        return removed;
    }

    /**
     * Removes entry having key k from bucket with hash value h, returning the
     * previously associated value, if found.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @return previous value associated with k (or null, if no such entry)
     */
    @Override
    protected V bucketRemove(int h, K k) {	
    	n--;
    	UnsortedTableMap<K,V> bucket = table[h];
    	V removed = bucket.remove(k);
        return  removed;
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     * 
     */
    
    @Override
    public Iterable<Entry<K, V>> entrySet() {
		/*
		for each element in 	(UnsortedTableMap []) table
			for each element in bucket:
				print element
		*/
    	ArrayList<Entry<K, V>> entries = new ArrayList<>();
    	for(int i=0; i<table.length; i++) {
    		if(table[i] != null) {
    			for (Entry<K,V> entry : table[i].entrySet()) {
    				entries.add(entry);
    			}
    		}
    	}
    	return entries;
    }

    public String toString() {
        return Arrays.toString(table);
    }
}
