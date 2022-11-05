package bot.second.botSecond.sevice.tryContainer.comands;



import bot.second.botSecond.sevice.implMenu.StartMenu;
import bot.second.botSecond.sevice.tryContainer.SendBotMessageService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private static final String START_MESSAGE = "Hello! Choose a command.";

    public StartCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();
        StartMenu menu = new StartMenu();
        SendMessage sendMessage = initSendMessage(id, menu);
        sendBotMessageService.sendMessage(id, START_MESSAGE, sendMessage);
    }
}
