public class DiscountPolicy {
    private double discountRate;
    
    public DiscountPolicy(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public double calculateDiscount(double amount) {
        return amount * discountRate;
    }
    
    public double calculateFinalAmount(double amount) {
        return amount * (1 - discountRate);
    }
    
    public double getDiscountRate() {
        return discountRate;
    }
} 