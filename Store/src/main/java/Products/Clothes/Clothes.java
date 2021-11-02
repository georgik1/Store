package Products.Clothes;

import Products.BaseProduct;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;


public class Clothes extends BaseProduct {

    private Sizes size;
    private String color;
    private LocalDate date;


    public Clothes(String name, String brand, Double price, Sizes size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    public Sizes getSize() {
        return size;
    }

    public void setSize(Sizes size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //get price with discount
    @Override
    public Double getPrice() {
        return super.getPrice() * (1.0 - getDiscountPercentage());
    }


    @Override
    public boolean isEligibleForDiscount() {
        if (isWeekend(LocalDate.now())) {
            return false;
        }
        return true;
    }

    //check for discount.(if it's the weekend -> we don't have one)
    @Override
    public double getDiscountPercentage() {
        if (!isWeekend(LocalDate.now())) {
            return 0.1;
        }
        return 0.0;
    }


    //check whether it's the weekend
    public static boolean isWeekend(final LocalDate date) {
        DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }
}
