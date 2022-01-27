package ru.sobkolex.matteo_sweets_bot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Arrays;

public class MainMenuButtons extends ReplyKeyboardMarkup{

    {
        super.setOneTimeKeyboard(true);
        super.setResizeKeyboard(true);
        super.setSelective(true);
        super.setKeyboard(Arrays.asList(
                new KeyboardRow(Arrays.asList(new KeyboardButton("Каталог"),new KeyboardButton("Корзина"))),
                new KeyboardRow(Arrays.asList(new KeyboardButton("Способы доставки"),new KeyboardButton("История заказов"))),
                new KeyboardRow(Arrays.asList(new KeyboardButton("Помощь"), new KeyboardButton("Отзывы")))
        ));
    }

}
