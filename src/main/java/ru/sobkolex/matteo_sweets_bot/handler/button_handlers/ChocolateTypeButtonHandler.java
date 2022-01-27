package ru.sobkolex.matteo_sweets_bot.handler.button_handlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.sobkolex.matteo_sweets_bot.model.Chocolate;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.Arrays;
import java.util.List;

public class ChocolateTypeButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();

    {
        message.setText("Выберите размер шоколадки:\n" +
                        "Большая, 150-200 гр.\n" +
                        "Маленькая, 100 - 120 гр.");
        message.setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
                        Arrays.asList(InlineKeyboardButton.builder().text("Большая").callbackData("ChocolateSize Big").build(),
                                InlineKeyboardButton.builder().text("Маленькая").callbackData("ChocolateSize Small").build())
                )).build());

    }

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        String userId = update.getCallbackQuery().getFrom().getId().toString();
        String[] data = update.getCallbackQuery().getData().split(" ");
        List<Chocolate> chocolates = dao.getChocolate(userId);
        Chocolate last = chocolates.stream().filter(x -> x.getCart()==0).findAny().orElse(null);
        if (last!=null)
            dao.updateChocolateType(data[1],userId);
        else
            dao.saveChocolate(userId,data[1]);
        message.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        bot.execute(message);
    }

}
