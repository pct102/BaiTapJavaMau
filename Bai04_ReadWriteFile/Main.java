package Bai04_ReadWriteFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyData data = new MyData();
        new MyThread("Insert", data).start();
        new MyThread("Update", data).start();
        new MyThread("Delete", data).start();
    }
}

class MyData{
    List<SinhVien> data;
    boolean write = true;
    String path = "D:/test.txt";
    public MyData() {
        data = new ArrayList<SinhVien>();

        data.add(new SinhVien("00001", "Nguyen Van A", "DHCNTT13B"));
        data.add(new SinhVien("00002", "Truong Thi B", "DHCNTT13B"));
        data.add(new SinhVien("00003", "Dang Van C", "DHCNTT13B"));
    }

    public void Display(){
        for (SinhVien sinhVien : data) {
            System.out.println(sinhVien.toString());
        }
    }

    public synchronized void Insert(){
        SerializeFileFactory.luuFile(data, path);
        Display();
    }

    public synchronized void Update(){
        data.clear();
        data = SerializeFileFactory.docFile(path);
        for (SinhVien sinhVien : data) {
            if(sinhVien.getMa().equals("00001")){
                sinhVien.setlop("DHCNTT13C");

            }
            else if(sinhVien.getMa().equals("00002")){
                sinhVien.setTen("Truong Thi Xuan");
            }
        }
        SerializeFileFactory.luuFile(data, path);
        Display();
    }

    public synchronized void Delete(){
        data.clear();
        data = SerializeFileFactory.docFile(path);
        List<SinhVien> temp = new ArrayList<SinhVien>();

        for (SinhVien sinhVien : data) {
            if(!sinhVien.getMa().equals("00002")){
                temp.add(sinhVien);
            }
        }

        data = temp;

        SerializeFileFactory.luuFile(data, path);
        Display();
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

class MyThread extends Thread{
    
    MyData data;
    public MyThread(String name, MyData data) {
        this.setName(name);
        this.data = data;
    }

    @Override
	public void run() {
        String name = getName();
        int sleepTime = ((int) (Math.random()*5000));
        try {
            System.out.println("thread " + this.getName() + " sleeping " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
		switch (name) {
        case "Insert":
            data.Insert();
			break;
        case "Update":
            data.Update();
            break;
        case "Delete":
            data.Delete();
            break;
		default:
			break;
        }
        
        System.out.println("Finish thread " + this.getName());
	}

}

class SinhVien extends Thread implements Serializable {
	private String ma;
	private String ten;
	private String lop;
    private static final long serialVersionUID = 1L;

	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getLop() {
		return this.lop;
	}
	public void setlop(String lop) {
		this.lop = lop;
	}
	public SinhVien(String ma, String ten, String lop) {
		this.ma = ma;
		this.ten = ten;
		this.lop = lop;
    }
    
    @Override
    public String toString() {
        return this.ma + " " + this.ten + " " + this.lop;
    }
}