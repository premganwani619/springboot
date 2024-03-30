package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        ShoppingCart cart = context.getBean(ShoppingCart.class);
        cart.checkOut("Canceled");
        cart.quantity();
    }
}
//point cut (what to call)
//Joint point (Where to call)