package rec.test;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Singleton;

@Singleton
public class PopularProductsServiceImpl implements PopularProductsService {

    @Override
    public List<PopularProductResult> get() {
        List<PopularProductResult> results = new ArrayList<>();
        results.add(new PopularProductResult("abc", 2));
        results.add(new PopularProductResult("def", 1));
        return results;
    }
}
