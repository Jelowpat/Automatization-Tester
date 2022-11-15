package Composition;

public class Customer {
    private String name;
    private String surname;
    private final int clientID;

    public Customer(String name, String surname, int clientID){
        this.name = name;
        this.surname = surname;
        this.clientID = clientID;
    }

    @Override
    public String toString() {
        return "name: " + this.name + "\nsurname: " + this.surname + "\nclient ID: " + this.clientID;
    }
}
