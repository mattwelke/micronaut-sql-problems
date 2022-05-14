package rec.test;

/**
 * A result from reading the database.
 */
public record PopularProductResult(String productId, int occurences) {
}
