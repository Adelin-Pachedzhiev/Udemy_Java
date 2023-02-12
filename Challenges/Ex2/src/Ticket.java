public class Ticket {
    private String message;
    private String id;
    private Support processedBy;
    private boolean isResolved;
    private Customer sendBy;

    public String getMessage() {
        return message;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public String getId() {
        return id;
    }

    public void resolve(Support sup){
        processedBy = sup;
        isResolved = true;

    }
    public Ticket(String message, String id, Customer customer) {
        this.message = message;
        this.id = id;
        processedBy = null;
        sendBy = customer;
        isResolved = false;
    }
}
