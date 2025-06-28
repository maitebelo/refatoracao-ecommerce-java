import java.util.*;

public class App {
    public static void main(String[] args) {
        Client client = new Client("João", "joao@email.com");
        DiscountPolicy discountPolicy = new DiscountPolicy(0.1);
        Order order = new Order(client, discountPolicy);
        order.addItem("Notebook", 1, 3500.0);
        order.addItem("Mouse", 2, 80.0);
        order.printInvoice();
        order.sendEmail();
    }
}

class Order {
    private Client client;
    private List<Item> items = new ArrayList<>();
    private DiscountPolicy discountPolicy;

    public Order(Client client, DiscountPolicy discountPolicy) {
        this.client = client;
        this.discountPolicy = discountPolicy;
    }

    public void addItem(String product, int quantity, double price) {
        items.add(new Item(product, quantity, price));
    }

    public void printInvoice() {
        printInvoiceHeader();
        printInvoiceItems();
        printInvoiceSummary();
    }

    public void sendEmail() {
        sendOrderConfirmationEmail();
    }

    private void printInvoiceHeader() {
        System.out.println("Cliente: " + client.getName());
    }

    private void printInvoiceItems() {
        for (Item item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct() + " - R$" + item.getPrice());
        }
    }

    private void printInvoiceSummary() {
        double total = calculateTotal();
        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + discountPolicy.calculateDiscount(total));
        System.out.println("Total final: R$" + discountPolicy.calculateFinalAmount(total));
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
    private double rate;

    public DiscountPolicy(double rate) {
        this.rate = rate;
    }

    public double calculateDiscount(double amount) {
        return amount * rate;
    }

    public double calculateFinalAmount(double amount) {
        return amount * (1 - rate);
    }
}