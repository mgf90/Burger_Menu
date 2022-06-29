package bm.burger_menu.Model;

import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        BREAD, PROTEIN, VEGETABLE, CHEESE, CONDIMENT
    }
}
