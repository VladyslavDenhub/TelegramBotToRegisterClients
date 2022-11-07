package bot.second.botSecond.sevice;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface SendBotMessageService {

    void sendMessage(String id, String message, SendMessage sendMessage);
}
