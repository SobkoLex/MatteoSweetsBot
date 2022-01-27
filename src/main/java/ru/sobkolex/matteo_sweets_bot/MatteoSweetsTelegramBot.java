package ru.sobkolex.matteo_sweets_bot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.sobkolex.matteo_sweets_bot.DAO.DAO;
import ru.sobkolex.matteo_sweets_bot.handler.button_handlers.*;
import ru.sobkolex.matteo_sweets_bot.handler.mainMenuButtonHendlers.*;


@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatteoSweetsTelegramBot extends TelegramLongPollingBot {

    private boolean isReplyNeeded;
    private String replyId;
    private String deliveryMethod;

    @Getter
    @Value("${BOT_USER_NAME}")
    private
    String botUsername;

    @Getter
    @Value("${BOT_TOKEN}")
    private
    String botToken;

    @Autowired
    private DAO dao;

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()){
            handleCallback(update);
        }else if (update.hasMessage()) {
            handleMessage(update);
        }
    }



    @SneakyThrows
    private void handleCallback(Update update) {

        String[] data = update.getCallbackQuery().getData().split(" ");
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        switch (data[0]){
            case "Chocolate":
                new ChocolateButtonHandler().send(update,this, dao);
                break;
            case "Cake":
                new CakeButtonHandler().send(update,this, dao);
                break;
            case "Mousse":
                new MousseButtonHandler().send(update,this, dao);
                break;
            case "Biscuit":
                new BiscuitButtonHandler().send(update,this, dao);
                break;
            case "Continue":
                new MakeOrder().send(update,this,dao);
                break;
            case "ConnectOperator":
                execute(SendMessage.builder().text("@bonbons_Ks").chatId(chatId).build());
                break;
            case "Post":
                deliveryMethod = "Почтой\n";
                isReplyNeeded = true;
                replyId = chatId;
                execute(SendMessage.builder().chatId(chatId).text("Укажите адресс доставки почтой:").build());
                break;
            case "Carrier":
                deliveryMethod = "Курьером\n";
                isReplyNeeded = true;
                replyId = chatId;
                execute(SendMessage.builder().chatId(chatId).text("Укажите адресс доставки курьером:").build());
                break;
            case "Pickup":
                dao.updateDeliveryMethod(update.getCallbackQuery().getFrom(),"Самовывоз\n", "Адрес: г. Краснодар, ул. 40 лет Победы 33/6");
                execute(SendMessage.builder().chatId(chatId).text("Cпособ доставки успешно изменен.\n" +
                                                                  "Текущий метод доставки:\n" +
                                                                  "Самовывоз\n" + "Адрес: г. Краснодар, ул. 40 лет Победы 33/6").build());
                break;
            case "ChocolateType":
                new ChocolateTypeButtonHandler().send(update,this, dao);
                break;
            case "ChocolateSize":
                new ChocolateSizeButtonHandler().send(update,this,dao);
                break;
            case "AddToCart":
                new AddToCartButtonHandler().send(update,this,dao);
                break;
            case "Complete":
                new CompleteOrderButtonHandler().send(update,this,dao);
                break;
            case "CakeTypeTaste":
                new CakeTypeTasteButtonHandler().send(update,this,dao);






        }
    }

    @SneakyThrows
    private void handleMessage(Update update) {
        if (update.getMessage().hasText()) {
                switch (update.getMessage().getText()) {
                    case "/start":
                        new Start().send(update,this,dao);
                        break;
                    case "Корзина":
                        new CartButtonHandler().send(update,this,dao);
                        break;
                    case "История заказов":
                        new OrderHistoryButtonHandler().send(update,this,dao);
                        break;
                    case "Способы доставки":
                        new DeliveryButtonHandler().send(update, this, dao);
                        break;
                    case "Помощь":
                        new HelpButtonHandler().send(update,this,dao);
                        break;
                    case "Отзывы":
                        new FeedbackButtonHandler().send(update,this,dao);
                        break;
                    case "Каталог":
                        new CatalogButtonHandler().send(update,this,dao);
                    default:
                        if (isReplyNeeded && replyId.equals(update.getMessage().getFrom().getId().toString())){
                            dao.updateDeliveryMethod(update.getMessage().getFrom(), deliveryMethod,update.getMessage().getText());
                            execute(SendMessage.builder().chatId(update.getMessage().getChatId().toString()).text("Cпособ доставки успешно изменен.\n" +
                                    "Текущий метод доставки:\n" +
                                    dao.showDeliveryMethod(replyId).getDeliveryMethod() + dao.showDeliveryMethod(replyId).getDeliveryAddress()).build());
                            isReplyNeeded = false;
                            replyId = null;
                            deliveryMethod = null;
                        }
            }
        }
    }

}
