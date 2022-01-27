package ru.sobkolex.matteo_sweets_bot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeOrderButtons extends InlineKeyboardMarkup {

    {
        super.setKeyboard(Arrays.asList(Arrays.asList(
                InlineKeyboardButton.builder().text("Шоколад").callbackData("Chocolate").build(),
                InlineKeyboardButton.builder().text("Торт").callbackData("Cake").build())));
    }


}
