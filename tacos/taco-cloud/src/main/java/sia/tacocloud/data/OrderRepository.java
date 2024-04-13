package sia.tacocloud.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import sia.tacocloud.model.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
    //METHODS ARE GENERATED AND IMPLEMENTED AT RUNTIME
}
