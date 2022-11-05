package bot.second.botSecond.sevice.tryContainer.menu;

import bot.second.botSecond.sevice.implMenu.MasterMenu;
import bot.second.botSecond.sevice.tryContainer.comands.Command;
import bot.second.botSecond.sevice.tryContainer.SendBotMessageService;
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
        MasterMenu menu = new MasterMenu();
        SendMessage sendMessage = initSendMessage(id, menu);
        sendBotMessageService.sendMessage(id, text, sendMessage);
    }


}
