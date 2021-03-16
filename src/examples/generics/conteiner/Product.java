package examples.generics.conteiner;

public abstract class Product<T extends Product<T>> implements Comparable<T> {
    String name;
    double price;

    protected abstract int deepCompare(Product p);

    @Override
    public int compareTo(Product p) {
        return 1;
    }
}
