package lesson9;

public class Bird extends Animal{

    public Bird(String name){
        super (name, 2, 2);
    }
    @Override
    public void swim(){
        System.out.println("I can't swim");
    }
}
