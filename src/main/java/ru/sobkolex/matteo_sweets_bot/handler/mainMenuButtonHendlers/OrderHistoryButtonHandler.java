package ru.sobkolex.matteo_sweets_bot.handler.mainMenuButtonHendlers;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.handler.ButtonHandler;

import java.util.List;
import java.util.stream.Collectors;

public class OrderHistoryButtonHandler implements ButtonHandler {

    SendMessage message = new SendMessage();

    @Override
    @SneakyThrows
    public void send(Update update, MatteoSweetsTelegramBot bot, DAO dao) {
        String userId = update.getMessage().getChatId().toString();
        message.setChatId(userId);
        List<String> orders = dao.getOrderHistory(userId);
        if (orders.isEmpty())
            message.setText("Ваша история заказов пуста");
        else
            message.setText(orders.stream().collect(Collectors.joining("\n\n")));
        bot.execute(message);
    }
}
