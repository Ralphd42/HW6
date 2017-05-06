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

/**
 *
 * @author ralph
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node<T> Head;

    public boolean AddItem(T newItem) {
        return true;
    }
    
    private <T extends Comparable<T>> Node<T> addItem(Node<T> head, T newItem) {
        if (head == null) {
            return new Node<>(newItem);
        }
       // if (newItem.compareTo(head.getData()) == 0) {
        //    return head;
        //}
        
        
        if (newItem.compareTo(head.getData()) < 0) {
            head.setLeft(addItem(head.getLeft(), newItem));

        }
        if (newItem.compareTo(head.getData()) > 0) {
            head.setRight(addItem(head.getRight(), newItem));

        }
        return head;

    }
    
    
public T Search(T searchItem)
{
    return Search(Head,searchItem).getData();
}
    
private Node<T> Search (Node<T> head, T searchItem){
    if(head==null){
        return null;
    }
    if( head.getData().compareTo(searchItem)==0)
    {
        return head;
    }
    if( searchItem.compareTo(head.getData())<0){
        return Search( head.getLeft(),searchItem);
    
    }
    return Search(head.getRight(),searchItem);
}

public void printTree()
{
    printTree(Head);

}



private void printTree( Node<T> head)
{
    if(head !=null){
        printTree(head.getLeft());
        System.out.println(head.getData());
        printTree(head.getRight());
    }
}


public boolean RemoveNode( T item, Node<T> current, Node<T> parent)
{
    if ( current==null)
    {
        return false;
    
    }
    // It is a match
    if( item.compareTo(current.getData())==0){
        if( current.   )
        
    
    }
    }

}


}
