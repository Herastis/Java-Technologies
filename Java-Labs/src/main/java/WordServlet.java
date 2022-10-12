/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/wordServlet"})
public class WordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String word = request.getParameter("word");
        Integer size = Integer.valueOf(request.getParameter("size"));

        //1)Letters of word in ordered list
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        String htmlRespone = "<html>";

        htmlRespone += "<h2>Ordered list: [";
        htmlRespone += chars[0];
        for (int i = 1; i < chars.length; ++i) {
            htmlRespone += ", " + chars[i];
        }
        htmlRespone += "]. </h2> </br>";

        //2)Returns all the permutations of length size
        ArrayList<String> permutations = getPermutation(word, "", size);
        if (size > word.length()) {
            htmlRespone += "<h2>Size of permutation is bigger than the word size!<h2>";
        } else {
            htmlRespone += "<h2>Permutations: " + permutations + "</h2>";
            htmlRespone += "</html>";
        }

        //3)Return only the sequence forming valid words from a dictionary
        //Search in dictionary for all the sequences forming valid words
        ArrayList<String> sequences = getPermutation(word, "", 0);
        ArrayList<String> validWordsSequence = readFromDictionary(sequences);
        htmlRespone += "<h2>Valid words sequence: " + validWordsSequence + "</h2>";
        writer.println(htmlRespone);
    }

    private static void permutation(String word, String prefix, int size, ArrayList<String> res) {
        if (prefix.length() == size) {
            res.add(prefix);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(word.substring(0, i)
                        + word.substring(i + 1, word.length()), prefix + word.charAt(i), size, res);
            }
        }
    }

    private static ArrayList<String> getPermutation(String word, String prefix, int size) {
        //Array with permutations
        ArrayList<String> res = new ArrayList<>();
        if (size == 0) {
            // If the size is 0 (default), it will return all the sequences.
            for (int i = 1; i <= word.length(); i++) {
                permutation(word, prefix, i, res);
            }
        } else {
            permutation(word, prefix, size, res);
        }
        return res;
    }

    private static ArrayList<String> readFromDictionary(ArrayList<String> permutations) throws FileNotFoundException {
        ArrayList<String> validWordsSequence = new ArrayList<>();
        try ( Scanner scanner = new Scanner(new File("F:\\Github\\Java-Technologies\\Dictionary.txt"))) {
            String onePermutation;
            while (scanner.hasNextLine()) {
                //Get each word from the dictionary file
                String word = scanner.nextLine();
                for (int i = 0; i < permutations.size(); i++) {
                    //Get each permutation
                    onePermutation = permutations.get(i);
                    if (onePermutation.toLowerCase().equals(word.toLowerCase())) {
                        //Add to the seuqence  all the valid words
                        validWordsSequence.add(word);
                        //delete word from list of permutations after being found in dictionary
                        permutations.remove(i);
                    }
                }
            }
        }
        return validWordsSequence;
    }
}
