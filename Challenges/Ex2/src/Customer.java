public class Customer {
    private String username;
    private final Roles role = Roles.CUSTOMER;

    public Customer(String username) {
        this.username = username;
    }

    public Ticket createTicket(String message, String id){
        Ticket ticket = new Ticket(message, id, this);
        TicketLists.waitingList.add(ticket);
        return ticket;
    }
}
