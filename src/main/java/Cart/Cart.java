package Cart;

import Products.BaseProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Cart {

    //using Eager initialization
    private List<BaseProduct> products = new ArrayList<>();

    public void addProduct(BaseProduct product) {
        this.products.add(product);
    }

    //decided to add it in as a functionality, because why not
    public void removeProduct(BaseProduct product) {
        this.products.remove(product);
    }

    //returns the total price of items currently inside cart, applying discount if eligible
    public Double getTotalPrice() {
        return products.stream().mapToDouble(BaseProduct::getPrice).sum();
    }

    public List<BaseProduct> getProducts() {
        return Collections.unmodifiableList(products);
    }

}
