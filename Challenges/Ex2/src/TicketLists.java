import java.util.ArrayList;
import java.util.List;

public class TicketLists {
    public static List<Ticket> waitingList = new ArrayList<>();
    public static List<Ticket> resolvedList = new ArrayList<>();

    public static void printList(List<Ticket> list){
        for(Ticket ticket: list){
            System.out.println(ticket.getId() + " ," + ticket.getMessage());
        }
    }
}
