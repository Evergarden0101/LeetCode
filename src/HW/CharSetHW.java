package HW;

import java.util.*;

public class CharSetHW {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String in = sc.nextLine();
            HashMap<Character,Integer> hm=new HashMap<>();
            List<Character> list=new ArrayList<>();
            for(int i=0;i<in.length();i++){
                if(!list.contains(in.charAt(i))){
                    list.add(in.charAt(i));
                }
            }
            for(Character i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
