package by.epamtc.viaryshko.task07.dao.tasks;

import by.epamtc.viaryshko.task07.dao.DAOException;
import by.epamtc.viaryshko.task07.dao.impl.TextDAOImpl;
import by.epamtc.viaryshko.task07.dao.parsers.SentenceParser;
import by.epamtc.viaryshko.task07.dao.parsers.WordParser;
import by.epamtc.viaryshko.task07.entity.Text;
import by.epamtc.viaryshko.task07.entity.TextComponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Third {

    public static List<String> receiveAllWords(List<TextComponent> allWordsInText) throws DAOException {

        List<String> allWords = new ArrayList<>();

        for (int i = 1; i < allWordsInText.size(); i++) {

            List<TextComponent> allText = WordParser.receiveOnlyWord(allWordsInText.get(i).getComponent());

            for (TextComponent textComponent : allText) {
                allWords.add(textComponent.getComponent());
            }
        }

        return allWords;
    }

    public static List<String> receiveWordsInFirstSentence(List<TextComponent> allWordsInFirstSentence) throws DAOException {

        List<String> firstSentenceWords = new ArrayList<>();

        for (TextComponent listWithFirstSentenceWord : allWordsInFirstSentence) {
            firstSentenceWords.add(listWithFirstSentenceWord.getComponent());

        }

        return firstSentenceWords;
    }

    public static Collection<String> differentWord(List<String> allWords, List<String> wordsInFirstSentence) {

        Collection<String> similar = new HashSet<String>(allWords);
        Collection<String> different = new HashSet<String>();
        different.addAll(allWords);
        different.addAll(wordsInFirstSentence);

        different.removeAll(similar);

        return different;
    }


    public static void main(String[] args) throws DAOException {


        Text text = SentenceParser.receiveOnlySentence(TextDAOImpl.getAllText().receiveTextByOrdinalStrings());
        List<TextComponent> listWithAllText = text.getListWithTextComponents();
        List<TextComponent> listWithFirstSentenceWords = WordParser.receiveOnlyWord(listWithAllText.get(0).getComponent());

        System.out.println(Third.differentWord(receiveAllWords(listWithAllText), receiveWordsInFirstSentence(listWithFirstSentenceWords)));
    }
}