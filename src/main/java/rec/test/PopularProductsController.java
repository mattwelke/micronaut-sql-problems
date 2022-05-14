package rec.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/popular-products")
public class PopularProductsController {

    private static final Logger LOG = LoggerFactory.getLogger(FakeDataGenerator.class);
    public PopularProductsService popularProductsService;

    public PopularProductsController(PopularProductsService popularProductsService) {
        this.popularProductsService = popularProductsService;

    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<PopularProductResult> index() {
        LOG.info("Received popular products request.");
        return popularProductsService.get();
    }
}
