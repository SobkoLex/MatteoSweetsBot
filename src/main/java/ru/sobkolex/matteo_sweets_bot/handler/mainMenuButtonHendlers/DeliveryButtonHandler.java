package ru.sobkolex.matteo_sweets_bot.handler.mainMenuButtonHendlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.Arrays;

public class DeliveryButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();

    {

        message.setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
                        Arrays.asList(InlineKeyboardButton.builder().text("Указать адресс для отправки почтой").callbackData("Post").build()),
                        Arrays.asList(InlineKeyboardButton.builder().text("Указать адресс для доставки курьером").callbackData("Carrier").build()),
                        Arrays.asList(InlineKeyboardButton.builder().text("Самовывоз").callbackData("Pickup").build())
                )).build());

    }

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        message.setText("На данный момент доступны три способа доставки:\n" +
                "1. Почтой.\n" +
                "2. Доставка курьером/такси (Действует только в Краснодаре).\n" +
                "3. Самовывоз (ул. 40 лет Победы 33/6).\n\n" +
                "Текущий метод доставки:\n" +
                dao.showDeliveryMethod(update.getMessage().getFrom().getId().toString()).getDeliveryMethod() + dao.showDeliveryMethod(update.getMessage().getFrom().getId().toString()).getDeliveryAddress());
        message.setChatId(update.getMessage().getChatId().toString());
        bot.execute(message);
    }
}
