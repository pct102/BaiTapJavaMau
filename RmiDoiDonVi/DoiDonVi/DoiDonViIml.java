import java.rmi.RemoteException;

public class DoiDonViIml implements DoiDonVi{
    @Override
    public double DoiKG(int pound) throws RemoteException {
        return pound * 0.45;
    }

    @Override
    public double DoiTienVND(int tienUSD) throws RemoteException {
        return tienUSD * 23.5;
    }

}