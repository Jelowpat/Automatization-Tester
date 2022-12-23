package composition;

public class Product {
    private int price;
    private final String productName;
    private final String productManufacturer;

    public Product(int price, String productName, String productManufacturer){
        this.price = price;
        this.productManufacturer = productManufacturer;
        this.productName = productName;
    }

    @Override
    public String toString(){
        return "product name: " + this.productName + " manufacturer: " + this.productManufacturer + " price: " + this.price;
    }

    public void setPrice(int price){
        if(price > 0){
            this.price = price;
        }
        else{
            System.out.println("price can not equal 0");
        }
    }

    public int getPrice(){
        return this.price;
    }
}
