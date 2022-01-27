package ru.sobkolex.matteo_sweets_bot.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.sobkolex.matteo_sweets_bot.model.BotUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BotUserMapper implements RowMapper<BotUser> {
    @Override
    public BotUser mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        BotUser user = new BotUser();

        user.setId(resultSet.getString("id"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setDeliveryMethod(resultSet.getString("deliveryMethod"));
        user.setDeliveryAddress(resultSet.getString("deliveryAddress"));

        return user;
    }
}
