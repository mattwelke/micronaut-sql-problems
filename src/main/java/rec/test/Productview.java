package rec.test;

import javax.persistence.*;

@Entity
public class Productview {
    @Id
    @GeneratedValue
    private Long id;
    private String productId;

    public Productview(String productId) {
        this.productId = productId;
    }

    public Productview() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Productview{" +
                "id=" + id +
                "productId=" + productId +
                '}';
    }
}