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
public class HW6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree<Integer> iTree = new BinaryTree<>();
        iTree.AddItem(22);
        iTree.AddItem(20);
        iTree.AddItem(44);
        iTree.AddItem(29);
        iTree.AddItem(17);
        iTree.AddItem(19);
        System.out.println("----------------------------------");
        iTree.printTree();
        
        System.out.println("Test Search");
        
        Integer iFindMe = iTree.Search(5);
        if(iFindMe!=null){
            System.out.println(iFindMe);
        }else
        {System.out.println("NOT FOUND");
        }
        iFindMe = iTree.Search(44);
        if(iFindMe!=null){
            System.out.println(iFindMe);
        }else
        {System.out.println("NOT FOUND");
        }
        // Test Delete
        
        boolean rm =iTree.RemoveNode(44);
        if( rm)
        {
            System.out.println("__________________________________");
            iTree.printTree();
            
        
        
        }else
        {
            System.out.println("NOPE");
            
        }
        
        
    }
}
    

