package ru.sobkolex.matteo_sweets_bot.handler.button_handlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sobkolex.matteo_sweets_bot.model.Cake;
import ru.sobkolex.matteo_sweets_bot.model.Chocolate;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

public class CompleteOrderButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        String userId = update.getCallbackQuery().getFrom().getId().toString();
        String chocolateOrder = dao.getChocolate(userId).stream().map(Chocolate::toString).collect(Collectors.joining());
        String cakeOrder = dao.getCakes(userId).stream().map(Cake::toString).collect(Collectors.joining());
        chocolateOrder = chocolateOrder.isEmpty()? "" : "Шоколад\n"+ chocolateOrder;
        cakeOrder = cakeOrder.isEmpty()? "" : "Торты\n" + cakeOrder;
        message.setChatId(userId);
        String orderHistory = String.format(
                "Содержание заказа: \n" +
                chocolateOrder +
                cakeOrder +
                "Дата: " + new SimpleDateFormat("dd MMMM yyyy").format(new Date()));
        message.setText("Спасибо за ваш заказ. В ближайшее время с вами свяжется продавец.\n" +
                "Вы выбрали: \n" + chocolateOrder + cakeOrder);

        dao.addToOrderHistory(orderHistory,userId);
        dao.deleteAllChocolates(userId);
        dao.deleteAllCakes(userId);

        if (!cakeOrder.isEmpty()&&!chocolateOrder.isEmpty()){
            bot.execute(message);
            bot.execute(SendMessage.builder().chatId("5060682407").text("Заказ от : \n" + update.getCallbackQuery().getFrom() + "\n" + orderHistory).build());
        }

    }
}
