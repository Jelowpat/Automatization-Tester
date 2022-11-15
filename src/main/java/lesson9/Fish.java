package lesson9;

public class Fish extends Animal{

    public Fish(String name){
        super (name, 0, 0);
    }
    @Override
    public void fly(){
        System.out.println("I can't fly");
    }
}
