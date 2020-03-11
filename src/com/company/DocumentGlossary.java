package com.company;

import java.util.ArrayList;

public class DocumentGlossary extends ArrayList<GlossaryEntry> {

    public DocumentGlossary(){
        super();
    }

    public DocumentGlossary(int length){
        super(length);
    }

    public void addWord(String word, int num){
        int pos = foundOrInserted(word);
        if(pos>0) {
            this.get(pos).add(num);
        }else{
            this.add(new GlossaryEntry(word));
            this.get(0).add(num);
        }
    }

    public void addAllWords(String str, int num){
        String [] s = str.split("\\W+");
        for(int i = 0; i<s.length; i++){
            addWord(s[i], num);
        }
    }

    private int foundOrInserted(String word){
        int pos = -1;
        for(int i=0; i<this.size()-1; i++) {
            if (this.get(i).getWord() == word) {
                pos = i;
            }
        }
        if(pos == -1){
            for(int i=0; i<this.size()-1; i++) {
                if (word.compareToIgnoreCase(this.get(i).getWord()) > 0) {
                    this.add(i, new GlossaryEntry(word));
                    pos = i;
                }
            }
            pos = this.size();
        }
        return pos;
    }

}
