package ru.sobkolex.matteo_sweets_bot.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.sobkolex.matteo_sweets_bot.model.Cake;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CakeMapper implements RowMapper<Cake> {

    @Override
    public Cake mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Cake cake = new Cake();

        cake.setId(resultSet.getInt("id"));
        cake.setType(resultSet.getString("type"));
        cake.setTaste(resultSet.getString("taste"));
        cake.setUserDataId(resultSet.getString("user_data_id"));
        cake.setCart(resultSet.getString("cart"));

        return cake;
    }
}
