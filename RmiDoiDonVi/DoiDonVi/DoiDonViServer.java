import java.rmi.Naming;
import java.rmi.server.*;

public class DoiDonViServer{
    public static void main(String[] args) {
        try {
            DoiDonViIml doiDV = new DoiDonViIml();
            UnicastRemoteObject.exportObject(doiDV, 9999);
            String s = "rmi://localhost/MyDoiDonVi";
            Naming.bind(s, doiDV);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}