package by.epamtc.viaryshko.task07.dao.parsers;

import by.epamtc.viaryshko.task07.dao.DAOException;
import by.epamtc.viaryshko.task07.dao.impl.Printer;
import by.epamtc.viaryshko.task07.dao.impl.RegularExpressionFinder;
import by.epamtc.viaryshko.task07.dao.impl.TextDAOImpl;
import by.epamtc.viaryshko.task07.entity.Sentence;
import by.epamtc.viaryshko.task07.entity.Text;
import by.epamtc.viaryshko.task07.entity.TextComponent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static Pattern pattern;
    private static Matcher matcher;

    public static String deleteCodeBlock(String stringForParsing) throws DAOException {

        pattern = Pattern.compile(RegularExpressionFinder.receiveRegularExpression("codeBlockFinder"));
        matcher = pattern.matcher(stringForParsing);

        return matcher.replaceAll("");
    }

    public static String deleteSerialNumberAndBrace(String stringForParsing) throws DAOException {

        pattern = Pattern.compile(RegularExpressionFinder.receiveRegularExpression("serialNumberAndBraceFinder"), Pattern.MULTILINE);
        matcher = pattern.matcher(deleteCodeBlock(stringForParsing));

        return matcher.replaceAll("");

    }

    public static String smashBeforeThe(String stringForParsing) throws DAOException {

        pattern = Pattern.compile(RegularExpressionFinder.receiveRegularExpression("beforeTheFinder"));
        matcher = pattern.matcher(deleteSerialNumberAndBrace(stringForParsing));

        return matcher.replaceAll(".The");

    }

    public static String deletePointsAtTheBeginningOfLine(String stringForParsing) throws DAOException {

        pattern = Pattern.compile(RegularExpressionFinder.receiveRegularExpression("pointsAtTheBeginningOfLineFinder"));
        matcher = pattern.matcher(smashBeforeThe(stringForParsing));

        return matcher.replaceAll("");

    }

    public static String deleteExtraPoints(String stringForParsing) throws DAOException {

        pattern = Pattern.compile(RegularExpressionFinder.receiveRegularExpression("extraPointsFinder"));
        matcher = pattern.matcher(deletePointsAtTheBeginningOfLine(stringForParsing));

        return matcher.replaceAll(".");

    }

    public static Text receiveOnlySentence(String stringForParsing) throws DAOException {

        Text resultText = new Text();
        String textWithoutCodeBlock = deleteCodeBlock(stringForParsing);
        String textWithoutSerialNumbersAndBrace = deleteSerialNumberAndBrace(textWithoutCodeBlock);
        String textWithSmashBeforeThe = smashBeforeThe(textWithoutSerialNumbersAndBrace);
        String textWithoutPointsAtTheBeginningOfLine = deletePointsAtTheBeginningOfLine(textWithSmashBeforeThe);
        String textWithoutExtraPoints = deleteExtraPoints(textWithoutPointsAtTheBeginningOfLine);
        pattern = Pattern.compile(RegularExpressionFinder.receiveRegularExpression("sentenceFinder"));
        matcher = pattern.matcher(textWithoutExtraPoints.replace("\n", ""));

        while (matcher.find()) {

            TextComponent textComponent = new Sentence(matcher.group().trim());
            resultText.add(textComponent);
        }

        return resultText;
    }


    public static void main(String[] args) throws DAOException {

        Printer printer = new Printer(SentenceParser.receiveOnlySentence(TextDAOImpl.getAllText().receiveTextByOrdinalStrings()));
        printer.printText();

    }
}
