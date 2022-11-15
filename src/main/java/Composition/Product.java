package Composition;

public class Product {
    private int price;
    private String productName;
    private String productManufacturer;

    public Product(int price, String productName, String productManufacturer){
        this.price = price;
        this.productManufacturer = productManufacturer;
        this.productName = productName;
    }

    @Override
    public String toString(){
        String representation = "product name: " + this.productName + " manufacturer: " + this.productManufacturer + " price: " + this.price;
        return representation;
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
