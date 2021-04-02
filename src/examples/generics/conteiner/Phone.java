package examples.generics.conteiner;

public class Phone extends Product {
    String model;

    @Override
    protected int deepCompare(Product p) {
        return 3;
    }
}
