package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;

public class Bot extends TelegramLongPollingBot {

    private String botToken = "";
    private String botUserName = "";

    public void onUpdateReceived(Update update) {

        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId(), update.getMessage().getText());

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
