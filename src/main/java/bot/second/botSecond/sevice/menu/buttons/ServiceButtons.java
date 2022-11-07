package bot.second.botSecond.sevice.menu.buttons;

import bot.second.botSecond.sevice.SendBotMessageService;
import bot.second.botSecond.sevice.container.comands.Command;
import bot.second.botSecond.sevice.menu.MasterMenu;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ServiceButtons implements Command {
    private final SendBotMessageService sendBotMessageService;
    private static final String text = "Choose the master please.";

    public ServiceButtons(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();
        MasterMenu menu = new MasterMenu();
        SendMessage sendMessage = initSendMessage(id, menu);
        sendBotMessageService.sendMessage(id, text, sendMessage);
    }
}
