package com.mycompany.lab1.controllers;

import com.mycompany.lab1.domain.entities.Word;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class WordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String inputWord = request.getParameter("word");
        Integer permutationSize = Integer.valueOf(request.getParameter("size"));

        ArrayList<String> permutations = getPermutation(inputWord, "", permutationSize);

        Word words = new Word(permutations, permutationSize);
        request.setAttribute("words", words);

        ArrayList<String> emptyList = new ArrayList<String>();
        String nextPage = (words.getWordSequence() != emptyList ? "/result.jsp" : "/input.jsp");

        getServletContext().getRequestDispatcher(nextPage)
                .forward(request, response);
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
}
