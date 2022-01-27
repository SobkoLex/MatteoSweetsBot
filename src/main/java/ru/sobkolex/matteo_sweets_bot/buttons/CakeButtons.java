package ru.sobkolex.matteo_sweets_bot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CakeButtons extends InlineKeyboardMarkup {
    private List<List<InlineKeyboardButton>> buttons;
    {
        buttons = new ArrayList<>();
        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder().text("Муссовый").callbackData("Mousse").build(),
                InlineKeyboardButton.builder().text("Бисквитный").callbackData("Biscuit").build()
        ));
        super.setKeyboard(buttons);
    }
}
