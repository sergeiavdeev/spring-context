import components.Cart;
import components.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("components");

        ProductRepository repository = context.getBean(ProductRepository.class);
        repository.getAll().forEach(System.out::println);

        Cart cart1 = context.getBean(Cart.class);
        cart1.add(1);
        cart1.add(2);
        cart1.printCart();

        Cart cart2 = context.getBean(Cart.class);
        cart2.add(3);
        cart2.add(4);
        cart2.add(5);
        cart2.remove(3);
        cart2.printCart();
    }
}
