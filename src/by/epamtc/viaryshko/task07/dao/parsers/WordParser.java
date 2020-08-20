package by.epamtc.viaryshko.task07.dao.parsers;

import by.epamtc.viaryshko.task07.dao.DAOException;
import by.epamtc.viaryshko.task07.dao.impl.RegularExpressionFinder;
import by.epamtc.viaryshko.task07.dao.impl.TextDAOImpl;
import by.epamtc.viaryshko.task07.entity.Text;
import by.epamtc.viaryshko.task07.entity.TextComponent;
import by.epamtc.viaryshko.task07.entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser {

    private static Pattern pattern;
    private static Matcher matcher;

    public static String deletePunctuationMark(String stringForParsing) throws DAOException {

        pattern = Pattern.compile(RegularExpressionFinder.receiveRegularExpression("punctuationMarksFinder"));
        matcher = pattern.matcher(stringForParsing);

        return matcher.replaceAll(" ");
    }

    public static String deleteDoubleSpaces(String stringForParsing) throws DAOException {

        pattern = Pattern.compile(RegularExpressionFinder.receiveRegularExpression("doubleSpaceFinder.regexp"));
        matcher = pattern.matcher(stringForParsing);

        return matcher.replaceAll(" ");

    }

    public static List receiveOnlyWord(String stringForParsing) throws DAOException {

        List <TextComponent> listWithWord = new ArrayList<>();
        String sentenceWithoutPunctuationMark = deletePunctuationMark(stringForParsing);
        String sentenceWithoutDoubleSpaces = deletePunctuationMark(sentenceWithoutPunctuationMark);

        for (String word : sentenceWithoutDoubleSpaces.split("\\s")) {

            if (!word.equals("")) {
                TextComponent textComponent = new Word(word);
                listWithWord.add(textComponent);

            }
        }
        return listWithWord;
    }

    public static void main(String[] args) throws DAOException {

        Text text = SentenceParser.receiveOnlySentence(TextDAOImpl.getAllText().receiveTextByOrdinalStrings());
        List<TextComponent> list = text.getListWithTextComponents();

        for (TextComponent component : list) {
            List<TextComponent> lists = WordParser.receiveOnlyWord(component.getComponent());

            for (TextComponent textComponent : lists) {

                System.out.println(textComponent.getComponent());
            }
        }
    }
}
