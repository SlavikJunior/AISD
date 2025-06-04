package ordering;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Integer id;

    private Integer userId;

    private List<Product> products;

    public Order(Integer id, Integer userId, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.products = products;
    }

    @Override
    public String toString() {
        return userId + " " + products;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public Integer getUserId() {
        return userId;
    }
}
