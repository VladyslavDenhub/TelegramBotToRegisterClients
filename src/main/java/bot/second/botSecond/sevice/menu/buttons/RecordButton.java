package bot.second.botSecond.sevice.menu.buttons;

import bot.second.botSecond.sevice.menu.MasterMenu;
import bot.second.botSecond.sevice.container.comands.Command;
import bot.second.botSecond.sevice.SendBotMessageService;
import bot.second.botSecond.sevice.menu.ServicesMenu;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class RecordButton implements Command {
    private final SendBotMessageService sendBotMessageService;
    private static final String text = "Please choose the master from list";

    public RecordButton(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();
        ServicesMenu menu = new ServicesMenu();
        SendMessage sendMessage = initSendMessage(id, menu);
        sendBotMessageService.sendMessage(id, text, sendMessage);
    }


}
