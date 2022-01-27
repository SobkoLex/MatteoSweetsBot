package ru.sobkolex.matteo_sweets_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.sobkolex.matteo_sweets_bot.config.SpringConfig;


@SpringBootApplication
public class MatteoSweetsBotApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringConfig.class,args);

    }

}
