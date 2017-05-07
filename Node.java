package hw6;

/**
 * Node class to be used by Binary Tree
 *
 * @author ralph
 */
public class Node<T extends Comparable<T>> {

    private T item;  // data item
    private Node<T> left;  // left node
    private Node<T> right; // right node
    private long count = 0; // count of items

    /**
     * Constructor for node with no childred
     *
     * @param Item
     */
    public Node(T Item) {
        item = Item;
        count=1;
    }

    /**
     * *
     * gets left node
     *
     * @return left node
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Gets right node
     *
     * @return right node
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * *
     * Sets left with newData
     *
     * @param leftData data for left node
     */
    public void setLeft(T leftData) {
        left = new Node(leftData);

    }

    /**
     * *
     * Sets left node with existing Node
     *
     * @param leftData the left node
     */
    public void setLeftNode(Node<T> leftNode) {
        left = leftNode;

    }

    /**
     * *
     * creates right noded with data
     *
     * @param rightData the data for the new right node
     */
    public void setRight(T rightData) {
        right = new Node(rightData);

    }

    /**
     * *
     * Sets right node to an existing NOde
     *
     * @param rightData the node to set right to
     */
    public void setRightNode(Node<T> rightData) {
        right = rightData;

    }

    /**
     * *
     * gets the Item (data) from the node
     *
     * @return
     */
    public T getData() {
        return item;
    }

    /**
     * *
     * sets the item( data) of the node to a new value
     *
     * @param newValue the new value
     */
    public void setData(T newValue) {
        item = newValue;
    }

    /**
     * *
     * determines if this node is a leaf
     *
     * @return true if leaf
     */
    public boolean isLeaf() {
        boolean retval = false;
        if (left == null && right == null) {
            retval = true;
        }
        return retval;
    }

    /**
     * *
     * indicates that the node has both left and right nodes
     *
     * @return
     */
    public boolean hasBothSides() {
        boolean retval = false;
        if (left != null && right != null) {
            retval = true;
        }

        return retval;
    }

    /**
     *  minimum value of tree created by this node
     * @return minimum value of tree with this node as head 
     */
    public T minValue() {
        if (left == null) {
            return item;
        } else {
            return left.minValue();
        }
    }

    /***
     * increments count for this node
     */
    public void incCount() {
        count++;
    }
    
    /**
     * gets count for this node
     * @return 
     */
    public long getCount(){
        return count;
    
    }
    
    /***
     * sets the count for this item
     * only used in delete function
     * @param count number of items  
     */
    public void setCount(long count){
        this.count = count;
    
    }
            
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append(item);
         sb.append(" ");
         sb.append(count);
         
         return sb.toString();
     } 
    

}
