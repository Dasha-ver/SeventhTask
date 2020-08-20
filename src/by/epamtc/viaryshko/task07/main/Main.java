package by.epamtc.viaryshko.task07.main;

import by.epamtc.viaryshko.task07.dao.DAOException;
import by.epamtc.viaryshko.task07.dao.impl.TextDAOImpl;
import by.epamtc.viaryshko.task07.dao.impl.Printer;
import by.epamtc.viaryshko.task07.entity.Text;

public class Main {

    public static void main(String [] args) throws DAOException {

        Printer printer = new Printer(TextDAOImpl.getAllText());
     //   printer.printText();
       Text text = TextDAOImpl.getAllText();
       System.out.print(text.receiveTextByOrdinalStrings());
    }
}
