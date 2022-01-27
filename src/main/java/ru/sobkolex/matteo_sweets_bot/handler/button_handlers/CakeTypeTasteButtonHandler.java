package ru.sobkolex.matteo_sweets_bot.handler.button_handlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.sobkolex.matteo_sweets_bot.model.Cake;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CakeTypeTasteButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();

    {
        message.setReplyMarkup(InlineKeyboardMarkup.builder().keyboard(
                Arrays.asList(
                        Arrays.asList(
                                InlineKeyboardButton.builder().text("Добавить в корзину").callbackData("AddToCart Cake").build(),
                                InlineKeyboardButton.builder().text("Связаться с продавцом.").callbackData("ConnectOperator").build())
                )).build());
    }

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        String userId = update.getCallbackQuery().getFrom().getId().toString();
        String[] data = update.getCallbackQuery().getData().split(" ");
        String type = data[1].equals("MousseCake")? "Муссовый" : "Бисквитный";
        List<Cake> cakes = dao.getCakes(userId).stream().filter(x -> x.getCart().equals("0")).collect(Collectors.toList());
        String[] mousse = new String[]{"\"Медовый апельсин\"","\"Ананасовый сорбет\"","\"Дабл_эпл\"","\"Три шоколада\"","\"Клубничный Шейк\"","\"Лимонный блюз\"","\"Бейлис\""};
        String[] biscuit = new String[]{"Молочный пломбир с карамелизированным бананом","Классический ванильный","Шоколадные тропики","Рафаэлло","Красный бархат с вишней","Малиновый бабл","Сникерс","Кофейная груша","Хрустящая вишня",};

        String taste = "";
        if (type.equals("Муссовый"))
            taste = mousse[Integer.parseInt(data[2]) - 1];
        else
            taste = biscuit[Integer.parseInt(data[2]) - 1];

        message.setChatId(userId);
        message.setText(
                "Вы выбрали:\n" +
                type + " торт " + taste + ".\n" +
                "Дизайн и вес обсуждается индивидуальено для каждого тортика.");

        if (cakes.isEmpty())
            dao.saveCake(userId,data[1],data[2]);
        else
            dao.updateCakeTypeTaste(data[1],data[2],userId);
        bot.execute(message);
    }
}
