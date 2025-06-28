public class Client {
    private String name;
    private String email;
    
    public Client(String name, String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("E-mail do cliente não pode ser nulo ou vazio");
        }
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
} 