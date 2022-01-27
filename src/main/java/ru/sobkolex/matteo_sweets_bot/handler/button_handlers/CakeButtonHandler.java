package ru.sobkolex.matteo_sweets_bot.handler.button_handlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.buttons.CakeButtons;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.ArrayList;
import java.util.List;

public class CakeButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();
    SendMediaGroup media = new SendMediaGroup();

    {
        message.setText("Какой тортик вам по душе?");
        message.setReplyMarkup(new CakeButtons());
        List<InputMedia> pictureList = new ArrayList<>();

        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAO1YfL9eUgnPKYyiy_Kbo-wysNbmVMAAj-6MRsnb5lL_FMrAwzhoKMBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAO3YfL9erw3aEn4is8-s_p9yQSryG0AAkG6MRsnb5lLPCRs4DmiiJEBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAPCYfL9gCoPohei_zTbylybqsJwI3UAAkq6MRsnb5lL1xlDtSxQmAkBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAPBYfL9gIVCazt55AOYyHurU5UjzS4AAjC6MRsnb5lLc-XWSXCnVYIBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAPAYfL9f6HCGqsqU5msNf5hnSd_jWEAAkm6MRsnb5lLWybmMrX0R3MBAAMCAAN5AAMjBA").build());
        pictureList.add(InputMediaPhoto.builder().caption("Муссовый торт привет\n")
                .media("AgACAgIAAxkBAAOTYfL5-BrIyi1LWPakS3NvNAzZrJcAAiu6MRsnb5lLW9gjfX2txBUBAAMCAAN5AAMjBA").build());

        media.setMedias(pictureList);

        //
        //AgACAgIAAxkBAAO2YfL9eRsz0u4LAW1XMZVMZUin7WwAAkC6MRsnb5lL1COH4wABxVbaAQADAgADeQADIwQ
        //
        //AgACAgIAAxkBAAO4YfL9eic8UbOPFzi4lupdufby3wcAAkK6MRsnb5lL3ykJJIF3kCkBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAO5YfL9e8xf3jGkLiWq-ijrMDH3jcgAAkO6MRsnb5lL1LrxoZDVZicBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAO6YfL9fClh8pU9R7idkpt18w7Qx7gAAkS6MRsnb5lLd0-KQWVbdlIBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAO7YfL9fLpY6Yjz2Opa3B_AZGtonVwAAkW6MRsnb5lLC8aPSxbhG8cBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAO8YfL9fR8-zngUCPaFF68BWlTZpsgAAka6MRsnb5lLvPYAAYr9ccykAQADAgADeQADIwQ
        //AgACAgIAAxkBAAO9YfL9fvL7hNAAAX2wBbE8TL4qRUkVAAJHujEbJ2-ZSxaceGDonpIlAQADAgADeQADIwQ
        //AgACAgIAAxkBAAO-YfL9fgGNvNJeomamAcySOk87bqkAAiq6MRsnb5lLia4GTs_rb8YBAAMCAAN5AAMjBA
        //AgACAgIAAxkBAAO_YfL9fzD1dyhnJGC7cVU51Gxvsu4AAki6MRsnb5lLoUKGlIJmo4MBAAMCAAN5AAMjBA
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
