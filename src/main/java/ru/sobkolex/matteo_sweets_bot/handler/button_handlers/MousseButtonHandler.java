package ru.sobkolex.matteo_sweets_bot.handler.button_handlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
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

public class MousseButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();
    SendMediaGroup media = new SendMediaGroup();
    List<InputMedia> pictureList = new ArrayList<>();
    String text = "Вы выбрали муссовый торт.\n" +
            "Выберите начинку:\n" +
            "1.\"Медовый апельсин\" ." +
            " Медовые коржи, имбирное желе, апельсиновый мусс, сливочный мусс.\n" +
            "2.\"Ананасовый сорбет\" ." +
            " Ванильный бисквит, ореховое пралине, ананасовая прослойка, сливочно- творожный мусс\n" +
            "3. \"Дабл_эпл\" ." +
            "Белый бисквит, шоколадно- ореховая прослойка, яблочный центр, яблочный мусс\n" +
            "4. Три шоколада:  шоколадный бисквит( 3 вида мусса : на белом, молочном и темном шоколаде)\n" +
            "5. \"Клубничный Шейк\" ." +
            "Шоколадный бисквит, кофейно- шоколадная прослойка, клубнично- базиликовая прослойка, мусс на сливочном сыре\n" +
            "6. \"Лимонный блюз\" ." +
            "Песочный корж, лимонно- шоколадная начинка, безе, мусс на молочном шоколаде и йогурте\n" +
            "7.\"Бейлис\" ." +
            "Шоколад- кофейная прослойка, воздушный бисквит, сливочно- сырный мусс с бейлисом.";

    {
        message.setText(text);
        message.setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(
                Arrays.asList(
                    Arrays.asList(
                        InlineKeyboardButton.builder().text("1").callbackData("CakeTypeTaste MousseCake 1").build(),
                        InlineKeyboardButton.builder().text("2").callbackData("CakeTypeTaste MousseCake 2").build(),
                        InlineKeyboardButton.builder().text("3").callbackData("CakeTypeTaste MousseCake 3").build()),
                Arrays.asList(
                        InlineKeyboardButton.builder().text("4").callbackData("CakeTypeTaste MousseCake 4").build(),
                        InlineKeyboardButton.builder().text("5").callbackData("CakeTypeTaste MousseCake 5").build(),
                        InlineKeyboardButton.builder().text("6").callbackData("CakeTypeTaste MousseCake 6").build()),
                Arrays.asList(
                        InlineKeyboardButton.builder().text("7").callbackData("CakeTypeTaste MousseCake 7").build())
        )).build());

        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOQYfL59oEB45_2onoNbQR7D08emckAAii6MRsnb5lL8VQ5q9knEPABAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOcYfL5_sOGCl8tQl8U7MG9UJu9yUUAAjS6MRsnb5lLT1BJ375uckMBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAObYfL5_anDEvhGw8jfaDRUoqShWyoAAjO6MRsnb5lL13GAfrKSPpoBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOaYfL5_IMUCWPchYRqljekcg_LOhkAAjK6MRsnb5lLdAExRh-E1W0BAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOaYfL5_IMUCWPchYRqljekcg_LOhkAAjK6MRsnb5lLdAExRh-E1W0BAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOYYfL5-5hZ-N4GgV76neRjyEXdZyQAAjC6MRsnb5lLc-XWSXCnVYIBAAMCAAN5AAMjBA").build());

        media.setMedias(pictureList);

        //AgACAgIAAxkBAAOOYfL59R3qNLX0BgoLRyKbODwjqfgAAia6MRsnb5lLijqL3fcqiFoBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAOPYfL59nx9b8Y-Yx1KgeK4NO8-aBkAAie6MRsnb5lLrxbVSr5puxcBAAMCAAN5AAMjBA
        //
        //AgACAgIAAxkBAAORYfL59gOGC7CM07TrlfYvHEsYio8AAim6MRsnb5lLsHTlDtjWTpgBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAOSYfL590VEV7Tlgjt85QFW-hhjdqQAAiq6MRsnb5lLia4GTs_rb8YBAAMCAAN5AAMjBA
        //
        //AgACAgIAAxkBAAOUYfL5-UNJoq--PLxu-OU8j5NjOa8AAiy6MRsnb5lL_GcMmwZPqmABAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAOVYfL5-VcGS6vQA6J20UKQUDJbBuwAAi26MRsnb5lL_tdGtAQqZsoBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAOWYfL5-iGm8IcPY1tvJFTdY-1tv0gAAi66MRsnb5lLW7lUsGT6a3IBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAOXYfL5-oyLE6jDQeBkyLNI_cF2kYwAAi-6MRsnb5lLUeMCVhd1v7EBAAMCAAN5AAMjBA
        //
        //AgACAgIAAxkBAAOZYfL5_E-_8VGcjXd3Esk2xpjwbj0AAjG6MRsnb5lLtLix8BeC7UABAAMCAAN5AAMjBA
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
