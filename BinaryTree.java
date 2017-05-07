/*
 • search—finds and returns the node that matches a search key (if it exists; otherwise return
null)
• insert—inserts a node into the tree
• delete—deletes a node from the tree
• print—traverse (inorder) and print each node
• any methods you need to solve the problem of using a tree to make a word frequency his-
togram. You should be able to read a file and add a word if it isn’t in the tree yet and update
a counter associated with it if it is in the tree.
 */
package hw6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/*
• search—finds and returns the node that matches a search key (if it exists; otherwise return
null)
• insert—inserts a node into the tree
• delete—deletes a node from the tree
• print—traverse (inorder) and print each node






 */
/**
 * Binary tree with counting of like items
 *
 * @author ralph
 */
public class BinaryTree<T extends Comparable<T>>  implements Iterable<Node<T>>{

    private Node<T> Head; // this is the head of the Binary tree

    /**
     * *
     * Public AddItem for adding Item to Tree
     *
     * @param newItem the Item to add
     */
    public void AddItem(T newItem) {
        if (Head == null) {
            Head = new Node(newItem);

        } else {
            addItem(Head, newItem);

        }
    }

    /**
     * *
     *
     * @param <T> the datatype of the item
     * @param head node to start at in adding
     * @param newItem the itme to add
     * @return The Head of the
     */
    private <T extends Comparable<T>> Node<T> addItem(Node<T> head, T newItem) {
        if (head == null) {
            return new Node(newItem);
        }

        if (newItem.compareTo(head.getData()) < 0) {
            head.setLeftNode(addItem(head.getLeft(), newItem));

        }
        if (newItem.compareTo(head.getData()) > 0) {
            head.setRightNode(addItem(head.getRight(), newItem));

        }
        if (newItem.compareTo(head.getData()) == 0) {
            head.incCount();

        }

        return head;

    }

    /**
     * Searches for an item in the tree
     *
     * @param searchItem the itme to search for
     * @return The item to search for or null if not found
     */
    public T Search(T searchItem) {
        Node<T> retval = Search(Head, searchItem);
        if (retval != null) {
            return retval.getData();
        } else {
            return null;
        }
    }

    /**
     * *
     * Searches for an item starting with head node
     *
     * @param head node to start search on
     * @param searchItem item to search for
     * @return the node if found null if not found
     */
    private Node<T> Search(Node<T> head, T searchItem) {
        if (head == null) {
            return null;
        }
        if (head.getData().compareTo(searchItem) == 0) {
            return head;
        }
        if (searchItem.compareTo(head.getData()) < 0) {
            return Search(head.getLeft(), searchItem);

        }
        return Search(head.getRight(), searchItem);
    }

    /**
     * *
     * Prints the tree
     */
    public void printTree() {
        printTree(Head);

    }

    /**
     * *
     * Prints the tree starting from the specified node
     *
     * @param head
     */
    private void printTree(Node<T> head) {
        if (head != null) {
            printTree(head.getLeft());
            System.out.println(head);
            printTree(head.getRight());
        }
    }

    /**
     * *
     * Removes an item from the tree
     *
     * @param item the item to remove
     * @return true if item was found false if not
     */
    public boolean RemoveNode(T item) {
        if (Head == null) {
            return false;

        }
        if (Head.isLeaf()) {
            if (Head.getData().compareTo(item) != 0) {
                return false;
            } else {
                Head = null;
                return true;

            }
        }
        // not a leaf
        return (RemoveNode(item, Head, null));

    }

    /**
     * *
     * Removes node starting at current
     *
     * @param item item to be removed
     * @param current the node
     * @param parent parent of the node
     * @return true if found false if not
     */
    public boolean RemoveNode(T item, Node<T> current, Node<T> parent) {
        if (item.compareTo(current.getData()) < 0) {
            if (current.getLeft() != null) {
                return RemoveNode(item, current.getLeft(), current);

            } else {
                return false;

            }
        } else if (item.compareTo(current.getData()) > 0) {
            if (current.getRight() != null) {
                return RemoveNode(item, current.getRight(), current);

            } else {
                return false;
            }
        }
        // it is equal
        // handle the leaf first

        if (current.isLeaf()) {
            // easiest case just remove from parent
            if (current == parent.getLeft()) {
                parent.setLeftNode(null);

            } else {
                parent.setRightNode(null);

            }
        }

// handle most difficult case
        if (current.hasBothSides()) {
            current.setData(current.getRight().minValue());
            current.setCount(current.getRight().getCount());
            
            RemoveNode(current.getData(), current.getRight(), current);
        } else if (current == parent.getLeft()) {
            parent.setLeftNode((current.getLeft() != null) ? current.getLeft() : current.getRight());

        } else {
            parent.setRightNode((current.getLeft() != null) ? current.getLeft() : current.getRight());
        }

        return true;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new TreeIterator(this);
    }
    class TreeIterator implements Iterator<Node<T>>{
        private BinaryTree tree;
        private Stack<Node<T>> stack;
        TreeIterator(BinaryTree Tree){
            tree = Tree;
            stack = new Stack<>();
            fillStack(Head);
        }
        @Override
        public boolean hasNext() {
           return !stack.isEmpty();
        }

        @Override
        public Node<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack.pop();
        }
        private void fillStack(Node<T> root){
            if(root==null){
                return;
            }
            fillStack(root.getLeft());
            stack.push(root);
            fillStack(root.getRight());
        }
    }
}
