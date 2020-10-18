import java.rmi.Remote;
import java.rmi.RemoteException;

// B1: Chay javac *.java cho ra 4 file class
// B2.: chay rmic, cho ra file Stub
// B3: chay rmiregistry; chay cua so moi truong, giu nguyen
// B4: chay java Server; roi chay Client

public interface DoiDonVi extends Remote{
    public double DoiTienVND(int tienUSD) throws RemoteException;
    public double DoiKG(int pound) throws RemoteException;
} 