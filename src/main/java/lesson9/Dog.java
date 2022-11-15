package lesson9;

public class Dog extends Animal{

    public Dog(String name){
        super (name, 4, 0);
    }
    @Override
    public void fly(){
        System.out.println("I can't fly");
    }
    public void bark() {
        System.out.println("Bark, Bark, my name is " + this.name);
    }
}
