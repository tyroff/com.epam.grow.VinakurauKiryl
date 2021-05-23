package examples.myEnum;

public class Main {
    public static void main(String[] args) {
        System.out.println(Seasons.SUMMER);
        System.out.println(Seasons.FALL);
        System.out.println(Seasons.SPRING);
        System.out.println(Seasons.WINTER);
        System.out.println("-------------");
        for (Seasons season : Seasons.values()) {
            System.out.println(season);
        }
        System.out.println("-------------");
        System.out.println(Seasons.WINTER.name());
        System.out.println(Seasons.WINTER.ordinal());
        System.out.println(Seasons.WINTER.toString());
        System.out.println("-------------");
        for (Seasons season : Seasons.values()) {
            System.out.println(season + " " + season.nameMonth);
        }

    }
}
