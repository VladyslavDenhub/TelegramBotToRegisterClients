package bot.second.botSecond.sevice.container.comands;

import bot.second.botSecond.Entity.Client;
import bot.second.botSecond.db.crud.Crud_Impl;
import bot.second.botSecond.sevice.TelegramBot;
import bot.second.botSecond.sevice.menu.StartMenu;
import bot.second.botSecond.sevice.SendBotMessageService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private static final String START_MESSAGE = "Choose a command.";

    public StartCommand(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();
        StartMenu menu = new StartMenu();
        SendMessage sendMessage = initSendMessage(id, menu);
        addUserToDB(update);
        sendBotMessageService.sendMessage(id, START_MESSAGE, sendMessage);
    }

    private void addUserToDB(Update update) {
        Crud_Impl crud = new Crud_Impl();
        long newId = update.getMessage().getChatId();
        String userName = update.getMessage().getChat().getUserName();
        String userFirsName = update.getMessage().getChat().getFirstName();
        String userLastName = update.getMessage().getChat().getLastName();

        Client newClient = new Client();

        List<Client> users = crud.readEntity(newClient);
        for (Client user : users){
            if (newId == user.getId()){
                return;
            }
        }

        newClient.setId(newId);
        newClient.setUserName(userName);
        newClient.setUserFirstName(userFirsName);
        newClient.setUserLastName(userLastName);

        crud.createEntity(newClient);
        TelegramBot.LOGGER.info("Client created: " + newClient);
    }
}
