package Products.PerishableProducts;

import Products.BaseProduct;
import java.time.LocalDate;


public class FoodAndBeverages extends BaseProduct {

    private LocalDate expirationDate;
    private boolean  hasDiscount;


    public FoodAndBeverages(String name, String brand, Double price, LocalDate expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;
        this.hasDiscount = false;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Override the calculation of the price of a Perishable product and apply the discount
    @Override
    public Double getPrice() {
        return super.getPrice() * (1.0 - getDiscountPercentage());
    }

    /* Calculate the discount percentage. If the expiration day is less than 5 days compared to current day,
     return a 10% discount.If the expiration day is on the same day compared to now, return a 50% discount, otherwise return 0*/
    public double getDiscountPercentage() {
        if (expirationDate.isBefore(LocalDate.now().minusDays(5))) {
            hasDiscount = true;
            return 0.1;
        }else if (expirationDate.equals(LocalDate.now())) {
            hasDiscount = true;
            return 0.5;
        } else {
            hasDiscount = false;
            return 0.0;
        }
    }



    public boolean isEligibleForDiscount(){
            return hasDiscount;
    }




}

