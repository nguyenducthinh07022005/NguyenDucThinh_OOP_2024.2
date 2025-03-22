//Nguyễn Đức Thịnh - 20235841
//Bài 2.2.6

import java.util.Scanner;

public class SolveEquation{
    public void Bac1_1An(double a, double b){
        if(a == 0 && b != 0){
            System.out.println("Phuong trinh vo nghiem");
        }
        else if (a == 0 && b == 0){
            System.out.println("Phuong trinh co vo so nghiem");
        }
        else{
            System.out.println("Phuong trinh co nghiem duy nhat: " + -b/a);
        }
    }

    public void Bac1_2An(double a11, double a12, double b1, double a21, double a22, double b2){
        double D = a11*a22 - a12*a21;
        double Dx = b1*a22 - b2*a12;
        double Dy = a11*b2 - a21*b1;        
        if(D != 0 ){
            System.out.println("x1 = " + Dx/D + ", " + "x2 = " + Dy/D);
            
        }
        else{
            if(Dx == 0 && Dy ==0){
                System.out.println("He phuong trinh có vo so nghiem");
            }
            else{
                System.out.println("He phuong trinh vo nghiem");
            }                
        }
    }

    public void Bac2_1An(double a, double b, double c){
        if(a == 0){
            Bac1_1An(b, c);
        }
        else{
            double delta  = b*b - 4*a*c;
            if(delta < 0){
                System.out.println("Phuong trinh vo nghiem");
            }
            else if(delta == 0){
                System.out.println("Phuong trinh co nghiem kep: x = " + -b/(2*a));
            }
            else{
                System.out.println("Phuong trinh co 2 nghiem phan biet: x1 = " + (-b + Math.sqrt(delta))/(2*a) + ", " + "x2 = " + (-b - Math.sqrt(delta))/(2*a));
            }
        }        
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhan 1 cho PT bac nhat 1 an\nNhan 2 cho PT bac nhat 2 an\nNhan 3 cho PT bac hai 1 an");
        int select = scan.nextInt();
        SolveEquation solve = new SolveEquation();
        switch(select){
            case 1:             
            System.out.println("a = ");
            double a = scan.nextDouble();
            System.out.println("b = ");
            double b = scan.nextDouble();
            solve.Bac1_1An(a, b);
            break;

            case 2:
            System.out.println("a11 = ");
            double a11 = scan.nextDouble();
            System.out.println("a12 = ");
            double a12 = scan.nextDouble();
            System.out.println("b1 = ");
            double b1 = scan.nextDouble();
            System.out.println("a21 = ");
            double a21 = scan.nextDouble();
            System.out.println("a22 = ");
            double a22 = scan.nextDouble();
            System.out.println("b2 = ");
            double b2 = scan.nextDouble();
            solve.Bac1_2An(a11, a12, b1, a21, a22, b2);
            break;

            case 3:
            System.out.println("a = ");
            double a_ = scan.nextDouble();
            System.out.println("b = ");
            double b_ = scan.nextDouble();
            System.out.println("c = ");
            double c_ = scan.nextDouble();
            solve.Bac2_1An(a_, b_, c_);
            break;
        }
        scan.close();
    }
}
