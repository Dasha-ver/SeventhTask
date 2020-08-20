package by.epamtc.viaryshko.task07.dao.impl;

import by.epamtc.viaryshko.task07.dao.DAOException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RegularExpressionFinder {

    public static final String PATH_TO_PROPERTIES = "resources/config.properties";

    public static String receiveRegularExpression(String name) throws DAOException {

        Properties properties = new Properties();

        try {

            FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);


        } catch (IOException e) {

            throw new DAOException(e);
        }

        return properties.getProperty(name).trim();
    }

    public static void main(String[] args) throws DAOException {

        String str = RegularExpressionFinder.receiveRegularExpression("codeBlockFinder");
        System.out.print(str);
    }

}
