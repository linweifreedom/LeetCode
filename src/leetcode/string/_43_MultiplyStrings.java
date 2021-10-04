package leetcode.string;

import java.util.LinkedList;
import java.util.Queue;

public class _43_MultiplyStrings {
	//use queues to store the multiplication of each digit from right hand side of nums2
    //add all numbers in the queue
    
    public String multiply(String num1, String num2) {
        Queue<String> q=new LinkedList<>();
        if(num1.charAt(0)=='0') return "0";
        if(num2.charAt(0)=='0') return "0";
        for(int i=num2.length()-1;i>=0;i--){
            int cur=num2.charAt(i)-'0';
            StringBuilder sb=new StringBuilder();
            int carry=0;
            for(int j=num1.length()-1;j>=0;j--){
                int num=num1.charAt(j)-'0';
                int mul=cur*num +carry;
                carry=mul/10;
                sb.append(mul%10);
            }
            if(carry!=0){
                sb.append(carry);
            }
            int c=num2.length()-i-1;
            sb.reverse();
            for(int k=1;k<=c;k++){
                sb.append('0');
            }
            q.add(sb.toString());
        }
        String first=q.poll();
        while(!q.isEmpty()){
            String s1=q.poll();
            first=add(first,s1);
        }
        return first;
    }
    String add(String s1,String s2){
        StringBuilder sb1=new StringBuilder(s1);
        StringBuilder sb2=new StringBuilder(s2);
        if(s1.length()>s2.length()){
            sb2.reverse();
            for(int i=1;i<=s1.length()-s2.length();i++){
                sb2.append('0');
            }
            sb2.reverse();
        }
        else if(s1.length()<s2.length()){
            sb1.reverse();
            for(int i=1;i<=s2.length()-s1.length();i++){
                sb1.append('0');
            }
            sb1.reverse();
        }
        
        s1=sb1.toString();
        s2=sb2.toString();
        int carry=0;
        StringBuilder res=new StringBuilder();
        for(int i=s1.length()-1;i>=0;i--){
            int one=s1.charAt(i)-'0';
            int two=s2.charAt(i)-'0';
            int sum=one+two+carry;
            carry=sum/10;
            res.append(sum%10);
        }
		if (carry != 0) {
			res.append(carry);
		}
        return res.reverse().toString();
    }
}
