package ru.sobkolex.matteo_sweets_bot.handler.button_handlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;
import ru.sobkolex.matteo_sweets_bot.handler.mainMenuButtonHendlers.CartButtonHandler;

public class AddToCartButtonHandler implements ButtonHandler {

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        String[] data = update.getCallbackQuery().getData().split(" ");
        String userId = update.getCallbackQuery().getFrom().getId().toString();
        if (data[1].equals("Chocolate"))
            dao.addChocolateToCart(userId);
        else
            dao.addCakeToCart(userId);
        new CartButtonHandler().send(update,bot,dao);
    }

}
