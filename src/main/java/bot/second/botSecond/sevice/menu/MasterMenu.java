package bot.second.botSecond.sevice.menu;

import bot.second.botSecond.Entity.Master;
import bot.second.botSecond.db.crud.Crud_Impl;

import bot.second.botSecond.sevice.enums.MastersName;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MasterMenu implements BotMenu {
    @Override
    public void showMenu(SendMessage sendMessage) {
        List<Master> masterList = getListMasters();
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        for (MastersName master : MastersName.values()){
            row.add(master.getName());
            keyboardRows.add(row);
            row = new KeyboardRow();
        }

        row.add(MastersName.BACK.getName());
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(keyboardMarkup);
    }

    private List getListMasters(){
        Crud_Impl read = new Crud_Impl();
        return read.readEntity(new Master());
    }
}
