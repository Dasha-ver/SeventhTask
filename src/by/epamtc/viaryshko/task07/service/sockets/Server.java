package by.epamtc.viaryshko.task07.service.sockets;

import by.epamtc.viaryshko.task07.dao.DAOException;
import by.epamtc.viaryshko.task07.dao.impl.TextDAOImpl;
import by.epamtc.viaryshko.task07.dao.parsers.SentenceParser;
import by.epamtc.viaryshko.task07.dao.parsers.WordParser;
import by.epamtc.viaryshko.task07.dao.tasks.First;
import by.epamtc.viaryshko.task07.dao.tasks.Second;
import by.epamtc.viaryshko.task07.dao.tasks.Third;
import by.epamtc.viaryshko.task07.entity.Text;
import by.epamtc.viaryshko.task07.entity.TextComponent;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.List;

import static by.epamtc.viaryshko.task07.dao.tasks.Third.receiveAllWords;
import static by.epamtc.viaryshko.task07.dao.tasks.Third.receiveWordsInFirstSentence;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try  {
                server = new ServerSocket(4004); // серверсокет прослушивает порт 4004
                System.out.println("Сервер запущен!"); // хорошо бы серверу
                //   объявить о своем запуске
                clientSocket = server.accept(); // accept() будет ждать пока
                //кто-нибудь не захочет подключиться
                try { // установив связь и воссоздав сокет для общения с клиентом можно перейти
                    // к созданию потоков ввода/вывода.
                    // теперь мы можем принимать сообщения
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    // и отправлять
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
                    System.out.println(word);
                    // не долго думая отвечает клиенту
                    if (word.equals("1")) {
                        Text text = SentenceParser.receiveOnlySentence(TextDAOImpl.getAllText().receiveTextByOrdinalStrings());
                        List<TextComponent> list = text.getListWithTextComponents();
                        out.write(First.receiveNumberOfSentenceWithRepeatedWords(list) + "\n");
                        out.flush(); // выталкиваем все из буфера
                    }

                    if(word.equals("2")){

                        Text text = SentenceParser.receiveOnlySentence(TextDAOImpl.getAllText().receiveTextByOrdinalStrings());
                        List<TextComponent> listWithAllText = text.getListWithTextComponents();
                        List<TextComponent> listWithFirstSentenceWords = WordParser.receiveOnlyWord(listWithAllText.get(0).getComponent());

                        Collection<String> str =Third.differentWord(receiveAllWords(listWithAllText), receiveWordsInFirstSentence(listWithFirstSentenceWords));
                        out.write(str.toString());
                        out.flush();
                    }
                } finally { // в любом случае сокет будет закрыт
                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException | DAOException e) {
            System.err.println(e);
        }
    }
}
