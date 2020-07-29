package by.epamtc.viaryshko.task07.dao.impl;

import by.epamtc.viaryshko.task07.dao.DAOException;
import by.epamtc.viaryshko.task07.entity.OrdinalString;
import by.epamtc.viaryshko.task07.entity.Text;
import by.epamtc.viaryshko.task07.entity.TextComponent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TextDAOImpl {

    private TextComponent textComponent;
    private Text text;
    private FileReader reader;
    BufferedReader bufferedReader;


    public Text getAllText () throws DAOException {

        try {
            text = new Text();
            reader = new FileReader("resources/text.txt");
            bufferedReader = new BufferedReader(reader);
            String lineForRead = "";
            int lineCounter = 0;

            while ((lineForRead = bufferedReader.readLine()) != null) {
                lineCounter++;
                textComponent = new OrdinalString(lineForRead);
                            text.add(textComponent);
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(e);

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

