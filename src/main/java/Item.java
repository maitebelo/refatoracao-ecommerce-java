public class Item {
    private String product;
    private int quantity;
    private double price;
    
    public Item(String product, int quantity, double price) {
        if (product == null || product.trim().isEmpty()) {
            throw new IllegalArgumentException("Produto não pode ser nulo ou vazio");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getProduct() {
        return product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getTotal() {
        return price * quantity;
    }
} 