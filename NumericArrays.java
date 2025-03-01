//Nguyễn Đức Thịnh - 20235841
//Bài 6.55

import java.util.Arrays;
import java.util.Scanner;

public class NumericArrays{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("So luong phan tu cua mang: ");
        int n = scan.nextInt();
        int[] arrays = new int[n];
        System.out.println("Nhap mang: ");
        for(int i = 0; i < n; i++){
            arrays[i] =  scan.nextInt();
        }
        System.out.println("Mang ban dau: " + Arrays.toString(arrays));
        Arrays.sort(arrays);
        System.out.println("Mang sau khi sap xep: " + Arrays.toString(arrays));
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arrays[i];
        }
        System.out.println("Tong cua mang: " + sum);

        double average = (double)sum/n;
        System.out.println("Trung binh cua mang: " + average);
        scan.close();
    }
}