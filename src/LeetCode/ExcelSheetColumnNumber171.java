package LeetCode;

/*  171. Excel Sheet Column Number
*   https://leetcode-cn.com/problems/excel-sheet-column-number/
* */

public class ExcelSheetColumnNumber171 {
    public int titleToNumber(String columnTitle) {
        int ans=0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            ans+=Math.pow(26,columnTitle.length()-1-i)*(columnTitle.charAt(i)-'A'+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber171 excelSheetColumnNumber=new ExcelSheetColumnNumber171();
        System.out.println(excelSheetColumnNumber.titleToNumber("ZY"));
    }
}
