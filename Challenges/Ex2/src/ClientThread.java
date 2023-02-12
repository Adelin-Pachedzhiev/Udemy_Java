import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            Roles role = Roles.valueOf(reader.readLine());
            switch (role) {
                case SUPPORT -> manageSupport(socket, reader, writer);
                case CUSTOMER -> manageCustomer(socket, reader, writer);
                default -> System.out.println("invalid");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void manageSupport(Socket socket, BufferedReader reader, PrintWriter writer) {
        try {
            writer.write("enter username");
            Support sup = new Support(reader.readLine());
            TicketLists.printList(TicketLists.waitingList);
            int index = reader.read();
            sup.resolveTicket(index);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void manageCustomer(Socket socket, BufferedReader reader, PrintWriter writer) {
        try{
            writer.write("enter id");
            Customer customer = new Customer(reader.readLine());
            String message = reader.readLine();
            String id = reader.readLine();
            customer.createTicket(message, id);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
