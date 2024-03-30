package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkOut(String status) {
        System.out.println("Checkout method is called");
    }

    public String quantity() {
        return "Some String";
    }

}
