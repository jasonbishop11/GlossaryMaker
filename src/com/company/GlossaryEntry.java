package com.company;

import java.util.ArrayList;

public class GlossaryEntry {

    private String word;
    private ArrayList<Integer> numsList;

    public GlossaryEntry(String w){
        word = w.toUpperCase();
        numsList = new ArrayList<Integer>();
    }

    public void add(int num){
        boolean exists = false;
        for(int i=0; i<numsList.size()-1; i++){
            if(numsList.get(i)==num){
                exists = true;
            }
        }
        if(!exists){
            numsList.add(num);
        }
    }

    public String getWord(){
        return word;
    }

    public String toString(){
        String line = word;
        for(int i=0; i<numsList.size(); i++){
            line +=  " " + numsList.get(i);
        }
        return line;
    }

    public static void main(String[] args) {
        GlossaryEntry ge = new GlossaryEntry("Hello");
        ge.add(5);
        ge.add(7);
        ge.add(5);
        ge.add(12);
        System.out.println(ge);
    }
}


