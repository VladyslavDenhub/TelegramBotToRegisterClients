package bot.second.botSecond.sevice.tryContainer.comands;

import bot.second.botSecond.sevice.tryContainer.SendBotMessageService;
import bot.second.botSecond.sevice.tryContainer.menu.MastersButton;
import bot.second.botSecond.sevice.tryContainer.menu.RecordButton;
import com.google.common.collect.ImmutableMap;

import static bot.second.botSecond.sevice.enums.CommandName.*;
import static bot.second.botSecond.sevice.enums.FirstMenu.RECORD;
import static bot.second.botSecond.sevice.enums.MastersName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;

    public CommandContainer(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(MY_DATA.getCommandName(), new MyDataCommand(sendBotMessageService))
                .put(RECORD.getButtonName(), new RecordButton(sendBotMessageService))
                .put(ANNA.getName(), new MastersButton(sendBotMessageService))
                .put(VITALII.getName(), new MastersButton(sendBotMessageService))
                .put(BORIS.getName(), new MastersButton(sendBotMessageService))
                .build();
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, null);
    }

}
