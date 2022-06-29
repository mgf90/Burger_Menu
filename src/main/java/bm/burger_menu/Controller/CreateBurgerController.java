package bm.burger_menu.Controller;


import bm.burger_menu.Model.Burger;
import bm.burger_menu.Model.BurgerOrder;
import bm.burger_menu.Model.Ingredient;
import bm.burger_menu.Model.Ingredient.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/create")
@SessionAttributes("burgerOrder")
public class CreateBurgerController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("WHI", "White Bread", Ingredient.Type.BREAD),
                new Ingredient("WHE", "Wheat Bread", Ingredient.Type.BREAD),
                new Ingredient("BEF", "Beef", Ingredient.Type.PROTEIN),
                new Ingredient("BEA", "Black Bean", Ingredient.Type.PROTEIN),
                new Ingredient("LET", "Lettuce", Ingredient.Type.VEGETABLE),
                new Ingredient("TOM", "Tomato", Ingredient.Type.VEGETABLE),
                new Ingredient("ONI", "Onions", Ingredient.Type.VEGETABLE),
                new Ingredient("CHD", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("SWI", "Swiss", Ingredient.Type.CHEESE),
                new Ingredient("MUS", "Mustard", Ingredient.Type.CONDIMENT),
                new Ingredient("KET", "Ketchup", Ingredient.Type.CONDIMENT),
                new Ingredient("MAY", "Mayonnaise", Ingredient.Type.CONDIMENT)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "burgerOrder")
    public BurgerOrder order() {
        return new BurgerOrder();
    }

    @ModelAttribute(name = "burger")
    public Burger burger() {
        return new Burger();
    }

    @GetMapping
    public String showCreateForm() {
        return "create";
    }
    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
