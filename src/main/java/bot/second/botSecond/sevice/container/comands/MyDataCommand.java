package bot.second.botSecond.sevice.container.comands;

import bot.second.botSecond.sevice.SendBotMessageService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyDataCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    MyDataCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(id, getUserInfo(update),new SendMessage());
    }

    private String getUserInfo(Update update){
        String userName = update.getMessage().getChat().getUserName();
        String userFirstName = update.getMessage().getChat().getFirstName();
        String userLastName = update.getMessage().getChat().getLastName();
        return userFirstName+"\n"+userLastName+"\n"+userName;
    }
}
