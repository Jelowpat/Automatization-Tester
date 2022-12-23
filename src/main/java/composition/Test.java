package composition;

public class Test {
    public static void main(String[] args) {
        Customer firstClient = new Customer("Adam", "Nowak", 1);
        Customer secondClient = new Customer("Ania", "Madej", 2);
        Product scissors = new Product(10, "Scissors", "XYZ");
        Product paper = new Product(25, "Paper", "BIC");
        Product pencil = new Product(5, "Pencil", "ABC");

        Order firstOrder = new Order (firstClient);
        firstOrder.display();
        System.out.println("total: " + firstOrder.getOrderValue());

        firstOrder.addProduct(scissors);
        firstOrder.addProduct(paper);
        firstOrder.addProduct(pencil);
        firstOrder.display();
        System.out.println("total: " + firstOrder.getOrderValue());
        System.out.println("\n\n\n\n");

        firstOrder.removeProduct(4);
        firstOrder.removeProduct(1);
        firstOrder.display();
        System.out.println("total: " + firstOrder.getOrderValue());
        firstOrder.whatIsTheStatus();
        firstOrder.confirmationOfPayment(true);
        firstOrder.whatIsTheStatus();
        firstOrder.confirmationOfDelivery(true);
        firstOrder.whatIsTheStatus();
        System.out.println("\n\n\n\n");

        Order secondOrder = new Order (secondClient);
        secondOrder.addProduct(scissors);
        secondOrder.addProduct(paper);
        secondOrder.addProduct(paper);
        secondOrder.addProduct(scissors);
        secondOrder.addProduct(pencil);
        secondOrder.display();
        System.out.println("total: " + secondOrder.getOrderValue());
    }
}
