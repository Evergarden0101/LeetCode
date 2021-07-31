package HW;

import java.util.Scanner;

public class EmptyBottleHW {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n!=0){
            int ans=0;
            while(n>=3){
                int add=n/3;
                ans+=add;
                n=n-add*2;
            }
            if(n==2)    ans++;
            System.out.println(ans);
            n=sc.nextInt();
        }
    }
}
