import java.rmi.Naming;
import java.rmi.Remote;

public class DoiDonViClient{
    public static void main(String[] args) {
        try {
            String s = "rmi://localhost/MyDoiDonVi";
            Remote remote = Naming.lookup(s);
            DoiDonVi doiDonVi = (DoiDonVi)remote;

            System.out.println("Doi tu USD sang VND: " + doiDonVi.DoiTienVND(10));
            System.out.println("Doi tu pound sang Kg: "+ doiDonVi.DoiKG(100));
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}