package rec.test;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ProductviewRepository extends CrudRepository<Productview, Long> {
    @Executable
    Productview find(String productId);
}
