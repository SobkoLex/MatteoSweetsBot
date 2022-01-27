package ru.sobkolex.matteo_sweets_bot.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Chocolate {

    private String type;
    private String size;
    private int cart;

    @Override
    public String toString() {
        String s = size.equals("Big")? "Большая" : "Маленькая";
        String t = "";
        if (type.equals("Black"))
            t = "черного";
        else if (type.equals("Caramel"))
            t = "карамелизированного";
        else if (type.equals("Milk"))
            t = "молочного";
        else
            t = "белого";
        return String.format("– %s плитка %s шоколада.\n",s,t);
    }
}
