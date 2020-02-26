package org.example;

import org.glassfish.hk2.utilities.reflection.MethodWrapper;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;

public class Bot extends TelegramLongPollingBot {

    private String botToken = "995771556:AAEBwtZ4LCh-x0UaroZjwIKexJuPtLjMWxA";
    private String botUserName = "@vladichtest_bot";

    public void onUpdateReceived(Update update) {

        MessageChecker msgChecker = new MessageChecker(update.getMessage());

        String response = msgChecker.checkMessageText();

        sendMsg(update.getMessage().getChatId(), response);

    }


    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public String getBotUserName() {
        return botUserName;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public void sendMsg(Long chatId, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return botUserName;
    }

    public String getBotToken() {
        return botToken;
    }
}
