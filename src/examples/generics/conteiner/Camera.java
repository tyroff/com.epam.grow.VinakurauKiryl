package examples.generics.conteiner;

public class Camera extends Product{
    double pixel;

    @Override
    protected int deepCompare(Product p) {
        return 2;
    }
}
