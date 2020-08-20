package by.epamtc.viaryshko.task07.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sentence extends TextComponent implements Serializable {

    private String line;
    private TextComponent textComponent;
    private List<TextComponent> listWithTextComponents = new ArrayList<>();
    private StringBuilder stringBuilder;
    private Iterator<TextComponent> iterator;

    public Sentence(String line){

        this.line = line;
    }

    public Sentence(){

    }

    public String getComponent(){
        return line;
    }

    public void add(TextComponent textComponent) {
        this.textComponent = textComponent;
        listWithTextComponents.add(textComponent);
    }

    public String receiveComponentByStrings(){

        stringBuilder = new StringBuilder();

        iterator = listWithTextComponents.iterator();
        while(iterator.hasNext()) {

            TextComponent textComponent = iterator.next();
            stringBuilder.append(textComponent.getComponent() + " ");
        }
        return stringBuilder.toString();
    }
    public List<TextComponent> getListWithTextComponents(){
        return listWithTextComponents;
    }

    public void print(){

        System.out.println(getComponent());
        }
    }

