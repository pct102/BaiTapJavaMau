package Bai03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
Thread(): Allocates a new Thread object
Thread(Runnable target): Allocates a new Thread object
Thread(Runnable target, String name): Allocates a new Thread object
Thread(String name): Allocates a new Thread object
Thread(ThreadGroup group, Runnable target): Allocates a new Thread object
Thread(ThreadGroup group, Runnable target, String name): Allocates a new Thread object so that it has target as its run object, 
has the specified name as its name, and belongs to the thread group referred to by group
Thread(ThreadGroup group, Runnable target, String name, long stackSize): Allocates a new Thread object so that it has target as 
its run object, has the specified name as its name, and belongs to the thread group referred to by group, and has the specified stack size
Thread(ThreadGroup group, String name): CAllocates a new Thread object

Nhap vao 1 chuoi
thread 1: In chuoi Hoa
thread 2: In chuoi Thuong
thread 3: In Chuoi Number
thread 4: In chuoi Ky Tu Dac Biet
thread 5: In ra cac so co gia tri tang dan
thread 6: In ra cac so co gia tri giam dan
thread 7: In ra cac chu cai Hoa tang dan
thread 8: In ra cac chu cai thuong giam dan
thread 9: In ra cac chu Hoa thanh thuong, thuong thanh Hoa
Vd: a87GoB1H4(+3F)
t1: GBHF
t2: ao
t3: 87143
t4:(+)
t5: 13478
t6: 87431
t7: BFGH
t8: oa
t9: gbhfAO

Trong do cho t1, t3, t5, t7, t9 thuoc Group Le, con lai la Group Chan
Set Prioroty group Le la 5, group chan la 6
*/
public class Run {
    public static void main(String[] args) {

        System.out.println("Nhap vao chuoi: ");
        Scanner sc = new Scanner(System.in);
        String chuoi = sc.nextLine();
        sc.close();

        ThreadGroup groupLe = new ThreadGroup("Group Le");
        groupLe.setMaxPriority(5);;
        ThreadGroup groupChan = new ThreadGroup("Group Chan");
        groupChan.setMaxPriority(6);

        new ChuoiHoa(groupLe, "ChuoiHoa", chuoi);
        new ChuoiThuong(groupChan, "ChuoiThuong", chuoi);
        new ChuoiSo(groupLe, "ChuoiSo", chuoi);
        new ChuoiKyTuDacBiet(groupChan, "ChuoiKyTuDacBiet", chuoi);
        new ChuoiSoTangDan(groupLe, "ChuoiSoTangDan", chuoi);
        new ChuoiSoGiamDan(groupLe, "ChuoiSoGiamDan", chuoi);
        new ChuoiHoaTangDan(groupLe, "ChuoiHoaTangDan", chuoi);
        new ChuoiThuongGiamDan(groupChan, "ChuoiThuongGiamDan", chuoi);
        new ChuoiHoanDoiHoaThuong(groupLe, "ChuoiHoanDoiHoaThuong", chuoi);


        // checking the number of active thread 
        System.out.println("number of active thread group groupLe: "
                           + groupLe.activeGroupCount()); 

        System.out.println("number of active thread group groupChan: "
        + groupChan.activeGroupCount()); 
    }
}

class ChuoiHoa extends Thread{
    String chuoi;

    public ChuoiHoa(ThreadGroup group, String name, String chuoi){
        super(group, name);
        this.chuoi = chuoi;
        start();
        this.setPriority(5);
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();

        for (Character c : chuoi.toCharArray()) {
            if(Character.isUpperCase(c)){
                sb.append(c);
            }

            try {
                int sleepTime = (int)(Math.random()*3000);
                System.out.println("Chuoi Hoa sleeping " + sleepTime + " milliseconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                System.out.println("Error: " + e.toString());
            }
        }

        System.out.println("Chuoi Hoa la: " + sb.toString());
    }
}


class ChuoiThuong extends Thread{
    String chuoi;

    public ChuoiThuong(ThreadGroup group, String name, String chuoi){
        super(group, name);
        this.chuoi = chuoi;
        start();
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();

        for (Character c : chuoi.toCharArray()) {
            if(Character.isLowerCase(c)){
                sb.append(c);
            }

            try {
                int sleepTime = (int)(Math.random()*3000);
                System.out.println("Chuoi Thuong sleeping " + sleepTime + " milliseconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                System.out.println("Error: " + e.toString());
            }
        }

        System.out.println("Chuoi Thuong la: " + sb.toString());
    }
}

class ChuoiSo extends Thread{
    String chuoi;

    public ChuoiSo(ThreadGroup group, String name, String chuoi){
        super(group, name);
        this.chuoi = chuoi;
        start();
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();

        for (Character c : chuoi.toCharArray()) {
            if(Character.isDigit(c)){
                sb.append(c);
            }

            try {
                int sleepTime = (int)(Math.random()*3000);
                System.out.println("Chuoi So sleeping " + sleepTime + " milliseconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                System.out.println("Error: " + e.toString());
            }
        }

        System.out.println("Chuoi So la: " + sb.toString());
    }
}

class ChuoiKyTuDacBiet extends Thread{
    String chuoi;

