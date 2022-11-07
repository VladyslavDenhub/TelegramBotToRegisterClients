package bot.second.botSecond.sevice.container.comands.admin.comands;

import bot.second.botSecond.Entity.Client;
import bot.second.botSecond.Entity.Master;
import bot.second.botSecond.db.crud.Crud_Impl;
import bot.second.botSecond.sevice.SendBotMessageService;
import bot.second.botSecond.sevice.TelegramBot;
import bot.second.botSecond.sevice.container.comands.Command;
import bot.second.botSecond.sevice.menu.StartMenu;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class AddMasterCommand implements Command {

    private static final String TEXT = "New master added to data base!";
    private final SendBotMessageService sendBotMessageService;

    public AddMasterCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();
        addMasterToDB(update);
        sendBotMessageService.sendMessage(id, TEXT, new SendMessage());
    }

    private void addMasterToDB(Update update) {
        Crud_Impl crud = new Crud_Impl();
        long newId = update.getMessage().getChatId();
        String masterTelegramName = update.getMessage().getChat().getUserName();
        String masterFirsName = update.getMessage().getChat().getFirstName();
        String masterLastName = update.getMessage().getChat().getLastName();

        Master newMaster = new Master();

        newMaster.setId(newId);
        newMaster.setMasterTelegramName(masterTelegramName);
        newMaster.setMasterFirstName(masterFirsName);
        newMaster.setMasterLastName(masterLastName);

        crud.createEntity(newMaster);
        TelegramBot.LOGGER.info(TEXT+": " + newMaster.toString());
    }
}
