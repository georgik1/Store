package Cashier;

import Cart.Cart;
import Products.BaseProduct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Cashier {

    public void printReceipt(Cart cart) {

        //make a method call to get date and time
        getCurrentDateAndTime();
        System.out.println("---Products---");
        System.out.println();

        Map<String, List<BaseProduct>> productGroups = cart.getProducts()
                .stream()
                .collect(Collectors
                        .groupingBy(baseProduct -> baseProduct.getName() + " - " + baseProduct.getBrand()));

        for (Map.Entry<String, List<BaseProduct>> productGroup : productGroups.entrySet()) {
            List<BaseProduct> products = productGroup.getValue();
            BaseProduct product = products.get(0);
            System.out.println(productGroup.getKey());
            System.out.printf("%d X $%.2f = $%.2f%n",
                    products.size(), product.getPrice(), products.size() * product.getPrice());

            List<BaseProduct> discountEligibleProducts = products.stream().filter(BaseProduct::isEligibleForDiscount)
                    .collect(Collectors.toList());

            //check the discount
            if (!discountEligibleProducts.isEmpty()) {
                discountEligibleProducts.forEach(currentProduct ->
                        System.out.printf("#discount %.2f%%%n", currentProduct.getDiscountPercentage()));
                System.out.printf("Discount sum: -%.2f$%n", discountEligibleProducts.stream()
                        .filter(BaseProduct::isEligibleForDiscount)
                        .mapToDouble(p -> p.getPrice() * p.getDiscountPercentage())
                        .sum());
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------------------------------------------------");

        System.out.printf("SUBTOTAL: $%.2f%n", cart.getProducts()
                .stream()
                .mapToDouble(BaseProduct::getPrice)
                .sum());

        System.out.printf("DISCOUNT: -$%.2f%n", cart.getProducts()
                .stream()
                .mapToDouble(baseProduct ->
                        baseProduct.getPrice() * baseProduct.getDiscountPercentage())
                .sum());
        System.out.println();
        System.out.printf("TOTAL: $%.2f%n", cart.getProducts()
                .stream()
                .mapToDouble(baseProduct ->
                        baseProduct.getPrice() * (1.0 - baseProduct.getDiscountPercentage()))
                .sum());

    }

    private void getCurrentDateAndTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}

