package sia.tacocloud.web;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import sia.tacocloud.model.Ingredient;
import sia.tacocloud.model.Ingredient.Type;
import sia.tacocloud.model.Taco;
import sia.tacocloud.model.TacoOrder;

@Slf4j
@Controller
@RequestMapping("/design") // <- DesignTacoController will handle requests whose path begins with /design
@SessionAttributes("tacoOrder") // <- will be remembered later, creation of a taco is also the first step in creating an order, and the order we create will need to be carried in the session so that it can span multiple requests.
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        List<Ingredient> ingredients = new ArrayList<>();
        
        ingredients.add(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
        ingredients.add(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
        ingredients.add(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
        ingredients.add(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
        ingredients.add(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
        ingredients.add(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
        ingredients.add(new Ingredient("CHED", "Cheddar", Type.CHEESE));
        ingredients.add(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
        ingredients.add(new Ingredient("SLSA", "Salsa", Type.SAUCE));
        ingredients.add(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        
        Type[] types = Ingredient.Type.values();

        for (Type type : types) { //iterates through all ingridients
            model.addAttribute(
                    type.toString().toLowerCase(), 
                    filterByType(ingredients, type)
                ); //adds attributes to model, filters ingridients to add to model
        }
    }

    @ModelAttribute(name = "tacoOrder") // <- adds an object/instance of TacoOrder class to the session
    public TacoOrder order() {

        return new TacoOrder();
    }
 
    @ModelAttribute(name = "taco") // <- adds an object/instance of Taco class to the session
    public Taco taco() {

        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {

        return "design";
    }

    private Iterable<Ingredient> filterByType(
    List<Ingredient> ingredients, Type type) {

        return ingredients
        .stream()
        .filter(x -> x.getType().equals(type))
        .collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco(
        @Valid Taco taco, 
        Errors errors,
        @ModelAttribute TacoOrder tacoOrder
    ) {
        
        if (errors.hasErrors()) {
            return "design"; // return to the same page/posting page
        }

        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect: /orders/current"; //redirect request to path /orders/request
    }
}