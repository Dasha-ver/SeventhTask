package by.epamtc.viaryshko.task07.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Text extends TextComponent {

    private TextComponent textComponent;
    private List<TextComponent> textComponents = new ArrayList<>();
    private StringBuilder stringBuilder;

    public Text() {

    }

    public void add(TextComponent textComponent) {
        this.textComponent = textComponent;
        textComponents.add(textComponent);
    }

    public TextComponent getChild(int i) {
        return textComponents.get(i);
    }

    public String getComponent() {
        return textComponent.getComponent();
    }

    public List<TextComponent> getTextComponents(){
        return textComponents;
    }

    public String receiveTextByString(){

        stringBuilder = new StringBuilder();
        Iterator<TextComponent> iterator = textComponents.iterator();
        while(iterator.hasNext()) {

            TextComponent textComponent = iterator.next();
            stringBuilder.append(textComponent.getComponent());
        }
        return stringBuilder.toString();
    }

    public void print(){

        Iterator<TextComponent> iterator = textComponents.iterator();
        while(iterator.hasNext()){

            TextComponent textComponent = iterator.next();
            textComponent.print();
        }
    }
}
