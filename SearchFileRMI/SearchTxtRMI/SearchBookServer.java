import java.rmi.*;
import java.rmi.server.*;

public class SearchBookServer {
    public static void main(String[] args) {
        try {
            SearchBookImpl doiDV = new SearchBookImpl();
            UnicastRemoteObject.exportObject(doiDV, 9999);
            String s = "rmi://localhost/MyDoiDonVi";
            Naming.bind(s, doiDV);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}
