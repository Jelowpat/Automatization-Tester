package backend.data;


public class CreateUserDummyRQ {
    private String name;
    private String salary;
    private String age;

    public CreateUserDummyRQ(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
