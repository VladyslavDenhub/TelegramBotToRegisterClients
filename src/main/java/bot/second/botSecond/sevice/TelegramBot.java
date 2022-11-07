package bot.second.botSecond.sevice;

import bot.second.botSecond.config.BotConfig;
import bot.second.botSecond.sevice.container.comands.CommandContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static bot.second.botSecond.sevice.enums.CommandName.*;


@Component
public class TelegramBot extends TelegramLongPollingBot {

    public static final Logger LOGGER = LoggerFactory.getLogger(TelegramBot.class);
    public static String START_DESCRIPTION = "початі роботу із ботом";
    public static String MYDATA_DESCRIPTION = "подивитись свої данні";
    public static String HELP_DESCRIPTION = "отримати допомогу в роботі бота";
    final BotConfig config;
    private final CommandContainer commandContainer;

    public TelegramBot(BotConfig config) {
        this.config = config;
        installMenuCommands();
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String userText = update.getMessage().getText();
            commandContainer.retrieveCommand(userText).execute(update);
        }
    }

    private void installMenuCommands() {
        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand(START.getCommandName(), START_DESCRIPTION));
        listOfCommands.add(new BotCommand(MY_DATA.getCommandName(), MYDATA_DESCRIPTION));
        listOfCommands.add(new BotCommand(HELP.getCommandName(), HELP_DESCRIPTION));

        SetMyCommands setMyCommands = new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null);

        try {
            execute(setMyCommands);
        } catch (TelegramApiException e) {
            LOGGER.error("ERROR execute set commands: " + e.getMessage());
        }
    }
}
