package bot.second.botSecond.sevice.container.comands;

import bot.second.botSecond.sevice.SendBotMessageService;
import bot.second.botSecond.sevice.container.comands.admin.comands.AddMasterCommand;
import bot.second.botSecond.sevice.container.comands.admin.comands.DeleteMasterCommand;
import bot.second.botSecond.sevice.menu.buttons.BackToStartButton;
import bot.second.botSecond.sevice.menu.buttons.MastersButton;
import bot.second.botSecond.sevice.menu.buttons.RecordButton;
import bot.second.botSecond.sevice.menu.buttons.ServiceButtons;
import com.google.common.collect.ImmutableMap;

import static bot.second.botSecond.sevice.enums.CommandName.*;
import static bot.second.botSecond.sevice.enums.FirstMenu.APPOINTMENT;
import static bot.second.botSecond.sevice.enums.MastersName.*;
import static bot.second.botSecond.sevice.enums.MastersName.BACK;
import static bot.second.botSecond.sevice.enums.ServicesName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(MY_DATA.getCommandName(), new MyDataCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(APPOINTMENT.getButtonName(), new RecordButton(sendBotMessageService))
                .put(ANNA.getName(), new MastersButton(sendBotMessageService))
                .put(VITALII.getName(), new MastersButton(sendBotMessageService))
                .put(BORIS.getName(), new MastersButton(sendBotMessageService))
                .put(MANICURE.getServiceName(), new ServiceButtons(sendBotMessageService))
                .put(PEDICURE.getServiceName(), new ServiceButtons(sendBotMessageService))
                .put(MANICURE_COATING.getServiceName(), new ServiceButtons(sendBotMessageService))
                .put(PEDICURE_COATING.getServiceName(), new ServiceButtons(sendBotMessageService))
                .put(MANICURE_PEDICURE.getServiceName(), new ServiceButtons(sendBotMessageService))
                .put(EXTENSION.getServiceName(), new ServiceButtons(sendBotMessageService))
                .put(BACK.getName(), new BackToStartButton(sendBotMessageService))
                .put(ADD_MASTER.getCommandName(), new AddMasterCommand(sendBotMessageService))
                .put(DELETE_MASTER.getCommandName(), new DeleteMasterCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }


}
