package ru.sobkolex.matteo_sweets_bot.handler.mainMenuButtonHendlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.buttons.FeedbackButtons;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

public class FeedbackButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();

    {
        message.setText("Отзывы наших клиентов:");
        message.setReplyMarkup(new FeedbackButtons());

    }

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        message.setChatId(update.getMessage().getChatId().toString());
        bot.execute(message);
    }

}
