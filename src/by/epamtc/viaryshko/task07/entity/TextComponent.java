package by.epamtc.viaryshko.task07.entity;

import java.io.Serializable;

public abstract class TextComponent implements Serializable {


    public String getComponent(){
        throw new UnsupportedOperationException();
    }

    public void add(TextComponent textComponent){
        throw new UnsupportedOperationException();
    }

    public TextComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

    public void print(){
        throw new UnsupportedOperationException();
    }

    public String receiveComponentByStrings(){
        throw new UnsupportedOperationException();
    }
}
