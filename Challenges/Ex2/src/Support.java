import javax.management.relation.Role;

public class Support {
    private String id;
    private final Roles role = Roles.SUPPORT;

    public Support(String id) {
        this.id = id;
    }

    public void resolveTicket(int index){
        if(!TicketLists.waitingList.get(index).isResolved()){
            TicketLists.waitingList.get(index).resolve(this);
            TicketLists.resolvedList.add(TicketLists.waitingList.get(index));
            TicketLists.waitingList.remove(index);
        }
    }
}
