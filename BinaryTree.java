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
public class BinaryTree<T extends Comparable<T>> {
    private Node<T> Head;
    public boolean AddItem(T newItem)
    {
        return true;
    }
    
    private Node<T> addItem(Node<T>  head, T newItem){
        if(head ==null){
            return new Node<T>( newItem);
        }
        
        if( newItem < head.getData()){
            
        
        }
    
    
    
    
    }
    
    
}
