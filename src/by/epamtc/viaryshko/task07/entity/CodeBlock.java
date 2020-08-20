package by.epamtc.viaryshko.task07.entity;

import java.io.Serializable;

public class CodeBlock extends TextComponent implements Serializable {

    private Word word;
    private PunctuationMark punctuationMark;
    private String line;

    public CodeBlock(String line){

        this.line = line;
    }

    public String getComponent(){
        return line;
    }

    public void print(){

        System.out.println(getComponent());
    }

}
