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
public class Node<T> {
    private T item;
    private Node<T> left;
    private Node<T> right;
    public Node<T>  getLeft()
    {
        return left;
    }
    public Node<T>  getRight()
    {
        return right;
    }
    public void setLeft(Node<T> node){
        left =node;
    
    }
    public void setRight(Node<T> node){
        right =node;
    
    }
    
    
}
