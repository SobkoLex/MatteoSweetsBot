package ru.sobkolex.matteo_sweets_bot.handler;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;
import ru.sobkolex.matteo_sweets_bot.buttons.MainMenuButtons;
import ru.sobkolex.matteo_sweets_bot.handler.button_handlers.BiscuitButtonHandler;
import ru.sobkolex.matteo_sweets_bot.handler.button_handlers.CakeButtonHandler;
import ru.sobkolex.matteo_sweets_bot.handler.button_handlers.ChocolateButtonHandler;
import ru.sobkolex.matteo_sweets_bot.handler.button_handlers.MousseButtonHandler;

import java.util.Arrays;

@AllArgsConstructor
public class CallBackHandler {


//    private Update update;
//    private MatteoSweetsTelegramBot bot;
//
//
//    @SneakyThrows
//    private void handleCallback(CallbackQuery callbackQuery) {
//        Message message = callbackQuery.getMessage();
//        String data = callbackQuery.getData();
//        switch (data){
//            case "Chocolate":
//                //bot.execute(new ChocolateButtonHandler(message));
//                break;
//            case "Cake":
//                //bot.execute(new CakeButtonHandler(message));
//                break;
//            case "Mousse":
//                //bot.execute(new MousseButtonHandler(message));
//                break;
//            case "Biscuit":
//                //bot.execute(new BiscuitButtonHandler(message));
//                break;
//            case "Continue":
//                bot.execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Поехали!").replyMarkup(new MainMenuButtons()).build());
//                break;
//            case "ConnectOperator":
//                bot.execute(SendMessage.builder().text("@bonbons_Ks").chatId(message.getChatId().toString()).build());
//                break;
//            case "Post":
//                bot.setDeliveryMethod("Почтой\n");
//                bot.setReplyNeeded(true);
//                bot.setReplyId(message.getChatId().toString());
//                bot.execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Укажите адресс доставки почтой:").build());
//                break;
//            case "Carrier":
//                bot.setDeliveryMethod("Курьером\n");
//                bot.setReplyNeeded(true);
//                bot.setReplyId(message.getChatId().toString());
//                bot.execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Укажите адресс доставки курьером:").build());
//                break;
//            case "Pickup":
//                dao.updateDeliveryMethod(callbackQuery.getFrom(),"Самовывоз\n", "Адрес: г. Краснодар, ул. 40 лет Победы 33/6");
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Cпособ доставки успешно изменен.\n" +
//                        "Текущий метод доставки:\n" +
//                        "Самовывоз\n" + "Адрес: г. Краснодар, ул. 40 лет Победы 33/6").build());
//                break;
//            case "White":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Выберите размер шоколадки:\n" +
//                                "Большая, 150-200 гр.\n" +
//                                "Маленькая, 100 - 120 гр.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(InlineKeyboardButton.builder().text("Большая").callbackData("Big").build(),
//                                        InlineKeyboardButton.builder().text("Маленькая").callbackData("Small").build())
//                        )).build()).build());
//                break;
//            case "Milk":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Выберите размер шоколадки:\n" +
//                                "Большая, 150-200 гр.\n" +
//                                "Маленькая, 100 - 120 гр.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(InlineKeyboardButton.builder().text("Большая").callbackData("Big").build(),
//                                        InlineKeyboardButton.builder().text("Маленькая").callbackData("Small").build())
//                        )).build()).build());
//                break;
//            case "Caramel":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Выберите размер шоколадки:\n" +
//                                "Большая, 150-200 гр.\n" +
//                                "Маленькая, 100 - 120 гр.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(InlineKeyboardButton.builder().text("Большая").callbackData("Big").build(),
//                                        InlineKeyboardButton.builder().text("Маленькая").callbackData("Small").build())
//                        )).build()).build());
//                break;
//            case "Black":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Выберите размер шоколадки:\n" +
//                                "Большая, 150-200 гр.\n" +
//                                "Маленькая, 100 - 120 гр.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(InlineKeyboardButton.builder().text("Большая").callbackData("Big").build(),
//                                        InlineKeyboardButton.builder().text("Маленькая").callbackData("Small").build())
//                        )).build()).build());
//                break;
//            case "Big":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Вы выбрали большую плитку какого-то шоколада!\n" +
//                                "Выберите начинку шоколадки:\n" +
//                                "Какая-то начинка 1.\n" +
//                                "Какая-то начинка 2.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(InlineKeyboardButton.builder().text("Какая-то начинка 1.").callbackData("Something 1").build(),
//                                        InlineKeyboardButton.builder().text("Какая-то начинка 2.").callbackData("Something 2").build())
//                        )).build()).build());
//                break;
//            case "Small":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Вы выбрали маленькую плитку КАКЛГО-ТО шоколада!\n" +
//                                "Выберите начинку шоколадки:\n" +
//                                "Какая-то начинка 1.\n" +
//                                "Какая-то начинка 2.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(InlineKeyboardButton.builder().text("Какая-то начинка 1.").callbackData("Something 1").build(),
//                                        InlineKeyboardButton.builder().text("Какая-то начинка 2.").callbackData("Something 2").build())
//                        )).build()).build());
//            case "Something 1":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Вы выбрали КАКУЕ-ТО (РАЗМЕР) плитку КАКЛГО-ТО шоколада!\n" +
//                                "Выберите дизайн шоколадки:\n" +
//                                "Какой-то дизайн 1.\n" +
//                                "Какой-то дизайн 2.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(InlineKeyboardButton.builder().text("Какой-то дизайн 1.").callbackData("Design 1").build(),
//                                        InlineKeyboardButton.builder().text("Какой-то дизайн 2.").callbackData("Design 2").build())
//                        )).build()).build());
//                break;
//            case "Something 2":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Вы выбрали КАКУЕ-ТО (РАЗМЕР) плитку КАКЛГО-ТО шоколада!\n" +
//                                "Выберите дизайн шоколадки:\n" +
//                                "Какой-то дизайн 1.\n" +
//                                "Какой-то дизайн 2.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(InlineKeyboardButton.builder().text("Какой-то дизайн 1.").callbackData("Design 1").build(),
//                                        InlineKeyboardButton.builder().text("Какой-то дизайн 2.").callbackData("Design 2").build())
//                        )).build()).build());
//                break;
//            case "Design 1":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Вы выбрали КАКУЕ-ТО (РАЗМЕР) плитку КАКЛГО-ТО шоколада с ТАКИМ дизайном!\n" +
//                                "Подтвердить заказ?:\n" +
//                                "Да.\n" +
//                                "Нет.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(
//                                        InlineKeyboardButton.builder().text("Да").callbackData("Yes").build(),
//                                        InlineKeyboardButton.builder().text("Нет.").callbackData("No").build())
//                        )).build()).build());
//                break;
//            case "Design 2":
//                execute(SendMessage.builder().chatId(message.getChatId().toString()).text("Вы выбрали КАКУЕ-ТО (РАЗМЕР) плитку КАКЛГО-ТО шоколада с ТАКИМ дизайном!\n" +
//                                "Подтвердить заказ?:\n" +
//                                "Да.\n" +
//                                "Нет.")
//                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(Arrays.asList(
//                                Arrays.asList(
//                                        InlineKeyboardButton.builder().text("Да").callbackData("Yes").build(),
//                                        InlineKeyboardButton.builder().text("Нет.").callbackData("No").build())
//                        )).build()).build());
//                break;
//            case "Yes":
//                execute(SendMessage.builder().chatId(BOT_ADMIN).text("ОНО выбрало КАКУЕ-ТО (РАЗМЕР) плитку КАКЛГО-ТО шоколада с ТАКИМ дизайном!").build());
//                break;
//            case "No":
//                execute(SendMessage.builder().chatId(BOT_ADMIN).text("ОНО передумало, но хотело КАКУЕ-ТО (РАЗМЕР) плитку КАКЛГО-ТО шоколада с ТАКИМ дизайном!").build());
//                break;
//            case "Biscuit cake 1":
//
//                break;





//        }
//    }

}
