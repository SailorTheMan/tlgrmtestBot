package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;

public class Bot extends TelegramLongPollingBot {

    private String botToken = "995771556:AAEBwtZ4LCh-x0UaroZjwIKexJuPtLjMWxA";
    private String botUserName = "@vladichtest_bot";

    public void onUpdateReceived(Update update) {

        String message = update.getMessage().getText();

        String response = messageTextChecker(message);




    }

    public String messageTextChecker(String message) {

        if (message.equals(Comands.START.getComand())){ return "Привет, я тупо бот. Нихера не умеюю Вот!"; }

        if (message.equals(Comands.HELP.getComand())) { return "Я хз как я тут работю, постарайся меня не сломать и все!"; }

        else {
            return "Не понел";
        }

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
