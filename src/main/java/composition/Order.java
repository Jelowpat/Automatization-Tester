package composition;

import java.util.ArrayList;

public class Order {
    Customer customer;
    ArrayList<Product> productList = new ArrayList<>();
    private boolean paid = false;
    private boolean delivered = false;
    private int orderValue;

    public Order(Customer customer){
        this.customer = customer;
    }

    public void display() {
        System.out.println(customer);
        if (productList.size() > 0) {
            System.out.println(productList);
        } else {
            System.out.println("this order is empty");
        }
    }

    public void addProduct(Product product){
        productList.add(product);
        calculateOrderValue();
    }

    public void removeProduct(int index){
        if (index >= productList.size()){
            System.out.println("there is no product with such index");
        }
        else {
            productList.remove(index);
        }
        calculateOrderValue();
    }

    private void calculateOrderValue(){
        int total = 0;
        for(Product product:this.productList){
            total += product.getPrice();
        }
        this.orderValue = total;
    }

    public void confirmationOfPayment(boolean paid){
        this.paid = paid;
    }

    public void confirmationOfDelivery(boolean delivered){
        this.delivered = delivered;
    }

    public int getOrderValue(){
        return this.orderValue;
    }

    public void whatIsTheStatus(){
        if (this.delivered){
            System.out.println("the order has been delivered");
        }
        else if (this.paid){
            System.out.println("the payment has been completed, waiting for the delivery");
        }
        else{
            System.out.println("waiting for the payment");
        }
    }
}
