package com.mycompany.lab1.domain.entities;

import java.util.ArrayList;
//The Bean

public class Word {

    private ArrayList<String> wordSequence;
    private int permutationSize;

    public int getPermutationSize() {
        return permutationSize;
    }

    public void setPermutationSize(int permutationSize) {
        this.permutationSize = permutationSize;
    }

    public ArrayList<String> getWordSequence() {
        return wordSequence;
    }

    public void setWordSequence(ArrayList<String> wordSequence) {
        this.wordSequence = wordSequence;
    }

    public Word(ArrayList<String> inputWord, int permutationSize) {
        this.wordSequence = inputWord;
        this.permutationSize = permutationSize;
    }

}
