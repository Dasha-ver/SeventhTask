package by.epamtc.viaryshko.task07.dao.parsers;

import by.epamtc.viaryshko.task07.dao.DAOException;
import by.epamtc.viaryshko.task07.dao.impl.Printer;
import by.epamtc.viaryshko.task07.dao.impl.TextDAOImpl;
import by.epamtc.viaryshko.task07.entity.Sentence;
import by.epamtc.viaryshko.task07.entity.Text;
import by.epamtc.viaryshko.task07.entity.TextComponent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserForSentence {

    private static final String SENTENCE_REGULAR_EXPRESSION = "(.+?[!?.]+)+?";
    private static final Pattern SENTENCE_PATTERN = Pattern.compile(SENTENCE_REGULAR_EXPRESSION);
    private TextDAOImpl textDAO = new TextDAOImpl();
    private TextComponent textComponent;
    private String textByString;
    private Text resultText = new Text();

    public Text parseSentences() throws DAOException {

        textByString = textDAO.getAllText().receiveTextByString();
        Matcher matcher = SENTENCE_PATTERN.matcher(textByString);
        String[] words = SENTENCE_PATTERN.split(textByString);
        while (matcher.find()) {
            textComponent = new Sentence(matcher.group().trim());
            resultText.add(textComponent);
        }

        return resultText;

    }

    public static void main(String[] args) throws DAOException {
        ParserForSentence p = new ParserForSentence();
        Printer printer = new Printer(p.parseSentences());
        printer.printText();


    }
}

