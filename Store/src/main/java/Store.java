import Cart.Cart;
import Cashier.Cashier;
import Products.Appliances.Appliances;
import Products.Clothes.Clothes;
import Products.Clothes.Sizes;
import Products.PerishableProducts.FoodAndBeverages;
import java.time.LocalDate;


public class Store {
    public static void main(String[] args) {
        
        Cart cart = new Cart();
        cart.addProduct(new FoodAndBeverages("apples", "BrandA", 1.50,
                LocalDate.of(2021, 6, 14)));
        cart.addProduct(new FoodAndBeverages("apples", "BrandA", 1.50,
                LocalDate.of(2021, 6, 14)));
        cart.addProduct(new FoodAndBeverages("milk", "BrandM", 0.99,
                LocalDate.of(2022, 2, 2)));
        cart.addProduct(new FoodAndBeverages("milk", "BrandM", 0.99,
                LocalDate.of(2022, 2, 2)));
        cart.addProduct(new FoodAndBeverages("milk", "BrandM", 0.99,
                LocalDate.of(2022, 2, 2)));
        cart.addProduct(new Clothes("T-shirt", "BrandT", 15.99, Sizes.M, "violet"));
        cart.addProduct(new Appliances("laptop", "BrandL", 2345.0, "ModelL",
                LocalDate.of(2021, 3, 3)));

        Cashier cashier = new Cashier();
        cashier.printReceipt(cart);

    }


}
