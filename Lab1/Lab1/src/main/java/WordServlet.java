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

        String word = request.getParameter("word");
        Integer size = Integer.valueOf(request.getParameter("size"));

        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        System.out.println("Ordered list: " + Arrays.toString(chars));
        PrintWriter writer = response.getWriter();

        String htmlRespone = "<html>";
        htmlRespone += "<h2>Ordered list: [";

        htmlRespone += chars[0];
        for (int i = 0; i < chars.length; ++i) {
            htmlRespone += ", " + chars[i];
        }

        htmlRespone += "]. </h2> </br>";
//        htmlRespone += "<h2>Permutations: " + getPermutation(word, "", size) + "</h2>";
        htmlRespone += "</html>";
        writer.println(htmlRespone);
    }

//    private static String permutation(String word, String prefix, int size) {
//        if (prefix.length() != size) {
//            for (int i = 0; i < word.length(); i++) {
//                return permutation(word, prefix + word.charAt(i), size);
//            }
//        }
//        return prefix;
//    }
//
//    private static ArrayList<String> getPermutation(String word, String prefix, int size) {
//        ArrayList<String> res = new ArrayList<>();
//        for (int i = 0; i < word.length(); i++) {
//            res.add(permutation(word, prefix + word.charAt(i), size));
//        }
//
//        Collections.sort(res);
//        return res;
//    }
}
