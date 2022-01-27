package ru.sobkolex.matteo_sweets_bot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.sobkolex.matteo_sweets_bot.MatteoSweetsTelegramBot;

@Configuration
@ComponentScan("ru.sobkolex.matteo_sweets_bot")
public class SpringConfig {

    @Value("${DB_URL}")
    String dbURL;
    @Value("${DB_USERNAME}")
    String dbUserName;
    @Value("${DB_PASSWORD}")
    String dbPassword;

    @Bean
    public MatteoSweetsTelegramBot telegramBot(){
        MatteoSweetsTelegramBot telegramBot = new MatteoSweetsTelegramBot();
        return telegramBot;
    }

    @Bean
    public void botsApi(){
        try {
            new TelegramBotsApi(DefaultBotSession.class).registerBot(telegramBot());
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(dbURL);
        dataSource.setPassword(dbPassword);
        dataSource.setUsername(dbUserName);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }


}
