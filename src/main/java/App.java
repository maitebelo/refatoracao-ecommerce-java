import java.util.*;

public class App {
    public static void main(String[] args) {
        Order order = new Order();
        order.setClientName("João");
        order.setClientEmail("joao@email.com");
        order.addItem("Notebook", 1, 3500.0);
        order.addItem("Mouse", 2, 80.0);
        order.printInvoice();
        order.sendEmail();
    }
}

class Order {
    private String clientName;
    private String clientEmail;
    private List<Item> items = new ArrayList<>();
    private double discountRate = 0.1;

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void addItem(String product, int quantity, double price) {
        items.add(new Item(product, quantity, price));
    }

    public void printInvoice() {
        double total = 0;
        System.out.println("Cliente: " + clientName);
        for (Item item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct() + " - R$" + item.getPrice());
            total += item.getTotal();
        }
        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + (total * discountRate));
        System.out.println("Total final: R$" + (total * (1 - discountRate)));
    }

    public void sendEmail() {
        EmailService.sendEmail(clientEmail, "Pedido recebido! Obrigado pela compra.");
    }
}

class EmailService {
    public static void sendEmail(String to, String message) {
        System.out.println("Enviando e-mail para " + to + ": " + message);
    }
}

class DiscountPolicy {
    public static double calculateDiscount(double amount, double rate) {
        return amount * rate;
    }
}