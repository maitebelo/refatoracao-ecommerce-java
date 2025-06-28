import java.util.*;

public class App {
    public static void main(String[] args) {
        Client client = new Client("João", "joao@email.com");
        Order order = new Order(client);
        order.addItem("Notebook", 1, 3500.0);
        order.addItem("Mouse", 2, 80.0);
        order.printInvoice();
        order.sendEmail();
    }
}

class Order {
    private Client client;
    private List<Item> items = new ArrayList<>();
    private double discountRate = 0.1;

    public Order(Client client) {
        this.client = client;
    }

    public void addItem(String product, int quantity, double price) {
        items.add(new Item(product, quantity, price));
    }

    public void printInvoice() {
        double total = calculateTotal();
        System.out.println("Cliente: " + client.getName());
        for (Item item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct() + " - R$" + item.getPrice());
        }
        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + calculateDiscount(total));
        System.out.println("Total final: R$" + calculateFinalTotal(total));
    }

    public void sendEmail() {
        sendOrderConfirmationEmail();
    }

    private void sendOrderConfirmationEmail() {
        EmailService.sendEmail(client.getEmail(), generateOrderConfirmationMessage());
    }

    private double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotal();
        }
        return total;
    }

    private double calculateDiscount(double total) {
        return total * discountRate;
    }

    private double calculateFinalTotal(double total) {
        return total * (1 - discountRate);
    }

    private String generateOrderConfirmationMessage() {
        return "Pedido recebido! Obrigado pela compra.";
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