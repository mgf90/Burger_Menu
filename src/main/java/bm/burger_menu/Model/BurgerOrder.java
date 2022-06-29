package bm.burger_menu.Model;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BurgerOrder {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String cardNum;
    private String cardExp;
    private String cardCVV;

    private List<Burger> burgers = new ArrayList<>();

    public void addBurger(Burger burger) {
        this.burgers.add(burger);
    }
}
