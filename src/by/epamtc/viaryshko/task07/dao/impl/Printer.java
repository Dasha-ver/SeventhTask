package by.epamtc.viaryshko.task07.dao.impl;

import by.epamtc.viaryshko.task07.entity.TextComponent;

public class Printer {
    TextComponent allText;

    public Printer(TextComponent allText){

        this.allText = allText;
    }

    public void printText(){

        allText.print();
    }
}
