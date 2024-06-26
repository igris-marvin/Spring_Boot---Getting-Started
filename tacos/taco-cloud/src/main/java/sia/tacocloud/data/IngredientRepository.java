package sia.tacocloud.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    //METHODS ARE GENERATED AND IMPLEMENTED AT RUNTIME
}
