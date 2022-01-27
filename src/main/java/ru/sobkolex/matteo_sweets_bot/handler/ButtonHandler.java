package ru.sobkolex.matteo_sweets_bot.handler;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;

public interface ButtonHandler {

    void send(Update update, MatteoSweetsTelegramBot bot, DAO dao);

}
