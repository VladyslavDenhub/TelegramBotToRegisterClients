package bot.second.botSecond.sevice.container.comands;

import bot.second.botSecond.sevice.menu.BotMenu;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {

    void execute(Update update);

    default SendMessage initSendMessage(String id, BotMenu menu) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(id);
        menu.showMenu(sendMessage);
        return sendMessage;
    }
}
