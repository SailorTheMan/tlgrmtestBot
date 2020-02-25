package org.example;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Random;

public class MessageChecker {

    private Message msg;

    public MessageChecker(Message msg){
        this.msg = msg;
    }

    public String checkMessageText() {

        if (msg.getText().charAt(0) == '/'){
            return comandCheck(msg.getText());
        }

        else{
            return "А может всё-таки рандомное число бахнуть?";
        }

    }

    private String comandCheck(String msg){
        if (msg.equals(Comands.START.getComand())){ return "Привет, я тупо бот. Нихера не умеюю Вот! " +
                "Могу бахнуть тебе рандомное число. Для этого напиши <b>/random</b> и всё!"; }

        if (msg.equals(Comands.HELP.getComand())) { return "Я хз как я тут работю, постарайся меня не сломать и все!"; }

        if (msg.equals(Comands.RANDOM.getComand())) {
            Integer rnd = new Random().nextInt(1000);
            return rnd.toString();
        }

        else { return "Я не понел че ты хочешь"; }
    }

}
