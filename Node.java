/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;

/**
 *
 * @author ralph
 */
public class Node<T  extends Comparable<T>> {
    private T item;
    private Node<T> left;
    private Node<T> right;
    public Node(T Item)
    {
        item =Item;
    }
    public Node<T>  getLeft()
    {
        return left;
    }
    public Node<T>  getRight()
    {
        return right;
    }
    public void setLeft(T leftData){
        left =new Node(leftData);
    
    }
    
    public void setLeftNode(Node<T> leftData){
        left =leftData;
    
    }
    public void setRight(T rightData){
        right =new Node(rightData);
    
    }
    
    public void setRightNode(Node<T>  rightData){
        right = rightData;
    
    }
    
    public T getData(){
        return item;
    }
    
    public void setData(T newValue){
        item = newValue;
    }
    
    
    
    public boolean isLeaf()
    {
        boolean retval =false;
        if( left==null && right ==null){
            retval =true;
        }
        return retval;
            }
    
    
    public boolean hasBothSides()
{
    boolean retval = false;
    if( left!=null && right !=null){
            retval =true;
        }


    return retval;
}
     public T minValue() {
            if (left == null)
                  return item;
            else
                  return left.minValue();
      }


}




    
