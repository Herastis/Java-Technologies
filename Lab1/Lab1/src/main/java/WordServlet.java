/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.sql.DriverManager.println;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        //Letters of word in ordered list
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        String htmlRespone = "<html>";

        htmlRespone += "<h2>Ordered list: [";
        htmlRespone += chars[0];
        for (int i = 1; i < chars.length; ++i) {
            htmlRespone += ", " + chars[i];
        }
        htmlRespone += "]. </h2> </br>";

        //Returns all the permutations of length size
        if (size > word.length()) {
            htmlRespone += "<h2>Size of permutation is bigger than the word size!<h2>";
        } else {
            htmlRespone += "<h2>Permutations: " + getPermutation(word, "", size) + "</h2>";
            htmlRespone += "</html>";
        }

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
            permutation(word, prefix, word.length(), res);
        }

        permutation(word, prefix, size, res);
        Collections.sort(res);
        return res;
    }
}
