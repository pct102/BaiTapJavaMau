package Bai01;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        System.out.print(" Nhap vao 1 so: ");
        Scanner sc = new Scanner(System.in);
        int so = sc.nextInt();
        sc.close();

        MyThread t1 = new MyThread("Fibonaci", so);
        MyThread t2 = new MyThread("SoNguyenTo", so);
        MyThread t3 = new MyThread("GiaiThua", so);
        MyThread t4 = new MyThread("SoChinhPhuong", so);
        MyThread t5 = new MyThread("DoiCoSo", so);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    
}

class MyThread extends Thread{
    int n;
    String chuoi;
    public MyThread(String threadName, int n){
        this.setName(threadName);
        this.n = n;
    }

    public MyThread(String name, String chuoi){
        this.setName(name);
        this.chuoi = chuoi;

    }

    boolean CheckSoChinhPhuong(double x){
        double soCan = Math.sqrt(x);
        return ((soCan - Math.floor(soCan)) == 0);
    }

    boolean CheckSoNguyenTo(int x){
        if(x < 2){
            return false;
        }

        int soCan = (int)Math.sqrt(x);
        for (int i = 2; i <= soCan; i++) {
            if(x % i == 0){
                return false;
            }
        }

        return true;
    }

    long GiaiThua(int n){
        if(n > 0){
            return n*GiaiThua(n - 1);
        }
        else{
            return 1;
        }
    }

    long Fibonaci(int n){
        long f0 = 0;
        long f1 = 0; 
        long fn = 1;

        if(n < 0){
            return -1;
        }
        else if (n == 0 || n == 1){
            return n;
        }
        else{
            for(int i = 2; i < n; i++){
                f0 = f1;
                f1 = fn;
                fn = f0 + f1;
            }
        }

        return fn;
    }

    String DoiCoSo(int n, int b){
        if( n < 0 || b < 2 || b > 16){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int m;
        int reminder = n;

        while(reminder > 0){
            // He thap luc
            if( b > 10){
                m = reminder % b;
                if(m >= 10){
                    sb.append((char) (55 + m));
                }
                else{
                    sb.append(m);
                }
            }
            else{
                sb.append(reminder % b);
            }

            reminder = reminder / b;
        }

        return sb.reverse().toString();
    }

    @Override
    public void run() {
        String threadName = this.getName();

        switch (threadName) {
            case "Fibonaci":
                System.out.println("Luong " + threadName + " co ket qua la: " + Fibonaci(n));
                break;
            case "SoNguyenTo":
                System.out.println("Luong " + threadName + " co ket qua la: " + CheckSoNguyenTo(n));
                break;
            case "GiaiThua":
                System.out.println("Luong " + threadName + " co ket qua la: " + GiaiThua(n));
                break;
            case "SoChinhPhuong":
                System.out.println("Luong " + threadName + " co ket qua la: " + CheckSoChinhPhuong(n));
                break;
            case "DoiCoSo":
                System.out.println("Luong " + threadName + " voi co so 2 co ket qua la: " + DoiCoSo(n, 2));
                System.out.println("Luong " + threadName + " voi co so 16 co ket qua la: " + DoiCoSo(n, 16));
            
                break;
        
            default:
                break;
        }

    }
}