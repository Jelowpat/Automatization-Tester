package data.selenide;

public enum Share {
    facebook("//a[@title=\"Share\"]"),
    twitter("//a[@title=\"Tweet\"]"),
    pinterest("//a[@title=\"Pinterest\"]");

    private String value;


    Share(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }

}
