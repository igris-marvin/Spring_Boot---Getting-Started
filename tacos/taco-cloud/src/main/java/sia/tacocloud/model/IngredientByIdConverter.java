package sia.tacocloud.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import sia.tacocloud.data.IngredientRepository;
import sia.tacocloud.model.Ingredient.Type;

@Component                                      //Springs Converter DAO interface
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepository;
    
    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository) {

        this.ingredientRepository = ingredientRepository;
    }
 
    @Override
    public Ingredient convert(@NonNull String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}

