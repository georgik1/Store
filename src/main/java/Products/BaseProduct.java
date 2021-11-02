package Products;


public abstract class BaseProduct {

    private String name;
    private String brand;
    private Double price;

    protected BaseProduct(String name, String brand, Double price) {
        this.setName(name);
        this.setBrand(brand);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    private void setPrice(Double price) {
        this.price = price;
    }


    public abstract boolean isEligibleForDiscount();

    abstract public double getDiscountPercentage();//(if such exists)
}
