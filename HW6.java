/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ralph
 */
public class HW6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length <= 0) {
            ///unit testing of binary tree class
            BinaryTree<Integer> iTree = new BinaryTree<>();
            iTree.AddItem(22);
            iTree.AddItem(20);
            iTree.AddItem(44);
            iTree.AddItem(29);
            iTree.AddItem(17);
            iTree.AddItem(19);
            iTree.AddItem(29);
            iTree.AddItem(20);
            iTree.AddItem(17);
            System.out.println("----------------------------------");
            iTree.printTree();
            System.out.println("Iterate Nodes-");
            for( Node<Integer> i : iTree)
            {
                System.out.println(i);
            }
            System.out.println("Test Search");
            Integer iFindMe = iTree.Search(5);
            if (iFindMe != null) {
                System.out.println(iFindMe);
            } else {
                System.out.println("NOT FOUND");
            }
            iFindMe = iTree.Search(44);
            if (iFindMe != null) {
                System.out.println(iFindMe);
            } else {
                System.out.println("NOT FOUND");
            }
            // Test Delete

            boolean rm = iTree.RemoveNode(44);
            if (rm) {
                System.out.println("__________________________________");
                iTree.printTree();

            } else {
                System.out.println("NOPE");

            }

        } else if (args[0].equals("-f")) {
            // test using integer array files
            String fname = args[1];
            BinaryTree<String> stringTree = new BinaryTree<>();
            List<String> testSentances = LoadFile(fname);
            for( String s : testSentances){
                
            
            
            }
            
        
        }
        
    }
    public static List<String> LoadFile ( String FullFileName){
        List<String> retval = new LinkedList<String>();
        
    File InputFile = new File(FullFileName);
        try {
            FileReader inputFileReader = new FileReader(InputFile);
            BufferedReader InputReader = new BufferedReader(inputFileReader);

            String line;
            while ((line = InputReader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    retval.add(line);
                }
            }
            inputFileReader.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    
        return retval;
    
    }
    
    
    
    
    public static void FillTreeWithSentance( String Sentance, BinaryTree<String> tree)
    {   
        String[] words = Sentance.split("\\W+");
        for( String word : words){
            tree.AddItem(word);
        }
        System.out.println(Sentance);
        tree.printTree();
    }
}
