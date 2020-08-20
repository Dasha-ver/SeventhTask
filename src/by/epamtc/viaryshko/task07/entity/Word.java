package by.epamtc.viaryshko.task07.entity;

import java.io.Serializable;

public class Word extends TextComponent implements Serializable {

    private String word;

    public Word(String word){

        this.word = word;
    }

    public String getComponent(){
        return word;
    }

    public void print(){

        System.out.println(getComponent());
    }
}


