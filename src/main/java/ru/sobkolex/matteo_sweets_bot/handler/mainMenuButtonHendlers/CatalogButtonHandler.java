package ru.sobkolex.matteo_sweets_bot.handler.mainMenuButtonHendlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.buttons.MakeOrderButtons;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.ArrayList;
import java.util.List;

public class CatalogButtonHandler implements ButtonHandler {

    SendMediaGroup media = new SendMediaGroup();
    SendMessage message = new SendMessage();

    {
        message.setText("Список готовой продукции");
        message.setReplyMarkup(new MakeOrderButtons() );

        List<InputMedia> pictureList = new ArrayList<>();
//                        pictureList.add(InputMediaPhoto
//                                .builder()
//                                .caption("Муссовый торт привет\n")
//                                .media("AgACAgIAAxkBAAIH-2Hl1OjEUd1yBdkS4_pAghUgJKItAALtuDEbsPwwS2N3FO4Lg9KXAQADAgADeQADIwQ")
//                                .build());
//                        pictureList.add(InputMediaPhoto
//                                .builder()
//                                .caption("Муссовый торт привет\n")
//                                .media("AgACAgIAAxkBAAIIBmHl1ZbFHayNGjlM9JBFgQcIcNxIAALvuDEbsPwwS-BwYYqRQQ60AQADAgADeQADIwQ")
//                                .build());
//                        pictureList.add(InputMediaPhoto
//                                .builder()
//                                .caption("Муссовый торт привет\n")
//                                .media("AgACAgIAAxkBAAIIB2Hl1ZbHVf-12NVEdBML4NfuiV5BAALwuDEbsPwwS25kGLc05WazAQADAgADeQADIwQ")
//                                .build());
//                        pictureList.add(InputMediaPhoto
//                                .builder()
//                                .caption("Муссовый торт привет\n")
//                                .media("AgACAgIAAxkBAAIICGHl1Za4kwsUzh_Bm8cAAYYREGMU8AAC8bgxG7D8MEsFv4-_uW8tKAEAAwIAA3kAAyME")
//                                .build());
//                        pictureList.add(InputMediaPhoto
//                                .builder()
//                                .caption("Муссовый торт привет\n")
//                                .media("AgACAgIAAxkBAAIICmHl1ZZ1GekD9T2wHvWI2MdMLrmEAALzuDEbsPwwSyv_7CX1rzNVAQADAgADeQADIwQ")
//                                .build());
//                        pictureList.add(InputMediaPhoto
//                                .builder()
//                                .caption("Муссовый торт привет\n")
//                                .media("AgACAgIAAxkBAAIIDmHl1ZbbrEUCZhVAnji-CXIWgf1eAAL2uDEbsPwwSwn2lbzbqvNzAQADAgADeQADIwQ")
//                                .build());
//                        execute(SendMediaGroup.builder().chatId(message.getChatId().toString()).medias(pictureList).build());


    }

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        message.setChatId(update.getMessage().getChatId().toString());
        bot.execute(message);
    }


}
