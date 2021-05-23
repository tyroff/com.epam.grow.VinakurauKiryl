package examples.myEnum;

public enum Seasons {
    WINTER("January"),
    SUMMER("July"),
    SPRING("September"),
    FALL("May");

    String nameMonth;

    Seasons(String nameMonth) {
        this.nameMonth = nameMonth;
    }
}
