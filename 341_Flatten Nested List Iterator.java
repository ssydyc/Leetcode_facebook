/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private ArrayList<Integer> flatList = new ArrayList<Integer>();
    private int cur = 0;
    
    private ArrayList<Integer> flatNestedList(List<NestedInteger> nestedList) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(NestedInteger curNestedInteger: nestedList) {
            if(curNestedInteger.isInteger()) {
                res.add(curNestedInteger.getInteger());
            }
            else {
                res.addAll(flatNestedList(curNestedInteger.getList()));
            }
        }
        
        return res;
    }
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flatList = flatNestedList(nestedList);
    }

    @Override
    public Integer next() {
        return flatList.get(cur++);
    }

    @Override
    public boolean hasNext() {
        return cur < flatList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
