package Products.Appliances;

import Products.BaseProduct;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;


public class Appliances extends BaseProduct {

    private String model;
    private LocalDate productionDate;


    public Appliances(String name, String brand, Double price, String model, LocalDate productionDate) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public Double getPrice() {
        return super.getPrice() * (1.0 - getDiscountPercentage());
    }

    /*Checking whether or not current day(locally) is a weekend day.
    Surely not the best way to do it, but should be good enough for testing purposes
    */
    @Override
    public boolean isEligibleForDiscount() {
        if (isWeekend(LocalDate.now()) && getPriceWithoutDiscount() > 999) {
            return true;
        }
        return false;
    }

    public Double getPriceWithoutDiscount() {
        return super.getPrice();
    }

    @Override
    public double getDiscountPercentage() {
        if (isWeekend(LocalDate.now()) && getPriceWithoutDiscount() > 999) {
            return 0.05;
        }
        return 0.0;
    }

    //we have some repetitive code -> can put it inside BaseProduct later
    public static boolean isWeekend(final LocalDate date) {
        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }
}
