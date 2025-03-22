//Nguyễn Đức Thịnh - 20235841
//Bài 2.2.55


import java.util.Scanner;
public class Calculate{
    public double Tong(double num1, double num2){
        return num1 + num2;
    }

    public double Hieu(double num1, double num2){
        return num1 - num2;
    }

    public double Tich(double num1, double num2){
        return num1 * num2;
    }

    public double Thuong(double num1, double num2){
         return num1/num2;
    }
    public static void main(String args[]){
        double num1, num2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap so dau tien: ");
        num1 = Double.parseDouble(scan.nextLine());
        System.out.println("Nhap so thu hai: ");
        num2 = Double.parseDouble(scan.nextLine());
        Calculate cal = new Calculate();
        System.out.println("Tong = " + cal.Tong(num1, num2));
        System.out.println("Hieu = " + cal.Hieu(num1, num2));
        System.out.println("Tich = " + cal.Tich(num1, num2));
        if(num2 ==0){
            System.out.println("Khong the thuc hien phep chia cho 0");
        }
        else{
            System.out.println("Thuong = " + cal.Thuong(num1, num2));
        }
        scan.close();
    }
}

