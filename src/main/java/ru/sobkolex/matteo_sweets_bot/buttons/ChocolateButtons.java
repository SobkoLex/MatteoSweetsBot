package ru.sobkolex.matteo_sweets_bot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;

public class ChocolateButtons extends InlineKeyboardMarkup {

    {
        super.setKeyboard(Arrays.asList(
                Arrays.asList(
                    InlineKeyboardButton.builder().text("Белый").callbackData("ChocolateType White").build(),
                    InlineKeyboardButton.builder().text("Молочный").callbackData("ChocolateType Milk").build()),
                Arrays.asList(
                    InlineKeyboardButton.builder().text("Карамелизированный").callbackData("ChocolateType Caramel").build(),
                    InlineKeyboardButton.builder().text("Черный").callbackData("ChocolateType Black").build())
//                Arrays.asList(
//                        InlineKeyboardButton.builder().text("Выбрать готовое изделие").callbackData("PickChocolate").build())
        ));
    }
}
