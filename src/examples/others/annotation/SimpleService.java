package examples.others.annotation;

@Service(name = "ASimpleService")
public class SimpleService {

    @Init
    public void initService() {
        System.out.println("initService is done!");
    }

    public void notInitService() {
        System.out.println("It is notInitService!");
    }

}
