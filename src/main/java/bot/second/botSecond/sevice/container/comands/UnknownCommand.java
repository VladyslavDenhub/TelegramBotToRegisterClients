package bot.second.botSecond.sevice.container.comands;

import bot.second.botSecond.sevice.SendBotMessageService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command{

    public static final String TEXT = "Не розумію вас \uD83D\uDE1F, напишить /help щоб дізнатися що я вмію.";

    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(id, TEXT, new SendMessage());
    }
}
