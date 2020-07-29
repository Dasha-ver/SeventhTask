package by.epamtc.viaryshko.task07.entity;

public class OrdinalString extends TextComponent {

    private String line;

    public OrdinalString(String line){

        this.line = line;
    }

    public String getComponent(){
        return line;
    }

    public void print(){

        System.out.println(getComponent());
    }
}
