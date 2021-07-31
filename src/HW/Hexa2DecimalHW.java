package HW;

import java.util.Scanner;

public class Hexa2DecimalHW {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            int ans=Integer.valueOf(s.split("x")[1],16);
            System.out.println(ans);
        }
    }
}
