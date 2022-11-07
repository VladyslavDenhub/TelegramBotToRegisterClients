package bot.second.botSecond.sevice.menu.buttons;

import bot.second.botSecond.sevice.SendBotMessageService;
import bot.second.botSecond.sevice.container.comands.Command;
import bot.second.botSecond.sevice.container.comands.StartCommand;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BackToStartButton implements Command {

    private final SendBotMessageService sendBotMessageService;

    public BackToStartButton(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {

        StartCommand start = new StartCommand(sendBotMessageService);
        start.execute(update);

    }
}
