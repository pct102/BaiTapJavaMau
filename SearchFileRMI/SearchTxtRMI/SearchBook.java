import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SearchBook extends Remote{
    public List<BookInfo> SearchByBookID(String bookID) throws RemoteException;
    public List<BookInfo> SearchByName(String name) throws RemoteException;
    public List<BookInfo> SearchByAuthor(String author) throws RemoteException;
    public List<BookInfo> SearchByReleaseDate(String releaseDate) throws RemoteException;
    public List<BookInfo> SearchByType(String type) throws RemoteException;


    public boolean AddBook(BookInfo book) throws RemoteException;
    public boolean AddBooks(List<BookInfo> books) throws RemoteException;
    public boolean UpdateBook(BookInfo book) throws RemoteException;
    public boolean DeleteBook(BookInfo book) throws RemoteException;

    

}