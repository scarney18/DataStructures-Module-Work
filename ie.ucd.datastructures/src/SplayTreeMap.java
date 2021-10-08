import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;

public class SplayTreeMap<K, V> extends TreeMap<K, V> {

    /**
     * Constructs an empty map using the natural ordering of keys.
     */
    public SplayTreeMap() {
        super();
    }

    /**
     * Constructs an empty map using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the map
     */
    public SplayTreeMap(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Utility used to rebalance after a map operation.
     */
    private void splay(Position<Entry<K, V>> p) {
    	//loop while p is not the root node
        while(!isRoot(p)) {
        	//get the parent and grandparent of p
        	Position<Entry<K,V>> parent = parent(p);
        	Position<Entry<K,V>> gp = parent(parent);
        	//if p has no grandparent then only p needs to be rotated: 'zig case'
        	if(gp == null) {
        		rotate(p);
        	}
        	//the conditions below determine if p and it's parent node are both the same-sided child for their parent
        	//if both conditions are true, or both conditions are false do the 'zig zig case'
        	else if((p == left(parent)) == (parent == left(gp))) {
        		rotate(parent);
        		rotate(p);
        	}
        	//otherwise there will have to be a 'zig zag case'
        	else {
        		rotate(p);
        		rotate(p);
        	}
        }
    }

    /**
     * Overrides the TreeMap rebalancing hook that is called after a node access.
     * @param p
     */
    //@Override
    protected void rebalanceAccess(Position<Entry<K, V>> p) {
        //check if p is a leaf node
    	if(isExternal(p)) {
    		//if p is a leaf node make the parent of p the new node to splay
    		p = parent(p);
    	}
    	if(p != null) {
    		//splay p if it is not null
    		splay(p);
    	}
    }

    /**
     * Overrides the TreeMap rebalancing hook that is called after an insertion.
     * @param p
     */
    //@Override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        //splays the tree where p was inserted
    	splay(p);
    }

    /**
     * Overrides the TreeMap rebalancing hook that is called after a deletion.
     * @param p
     */
    //@Override
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
    	//if p is the root there is no need to splay the tree
    	if(!isRoot(p)) {
    		//splay the tree at the parent of the node p which is being removed
    		splay(parent(p));
    	}
    }

    public String toString() {
        return tree.toString();
    }

    public static void main(String[] args) {
		SplayTreeMap<Integer, Integer> treeMap = new SplayTreeMap<Integer, Integer>();

		//Integer[] arr = new Integer[]{44, 17, 88, 8, 32, 65, 97, 28, 54, 82, 93, 21,
        //        29, 76, 80};
        //Integer[] arr = new Integer[]{8,3,10,4,11,6,12,5,7,16,13,17,14};
        Integer[] arr = new Integer[]{8,3,10,4,11,6,5,7};
        List<Integer> intList = Arrays.asList(arr);
        //Collections.shuffle(intList);
        //Collections.sort(intList, Collections.reverseOrder());
        //Collections.reverse(intList);

        intList.forEach(x -> treeMap.put(x, x));

		System.out.println("treeMap \n" + treeMap);

		//treeMap.get(14);
        treeMap.remove(8);

        System.out.println("treeMap \n" + treeMap);
	}
}
