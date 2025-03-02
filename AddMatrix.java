//Nguyễn Đức Thịnh - 20235841
//Bài 6.6

import java.util.Scanner;

public class AddMatrix{
    public static void main(String args[]){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap kich thuoc ma tran");
        int rows = scan.nextInt();
        int columns = scan.nextInt();
        int[][] matA = new int[rows][columns];
        int[][] matB = new int[rows][columns];
        int[][] matSum = new int[rows][columns];


        System.out.println("MatA: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matA[i][j] = scan.nextInt();
            }
        }

        System.out.println("MatB: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j< columns; j++){
                matB[i][j] = scan.nextInt();
            }
        }

        System.out.println("MatSum = MatA + MatB =  ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j< columns; j++){
                matSum[i][j] = matA[i][j] + matB[i][j];
                System.out.print(matSum[i][j] + " ");
            }
            System.out.print("\n");
        }
        scan.close();
    }
}
