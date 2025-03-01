//Nguyễn Đức Thịnh - 20235841
//Bài 6.33

import java.util.Scanner;

public class PrintStar{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap chieu cao cua tam giac: ");
        int height = scan.nextInt();
        for(int i = 0; i < height; i++){
            for(int j = 0; j < 2*height-1; j++){
                if(j >= height-1-i && j <= height-1+i){
                    System.out.print("*");
                }                
                else{
                    System.out.print(" ");
                }
            } 
            System.out.print("\n");           
        }
        scan.close();
    }
}