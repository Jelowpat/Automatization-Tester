package data;

public enum Size {

    S("1"),
    M("2"),
    L("3"),
    XL("4");

    private String value;

    Size(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