    public ChuoiKyTuDacBiet(ThreadGroup group, String name, String chuoi){
        super(group, name);
        this.chuoi = chuoi;
        start();
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();

        for (Character c : chuoi.toCharArray()) {
            if(!Character.isDigit(c) && !Character.isLowerCase(c) && !Character.isUpperCase(c)){
                sb.append(c);
            }

            try {
                int sleepTime = (int)(Math.random()*3000);
                System.out.println("Chuoi Ky Tu Dac Biet sleeping " + sleepTime + " milliseconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                System.out.println("Error: " + e.toString());
            }
        }

        System.out.println("Chuoi Ky Tu Dac Biet la: " + sb.toString());
    }
}


class ChuoiSoTangDan extends Thread{
    String chuoi;

    public ChuoiSoTangDan(ThreadGroup group, String name, String chuoi){
        super(group, name);
        this.chuoi = chuoi;
        start();
    }

    @Override
    public void run() {
        List<Integer> lstSo = new ArrayList<>();

        for (Character c : chuoi.toCharArray()) {
            if(Character.isDigit(c)){
                int soHienTai = Integer.parseInt(Character.toString(c));
                lstSo.add(soHienTai);
            }

            try {
                int sleepTime = (int)(Math.random()*3000);
                System.out.println("Chuoi So tang dan sleeping " + sleepTime + " milliseconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                System.out.println("Error: " + e.toString());
            }
        }

        Collections.sort(lstSo);

        System.out.println("Chuoi So tang dan: " + lstSo);
    }
}


class ChuoiSoGiamDan extends Thread{
    String chuoi;

    public ChuoiSoGiamDan(ThreadGroup group, String name, String chuoi){
        super(group, name);
        this.chuoi = chuoi;
        start();
    }

    @Override
    public void run() {
        List<Integer> lstSo = new ArrayList<>();

        for (Character c : chuoi.toCharArray()) {
            if(Character.isDigit(c)){
                int soHienTai = Integer.parseInt(Character.toString(c));
                lstSo.add(soHienTai);
            }

            try {
                int sleepTime = (int)(Math.random()*3000);
                System.out.println("Chuoi So giam dan sleeping " + sleepTime + " milliseconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                System.out.println("Error: " + e.toString());
            }
        }

        Collections.sort(lstSo, Collections.reverseOrder());

        System.out.println("Chuoi So giam dan: " + lstSo);
    }
}


class ChuoiHoaTangDan extends Thread{
    String chuoi;

    public ChuoiHoaTangDan(ThreadGroup group, String name, String chuoi){
        super(group, name);
        this.chuoi = chuoi;
        start();
        this.setPriority(5);
    }

    @Override
    public void run() {
        List<Character> lstHoa = new ArrayList<>();

        for (Character c : chuoi.toCharArray()) {
            if(Character.isUpperCase(c)){
                lstHoa.add(c);
            }

            try {
                int sleepTime = (int)(Math.random()*3000);
                System.out.println("Chuoi Hoa Tang Dan sleeping " + sleepTime + " milliseconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                System.out.println("Error: " + e.toString());
            }
        }

        Collections.sort(lstHoa);

        System.out.println("Ket qua Chuoi Hoa Tang Dan la: " + lstHoa);
    }
}

class ChuoiThuongGiamDan extends Thread{
    String chuoi;

    public ChuoiThuongGiamDan(ThreadGroup group, String name, String chuoi){
        super(group, name);
        this.chuoi = chuoi;
        start();
        this.setPriority(5);
    }

    @Override
    public void run() {
        List<Character> lstHoa = new ArrayList<>();

        for (Character c : chuoi.toCharArray()) {
            if(Character.isLowerCase(c)){
                lstHoa.add(c);
            }

            try {
                int sleepTime = (int)(Math.random()*3000);
                System.out.println("Chuoi Thuong Giam Dan sleeping " + sleepTime + " milliseconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                System.out.println("Error: " + e.toString());
            }
        }

        Collections.sort(lstHoa, Collections.reverseOrder());

        System.out.println("Ket qua Chuoi Thuong Giam Dan la: " + lstHoa);
    }
}

class ChuoiHoanDoiHoaThuong extends Thread{
    String chuoi;

    public ChuoiHoanDoiHoaThuong(ThreadGroup group, String name, String chuoi){
        super(group, name);
        this.chuoi = chuoi;
        start();
        this.setPriority(5);
    }

    @Override
    public void run() {
        StringBuilder sbHoa = new StringBuilder();
        StringBuilder sbThuong = new StringBuilder();

        for (Character c : chuoi.toCharArray()) {
            if(Character.isLowerCase(c)){
                sbHoa.append(Character.toUpperCase(c));
            }

            if(Character.isUpperCase(c)){
                sbThuong.append(Character.toLowerCase(c));
            }

            try {
                int sleepTime = (int)(Math.random()*3000);
                System.out.println("Chuoi Hoan Doi Hoa Thuong sleeping " + sleepTime + " milliseconds");
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                System.out.println("Error: " + e.toString());
            }
        }

        sbThuong.append(sbHoa.toString());

        System.out.println("Ket qua Chuoi Hoan Doi Hoa Thuong la: " + sbThuong.toString());
    }
}
