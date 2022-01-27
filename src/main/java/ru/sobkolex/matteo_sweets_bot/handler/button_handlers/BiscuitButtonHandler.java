package ru.sobkolex.matteo_sweets_bot.handler.button_handlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiscuitButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();
    SendMediaGroup media = new SendMediaGroup();
    String text =
            "Вы выбрали бисквитный торт.\n" +
            "Выберите начинку:\n" +
            "1. \"Молочный пломбир с карамелизированным бананом\"\n" +
            "Сливочные тонкие коржи на сгущенном молоке, крем на основе сливочного сыра и сливок, карамелизированные бананы с пряностями\n" +
            "2. \"Классический ванильный\"\n" +
            "Воздушные ванильный бисквит, крем на сливочном сыре\n" +
            "3.\"Шоколадные тропики\"\n" +
            "Шоколадный бисквит, ганаш манго- маракуя, шоколадный крем на основе сливочного сыра\n" +
            "4. \"Рафаэлло\"\n" +
            "Ванильный бисквит, сливочный крем, хрустящий слой с миндалём\n" +
            "5. \"Красный бархат с вишней\"\n" +
            "Шоколадный коржи, сливочный крем, кремю из вишни\n" +
            "6. \"Малиновый бабл\"\n" +
            "Ванильный бисквит, малиновый курд, безе, карамелизированный мусс, сливочный крем\n" +
            "7. \"Сникерс\"\n" +
            "Шоколадный бисквит, карамель, солёный арахис, безе\n" +
            "8. \"Кофейная груша\"\n" +
            "Шоколадный бисквит, карамелизированная груша, шоколадный крем, кофейный мусс\n" +
            "9. \"Хрустящая вишня\"\n" +
            "Шоколадный бисквит, вишня в сиропе, хрустящий слой, ванильный крем";

    {
        message.setText(text);
        message.setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
                Arrays.asList(
                        InlineKeyboardButton.builder().text("1").callbackData("CakeTypeTaste BiscuitCake 1").build(),
                        InlineKeyboardButton.builder().text("2").callbackData("CakeTypeTaste BiscuitCake 2").build(),
                        InlineKeyboardButton.builder().text("3").callbackData("CakeTypeTaste BiscuitCake 3").build()),
                Arrays.asList(
                        InlineKeyboardButton.builder().text("4").callbackData("CakeTypeTaste BiscuitCake 4").build(),
                        InlineKeyboardButton.builder().text("5").callbackData("CakeTypeTaste BiscuitCake 5").build(),
                        InlineKeyboardButton.builder().text("6").callbackData("CakeTypeTaste BiscuitCake 6").build()),
                Arrays.asList(
                        InlineKeyboardButton.builder().text("7").callbackData("CakeTypeTaste BiscuitCake 7").build(),
                        InlineKeyboardButton.builder().text("8").callbackData("CakeTypeTaste BiscuitCake 8").build(),
                        InlineKeyboardButton.builder().text("9").callbackData("CakeTypeTaste BiscuitCake 9").build())
        )).build());
        List<InputMedia> pictureList = new ArrayList<>();

        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOhYfL8Ge242LxUg2WQ7Zfq28QuBSUAAje6MRsnb5lL67aU2w0_L5sBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOiYfL8GvaOc6eYlwABhvRWBOmoaGp_AAI4ujEbJ2-ZS1dIvzCejiN6AQADAgADeQADIwQ").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOjYfL8G02OoPA-j_PcZbpJeq-xHKEAAjm6MRsnb5lLMB8L_aNirEMBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOkYfL8HKtOTyRIwZZli4u6YvJLq0kAAjq6MRsnb5lLYY03RPcXlzcBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOlYfL8HchlhMFoiv-tOtB1zK7Oha8AAju6MRsnb5lLmUOlzJBFSi8BAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOmYfL8HmQNlEItKFN5K5UPDy4wMKIAAjy6MRsnb5lLZ_a35BoPGhQBAAMCAAN5AAMjBA").build());

        media.setMedias(pictureList);

        //
        //
        //
        //
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


}
