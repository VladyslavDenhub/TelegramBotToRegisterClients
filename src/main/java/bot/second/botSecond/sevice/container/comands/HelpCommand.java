package bot.second.botSecond.sevice.container.comands;

import bot.second.botSecond.sevice.SendBotMessageService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static bot.second.botSecond.sevice.enums.CommandName.*;

public class HelpCommand implements Command{

    private static final String TEXT = String.format("✨<b>Доступні команди</b>✨\n\n"
                    + "%s - почати роботу із ботом\n"
                    + "%s - подивитись які персональні данні використовує бот\n\n"
                    + "%s - отримати допомогу в роботі бота\n",
            START.getCommandName(), MY_DATA.getCommandName(), HELP.getCommandName());
    private final SendBotMessageService sendBotMessageService;

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(id, TEXT, new SendMessage());
    }
}
