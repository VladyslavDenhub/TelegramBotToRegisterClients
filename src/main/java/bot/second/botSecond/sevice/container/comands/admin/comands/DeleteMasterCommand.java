package bot.second.botSecond.sevice.container.comands.admin.comands;

import bot.second.botSecond.Entity.Master;
import bot.second.botSecond.Entity.MyEntity;
import bot.second.botSecond.db.crud.Crud_Impl;
import bot.second.botSecond.sevice.SendBotMessageService;
import bot.second.botSecond.sevice.container.comands.Command;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.rmi.server.ServerCloneException;
import java.util.List;

public class DeleteMasterCommand implements Command {

    private static final String TEXT = "The master is deleted!";
    private final SendBotMessageService sendBotMessageService;

    public DeleteMasterCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String id = update.getMessage().getChatId().toString();
        deleteMasterFromDB(update);
        sendBotMessageService.sendMessage(id, TEXT, new SendMessage());
    }

    private void deleteMasterFromDB(Update update) {
        Crud_Impl crud = new Crud_Impl();
        long id = update.getMessage().getChatId();
        List<Master> list = crud.readEntity(new Master());
        for (Master master : list){
            if (id == master.getId()){
                crud.deleteEntity(master);
            }
        }

    }
}
