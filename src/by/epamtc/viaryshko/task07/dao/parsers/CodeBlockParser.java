package by.epamtc.viaryshko.task07.dao.parsers;

import by.epamtc.viaryshko.task07.dao.DAOException;
import by.epamtc.viaryshko.task07.dao.impl.Printer;
import by.epamtc.viaryshko.task07.dao.impl.RegularExpressionFinder;
import by.epamtc.viaryshko.task07.dao.impl.TextDAOImpl;
import by.epamtc.viaryshko.task07.entity.CodeBlock;
import by.epamtc.viaryshko.task07.entity.Text;
import by.epamtc.viaryshko.task07.entity.TextComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeBlockParser {

    private static Pattern pattern;
    private static Matcher matcher;
    private static Text resultText;

    public static Text receiveOnlyCodeBlock(String stringForParsing) throws DAOException {

        resultText = new Text();
        pattern = Pattern.compile(RegularExpressionFinder.receiveRegularExpression("codeBlockFinder"), Pattern.MULTILINE);
        matcher = pattern.matcher(stringForParsing);

        while (matcher.find()) {

            TextComponent textComponent = new CodeBlock(matcher.group().trim() + "\n" + "}");
            resultText.add(textComponent);
        }

        return resultText;
    }

    public static void main(String[] args) throws DAOException {

        Printer printer = new Printer(CodeBlockParser.receiveOnlyCodeBlock(TextDAOImpl.getAllText().receiveTextByOrdinalStrings()));
        printer.printText();

    }
}

