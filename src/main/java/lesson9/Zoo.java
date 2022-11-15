package lesson9;

public class Zoo {
    public static void main(String[] args) {
        Dog Burek = new Dog("Burek");
        Fish Nemo = new Fish("Nemo");
        Bird Elemelek = new Bird("Elemelek");

        System.out.println("Burek:");
        Burek.fly();
        Burek.swim();
        Burek.bark();
        System.out.println("Nemo:");
        Nemo.fly();
        Nemo.swim();
        System.out.println("Elemelek:");
        Elemelek.fly();
        Elemelek.swim();
    }
}
