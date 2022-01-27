package ru.sobkolex.matteo_sweets_bot.handler.mainMenuButtonHendlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.buttons.MainMenuButtons;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;


public class Start implements ButtonHandler {

    SendMessage message = new SendMessage();
    User user;

    {
        message.setText("Добро пожаловать!");
        message.setReplyMarkup(new MainMenuButtons());

    }

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        user = update.getMessage().getFrom();
        message.setChatId(update.getMessage().getChatId().toString());
        bot.execute(message);
        dao.saveUser(user);
    }

}
