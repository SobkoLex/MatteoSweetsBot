package ru.sobkolex.matteo_sweets_bot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cake {

    private int id;
    private String userDataId;
    private String type;
    private String taste;
    private String cart;

    @Override
    public String toString() {
        String[] mousse = new String[]{"\"Медовый апельсин\"","\"Ананасовый сорбет\"","\"Дабл_эпл\"","\"Три шоколада\"","\"Клубничный Шейк\"","\"Лимонный блюз\"","\"Бейлис\""};
        String[] biscuit = new String[]{"Молочный пломбир с карамелизированным бананом","Классический ванильный","Шоколадные тропики","Рафаэлло","Красный бархат с вишней","Малиновый бабл","Сникерс","Кофейная груша","Хрустящая вишня",};
        if (type.equals("MousseCake")){
            taste = mousse[Integer.parseInt(taste) - 1];
            type = "Муссовый";
        }else {
            taste = biscuit[Integer.parseInt(taste) - 1];
            type = "Бисквитный";
        }


        return String.format("– %s торт %s.\n", type,taste);
    }
}
