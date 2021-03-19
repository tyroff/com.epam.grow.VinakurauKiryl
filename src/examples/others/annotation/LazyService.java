package examples.others.annotation;

@Service(name = "ALazyService")

public class LazyService {

    @Init
    public void lazyInit() throws Exception {
        System.out.println("lazyInit is done!");
    }

}
