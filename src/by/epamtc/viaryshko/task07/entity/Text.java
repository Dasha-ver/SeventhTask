package by.epamtc.viaryshko.task07.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Text extends TextComponent implements Serializable {

    private TextComponent textComponent;
    private List<TextComponent> listWithTextComponents = new ArrayList<>();
    private StringBuilder stringBuilder;
    private Iterator<TextComponent> iterator;

    public Text() {

    }

    public void add(TextComponent textComponent) {
        this.textComponent = textComponent;
        listWithTextComponents.add(textComponent);
    }

    public void remove(TextComponent textComponent){
        this.textComponent = textComponent;
        listWithTextComponents.remove(textComponent);
    }

    public TextComponent getChild(int i) {
        return listWithTextComponents.get(i);
    }

    public String getComponent() {
        return textComponent.getComponent().replace("\n", "");
    }

    public List<TextComponent> getListWithTextComponents(){
        return listWithTextComponents;
    }

    public String receiveComponentByStrings(){

        stringBuilder = new StringBuilder();

        iterator = listWithTextComponents.iterator();
        while(iterator.hasNext()) {

            TextComponent textComponent = iterator.next();
            stringBuilder.append(textComponent.getComponent().replace("\n",""));
        }
        return stringBuilder.toString();
    }

    public String receiveTextByOrdinalStrings(){

        stringBuilder = new StringBuilder();

      iterator = listWithTextComponents.iterator();
        while(iterator.hasNext()) {

            TextComponent textComponent = iterator.next();
            stringBuilder.append(textComponent.getComponent()+"\n");
        }
        return stringBuilder.toString();
    }

    public void print(){

        iterator = listWithTextComponents.iterator();
        while(iterator.hasNext()){

            TextComponent textComponent = iterator.next();
            textComponent.print();
        }
    }
}
