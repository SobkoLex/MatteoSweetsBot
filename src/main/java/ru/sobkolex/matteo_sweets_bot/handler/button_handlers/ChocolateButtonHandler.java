package ru.sobkolex.matteo_sweets_bot.handler.button_handlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.buttons.ChocolateButtons;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.ArrayList;
import java.util.List;

public class ChocolateButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();
    SendMediaGroup media = new SendMediaGroup();

    {
        message.setText("Какой шоколад вы желаете?");
        message.setReplyMarkup(new ChocolateButtons());
        List<InputMedia> pictureList = new ArrayList<>();

        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAN7YfL3cj9d3khX0PMqFkjLRoxL6KwAAhS6MRsnb5lL2cvJqmhFxhABAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAODYfL3fJa83W_NHQEVWqIeeMf-GW8AAhy6MRsnb5lLmV-ZaVEL4UkBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOBYfL3ebY2y4s1M78PLLUOXZyA4jUAAhq6MRsnb5lLLlwhrulG0p8BAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAN9YfL3cyjbQTyqAAFAXLFByZ0qLAU6AAIWujEbJ2-ZS7eyqiRe7CNZAQADAgADeQADIwQ").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAN-YfL3dVjHZh2o9Wl0lhCAUAL4ZO4AAhe6MRsnb5lLeeyxfcYeW6gBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOEYfL3fR0wrjl5roAhxVV1WmJPd6QAAh26MRsnb5lL6oS-w_8ImAMBAAMCAAN5AAMjBA").build());

        media.setMedias(pictureList);

    //
    //AgACAgIAAxkBAAN8YfL3c_UVs-Mc39t7ZIfANZOpYlEAAhW6MRsnb5lLidPXCA8y7tgBAAMCAAN5AAMjBA
        //
        //
        //AgACAgIAAxkBAAN_YfL3dz3tH4F_65SXZw0zN6-u1PwAAhi6MRsnb5lL6qXlFtIjWlgBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAOAYfL3eGOPbVCEvqevFItP1yIx7N0AAhm6MRsnb5lL1y_KxFncYgUBAAMCAAN5AAMjBA
        //
        //AgACAgIAAxkBAAOCYfL3e8ZQHu2DLbfci7vRQO8vcnIAAhu6MRsnb5lLG3XnhazsmKkBAAMCAAN5AAMjBA
        //
        //
    }

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        media.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        message.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        bot.execute(media);
        bot.execute(message);
    }


    private void dao(DAO dao) {

    }

}
