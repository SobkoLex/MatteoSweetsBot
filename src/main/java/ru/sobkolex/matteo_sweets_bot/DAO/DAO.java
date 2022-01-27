package ru.sobkolex.matteo_sweets_bot.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.User;
import ru.sobkolex.matteo_sweets_bot.model.BotUser;
import ru.sobkolex.matteo_sweets_bot.model.Cake;
import ru.sobkolex.matteo_sweets_bot.model.Chocolate;

import java.util.List;

@Component
public class DAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BotUser> index(){
        return jdbcTemplate.query("SELECT * FROM user_data", new BotUserMapper());
    }
    
    public void saveUser(User user){
        jdbcTemplate.update("INSERT INTO user_data SET id=?, firstName=?, lastName=?",user.getId(),user.getFirstName(),user.getLastName());
    }

    public BotUser showDeliveryMethod(String id){
       return jdbcTemplate.query("SELECT * FROM user_data WHERE id=?", new Object[]{id}, new BotUserMapper())
               .stream().findAny().orElse(null);
    }

    public void updateDeliveryMethod(User user, String deliveryMethod, String deliveryAddress){
        jdbcTemplate.update("UPDATE user_data SET deliveryMethod=?, deliveryAddress=? WHERE id=?",deliveryMethod,"Адрес: " +  deliveryAddress,user.getId().toString());
    }



    public List<Chocolate> getChocolate(String userId){
        return jdbcTemplate.query("SELECT * FROM chocolate WHERE user_data_id=?",new Object[]{userId},new ChocolateMapper());
    }

    public void saveChocolate(String userId,String type){
        jdbcTemplate.update("INSERT INTO chocolate SET user_data_id=?, type=?",userId,type);
    }

    public void updateChocolateType(String type,String userId){
        jdbcTemplate.update("UPDATE chocolate SET type=? WHERE user_data_id=? AND cart=0 ",type,userId);
    }

    public void updateChocolateSize(String size,String userId){
        jdbcTemplate.update("UPDATE chocolate SET size=? WHERE user_data_id=? AND cart=0 ",size,userId);
    }

    public void addChocolateToCart(String userId){
        jdbcTemplate.update("UPDATE chocolate SET cart=1 WHERE user_data_id=? AND cart=0 ",userId);
    }

    public void addToOrderHistory(String order, String userId){
        jdbcTemplate.update("INSERT INTO order_history SET user_data_id=?, order_data=?", userId, order);
    }

    public List<String> getOrderHistory(String userId){
        return jdbcTemplate.queryForList("SELECT order_data FROM order_history WHERE user_data_id=?", String.class, userId);
    }

    public void deleteAllChocolates(String userId){
        jdbcTemplate.update("DELETE FROM chocolate WHERE user_data_id=?",userId);
    }

    public void saveCake(String userId,String type, String taste){
        jdbcTemplate.update("INSERT INTO cake SET user_data_id=?, type=?, taste=?",userId,type,taste);
    }

    public void updateCakeTypeTaste(String type,String taste, String userId){
        jdbcTemplate.update("UPDATE cake SET type=?, taste=? WHERE user_data_id=? AND cart='0' ",type,taste,userId);
    }

    public void addCakeToCart(String userId){
        jdbcTemplate.update("UPDATE cake SET cart='1' WHERE user_data_id=? AND cart='0' ",userId);
    }

    public List<Cake> getCakes(String userId){
        return jdbcTemplate.query("SELECT * FROM cake WHERE user_data_id=?",new Object[]{userId},new CakeMapper());
    }

    public void deleteAllCakes(String userId){
        jdbcTemplate.update("DELETE FROM cake WHERE user_data_id=?",userId);
    }

}
