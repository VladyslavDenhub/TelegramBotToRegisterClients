package bot.second.botSecond.sevice.menu.buttons;

import bot.second.botSecond.sevice.menu.ServicesMenu;
import bot.second.botSecond.sevice.SendBotMessageService;
import bot.second.botSecond.sevice.container.comands.Command;
import bot.second.botSecond.sevice.menu.StartMenu;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MastersButton implements Command {

    private final SendBotMessageService sendBotMessageService;
    private static final String text = "Ваш запис в обробці.\nЧейкайте на повідомленя від майстра";

    public MastersButton(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();
        StartMenu menu = new StartMenu();
        SendMessage sendMessage = initSendMessage(id, menu);
        sendBotMessageService.sendMessage(id, text, sendMessage);
    }
}
