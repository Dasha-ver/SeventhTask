package by.epamtc.viaryshko.task07.entity;

public class Sentence extends TextComponent {

    private Word word;
    private PunctuationMark punctuationMark;
    private String line;

    public Sentence(String line){

        this.line = line;
    }

    public String getComponent(){
        return line;
    }

    public void print(){

        System.out.println(getComponent());
    }
}
