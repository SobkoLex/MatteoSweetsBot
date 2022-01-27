package ru.sobkolex.matteo_sweets_bot.handler.mainMenuButtonHendlers;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.sobkolex.matteo_sweets_bot.model.Cake;
import ru.sobkolex.matteo_sweets_bot.model.Chocolate;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.buttons.MakeOrderButtons;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CartButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();


    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        String chatId;
        if (update.hasCallbackQuery())
            chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        else
            chatId = update.getMessage().getChatId().toString();
        message.setChatId(chatId);
        String chocolates = dao.getChocolate(chatId).stream().filter(x -> x.getCart() != 0).map(Chocolate::toString).collect(Collectors.joining());
        String cakes = dao.getCakes(chatId).stream().filter(x -> x.getCart().equals("1")).map(Cake::toString).collect(Collectors.joining());
        if (chocolates.isEmpty()&&cakes.isEmpty()) {
            message.setText("Ваша корзина пуста(\n" +
                    "Что желаете заказать?");
            message.setReplyMarkup(new MakeOrderButtons());
        } else {
            String chocolateList = chocolates.isEmpty() ? "" : "Шоколад\n" + chocolates;
            String cakeList = cakes.isEmpty() ? "" : "Торты\n" + cakes;
            message.setText("В вашей корзине:\n" + chocolateList + cakeList);
        }
        message.setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(
                Arrays.asList(
                        Arrays.asList(
                                InlineKeyboardButton.builder().text("Выбрать еще").callbackData("Continue").build(),
                                InlineKeyboardButton.builder().text("Завершить заказ").callbackData("Complete").build()
                        )
                )
        ).build());
        bot.execute(message);
    }

}
