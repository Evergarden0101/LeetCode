package HW;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DelNumHW {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            if(n>1000) n=999;
            else if(n==1){
                System.out.println(0);
                continue;
            }
            int count=n;
            int p=0;
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                if(i%3==2){
                    count--;
                    p=i;
                    continue;
                }
                ans.add(i);
            }
            if(p==0) p=1;
            p=(p+3)%n%ans.size();
            ans.remove(p);
            count--;
            while(count>1){
                p=(p+2)%ans.size();
                ans.remove(p);
                System.out.println(p);
                System.out.println(ans);
                count--;
            }
            System.out.println(ans.get(0));
        }
    }
}
