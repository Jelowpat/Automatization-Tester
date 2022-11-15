package lesson9;

public class Animal {

    protected String name;
    private int numberOfLegs;
    private int numberOfWings;

    public Animal(String name, int numberOfLegs, int numberOfWings){
        this.name = name;
        this.numberOfLegs = numberOfLegs;
        this.numberOfWings = numberOfWings;
    }

    public void fly(){ System.out.println("I'm flying"); }
    public void swim(){
        System.out.println("I'm swimming");
    }

}
