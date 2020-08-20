package by.epamtc.viaryshko.task07.dao.impl;

import by.epamtc.viaryshko.task07.dao.DAOException;
import by.epamtc.viaryshko.task07.entity.OrdinalString;
import by.epamtc.viaryshko.task07.entity.Text;
import by.epamtc.viaryshko.task07.entity.TextComponent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TextDAOImpl {

    public static final String PATH_TO_FILE = "resources/text.txt";

    public static Text getAllText () throws DAOException {

        Text text;
        FileReader reader = null;
        try {
            text = new Text();
            reader = new FileReader(PATH_TO_FILE);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineForRead = "";
            int lineCounter = 0;

            while ((lineForRead = bufferedReader.readLine()) != null) {
                lineCounter++;
                TextComponent textComponent = new OrdinalString(lineForRead);
                            text.add(textComponent);
            }
        } catch (Exception e) {
            throw new DAOException(e);

        } finally {

            if (reader != null) {
                try {

                    reader.close();

                } catch (Exception e) {
                    // log - error
                    System.err.println(e);

                }
            }
        }
         return text;
    }

}

