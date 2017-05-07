package hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ralph
 */
public class HW6 {

    /** -f  file input example -f inputfile outputfile
     * if no output file is specified will output to console
     * -u Is for the user interface.  Displays a user interface for testing Binary Search Tree.
     * no params if you want to see unit testing
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length <= 0) {
            TextHeader("Unit testing");
            ///unit testing of binary tree class
            TextHeader("Adding Items");
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
            TextHeader("Printing ");
            iTree.printTree();
            TextHeader("Iterating");
            for (Node<Integer> i : iTree) {
                System.out.println(i);
            }
            TextHeader("Search");
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
            TextHeader("Delete");
            boolean rm = iTree.RemoveNode(44);
            if (rm) {
                System.out.println("__________________________________");
                iTree.printTree();

            } else {
                System.out.println("NOPE");

            }

        } else if (args[0].equals("-f")) {// testing using files
            //  -f TEST tout
            // test using integer array files
            String fname = args[1];
            BinaryTree<String> stringTree = new BinaryTree<>();
            List<String> testSentances = LoadFile(fname);
            for (String s : testSentances) {
                FillTreeWithSentance(s, stringTree);

                if (args.length > 2) {
                    SaveTreeToFile(s, stringTree, args[2]);

                }
                stringTree.EmptyTree();
            }

        } else if (args[0].equals("-u")) {
            // test using a
            // user interface
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new TreeTestForm().setVisible(true);
                }
            });

        }
    }

    /**
     * *
     * Loads a file into a List of strings
     *
     * @param FullFileName
     * @return list of strings for each line of file
     */
    public static List<String> LoadFile(String FullFileName) {
        List<String> retval = new LinkedList<>();

        File InputFile = new File(FullFileName);
        try (FileReader inputFileReader = new FileReader(InputFile);
                BufferedReader InputReader = new BufferedReader(inputFileReader)) {
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
    
    /***
     * Fills a tree with a sentance
     * Then prints the tree
     * @param Sentance the sentance to fill tree with
     * @param tree the tree to fill
     */
    public static void FillTreeWithSentance(String Sentance, BinaryTree<String> tree) {
        String[] words = Sentance.split("\\W+");
        for (String word : words) {
            tree.AddItem(word.toLowerCase());
        }

        TextHeader(Sentance);
        tree.printTree();
    }

    /**
     * *
     * tester function for easy printing of text to console
     *
     * @param header
     */
    public static void TextHeader(String header) {
        System.out.println();
        System.out.println(header);
        div();

    }

    /**
     * helper function for making div in console
     */
    public static void div() {
        System.out.println("----------------------------------");
    }

    /**
     * *
     * outputs a list to a file
     *
     * @param list takes any type of list
     * @param FullFileName the outputfile name
     */
    public static void SaveTreeToFile(String Sentance, BinaryTree<String> tree, String FullFileName) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(FullFileName, true), "utf-8"))) {

            writer.write(Sentance);
            writer.write("\n");

            for (Object srted : tree) {
                writer.write(srted.toString());
                writer.write("\n");
            }
            writer.write("\n");
        } catch (IOException IOexp) {
            System.err.println("Error outputting File");
            System.err.println(IOexp);
        }

    }

}
