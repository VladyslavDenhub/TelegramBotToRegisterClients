package bot.second.botSecond.sevice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final TelegramBot bot;
    @Autowired
    public SendBotMessageServiceImpl(TelegramBot bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(String chatId, String message, SendMessage sendMessage) {

        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            TelegramBot.LOGGER.error("EEEEEEEEEEERRRRRRRRRRRR: "+ e.getMessage());
        }
    }
}
