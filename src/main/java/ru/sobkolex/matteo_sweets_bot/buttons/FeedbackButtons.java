package ru.sobkolex.matteo_sweets_bot.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;

public class FeedbackButtons extends InlineKeyboardMarkup {

    {
        super.setKeyboard(Arrays.asList(
                Arrays.asList(
                        InlineKeyboardButton.builder().text("Оставить отзыв").callbackData("feedback").build()
                )
        ));
    }
}
