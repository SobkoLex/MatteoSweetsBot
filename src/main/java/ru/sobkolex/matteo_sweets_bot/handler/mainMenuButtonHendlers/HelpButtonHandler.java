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

public class HelpButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();

    {
        message.setText("Для навигации в боте используйте кнопки главного меню:\n" +
                "Каталог - покажет готовые работы и поможет оформить заказ.\n " +
                "Корзина - позволит добавить новые товары и посмотреть текущие.\n" +
                "Способы доставки - позволит посмотреть текущий метод или выбрать новый.\n" +
                "История заказов - позволит просмотреть историю заказов.\n" +
                "Помощь - позволит связвться с продавцом.\n" +
                "Отзывы - позволит просмотреть отзывы или оставить свой.\n");
        message.setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
                Arrays.asList(InlineKeyboardButton.builder().text("Связаться с продавцом").callbackData("ConnectOperator").build()),
                Arrays.asList(InlineKeyboardButton.builder().text("Продолжить").callbackData("Continue").build())
        )).build());
    }


    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        message.setChatId(update.getMessage().getChatId().toString());
        bot.execute(message);
    }
}