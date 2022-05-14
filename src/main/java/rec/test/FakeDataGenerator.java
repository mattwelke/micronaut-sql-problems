package rec.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;

/**
 * Creates fake popular product data and writes it to the database. This
 * simulates a stream of events coming in
 * constantly as the application runs. Either the application itself or a
 * separate service could be responsible for
 * streaming the events into the database.
 */
@Singleton
public class FakeDataGenerator {

    private static List<String> availableProductIds;

    private static final Logger LOG = LoggerFactory.getLogger(FakeDataGenerator.class);

    protected final ProductviewRepository productviewRepository;

    public FakeDataGenerator(ProductviewRepository productviewRepository) {
        availableProductIds = new ArrayList<>();
        availableProductIds.add("abc123");
        availableProductIds.add("def456");
        availableProductIds.add("ghi789");

        this.productviewRepository = productviewRepository;
    }

    @Scheduled(fixedDelay = "1s")
    public void run() {
        LOG.info("Inserting fake product view.");

        var view = new Productview();
        view.setProductId(fakeProductId());
        productviewRepository.save(view);

        LOG.info("Inserted fake product view:" + view);
    }

    /**
     * Generates a fake popular product result.
     * 
     * @return The product ID for the fake event.
     */
    private static String fakeProductId() {
        Random rand = new Random();
        return availableProductIds.get(rand.nextInt(availableProductIds.size()));
    }
}
