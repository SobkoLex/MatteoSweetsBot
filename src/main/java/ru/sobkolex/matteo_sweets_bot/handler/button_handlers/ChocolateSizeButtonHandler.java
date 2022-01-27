package ru.sobkolex.matteo_sweets_bot.handler.button_handlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.sobkolex.matteo_sweets_bot.model.Chocolate;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.Arrays;

public class ChocolateSizeButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();

    {
        message.setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
                Arrays.asList(
                        InlineKeyboardButton.builder().text("Добавить в корзину").callbackData("AddToCart Chocolate").build(),
                        InlineKeyboardButton.builder().text("Связаться с продавцом.").callbackData("ConnectOperator").build())
        )).build());
    }

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        String userId = update.getCallbackQuery().getFrom().getId().toString();
        String[] data = update.getCallbackQuery().getData().split(" ");
        String size = data[1].equals("Big")? "большую" : "маленькую";
        Chocolate chocolate = dao.getChocolate(userId).stream().filter(x -> x.getCart()==0).findFirst().get();
        String type = "";
        if (chocolate.getType().equals("Black"))
            type = "черного";
        else if (chocolate.getType().equals("Caramel"))
            type = "карамелизированного";
        else if (chocolate.getType().equals("Milk"))
            type = "молочного";
        else
            type = "белого";
        message.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        message.setText("Вы выбрали " + size + " плитку " + type + " шоколада!\n" +
                "Ввиду огромного разнообразия начинки и вышей безграничной фантазии,\n" +
                "Начинка и дизайн обсуждаются лично.\n");
        bot.execute(message);
        dao.updateChocolateSize(data[1],userId);

    }
}
