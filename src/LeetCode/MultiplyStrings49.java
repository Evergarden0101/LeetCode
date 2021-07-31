package LeetCode;/*  43. Multiply Strings
    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
    Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    https://leetcode-cn.com/problems/multiply-strings/
 */

public class MultiplyStrings49 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))  return "0";
        int[] ans= new int[num1.length()+num2.length()];
        for(int i= num1.length()-1;i>=0;i--){
            int a=num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--){
                int b=num2.charAt(j)-'0';
                int res=a*b+ans[i+j+1];
                ans[i+j+1]=res%10;
                ans[i+j]+=res/10;
            }
        }
        StringBuffer s=new StringBuffer();
        for(int i=0;i<ans.length;i++){
            if(i==0&&ans[i]==0) continue;
            s.append(ans[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings49 multiplyStrings=new MultiplyStrings49();
        System.out.println(multiplyStrings.multiply("123","456"));
    }
}
