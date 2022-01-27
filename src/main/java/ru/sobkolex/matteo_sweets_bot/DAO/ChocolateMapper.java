package ru.sobkolex.matteo_sweets_bot.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.sobkolex.matteo_sweets_bot.model.Chocolate;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChocolateMapper implements RowMapper<Chocolate> {
    @Override
    public Chocolate mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Chocolate chocolate = new Chocolate();

        chocolate.setSize(resultSet.getString("size"));
        chocolate.setType(resultSet.getString("type"));
        chocolate.setCart(resultSet.getInt("cart"));
        return chocolate;
    }
}
