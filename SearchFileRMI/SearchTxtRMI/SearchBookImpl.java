import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class SearchBookImpl implements SearchBook {
    String path = "SearchBook.txt"

    @Override
    public List<BookInfo> SearchByBookID(String bookID) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookInfo> SearchByName(String name) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookInfo> SearchByAuthor(String author) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookInfo> SearchByReleaseDate(String releaseDate) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BookInfo> SearchByType(String type) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean AddBook(BookInfo book) throws RemoteException {

        return SerializeFileFactory.luuFile(book, path);
    }

    @Override
    public boolean UpdateBook(BookInfo book) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean DeleteBook(BookInfo book) throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean AddBooks(List<BookInfo> books) throws RemoteException {
        for (BookInfo bookInfo : books) {
            if(!SerializeFileFactory.luuFile(bookInfo, path))
                return false;
        }
        return true;
    }

    public int GetMaxBookID(){
        List<BookInfo> books = new ArrayList<BookInfo>();
        books = SerializeFileFactory.docFile(path);

        if(books.size() == 0){
            return 1;
        }
        else{
            return Integer.parseInt(books.get(books.size() - 1).GetBookID()) + 1;
        }

    }
}

class SerializeFileFactory {
    public static boolean luuFile(Object data, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static <T> List<T> docFile(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<T> data = (List<T>) ois.readObject();
			ois.close();
			fis.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
