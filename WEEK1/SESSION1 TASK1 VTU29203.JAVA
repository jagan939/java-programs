import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface PerformOperation{
    boolean check(int a);
}

public class Solution{
    public static PerformOperation isOdd(){
        return new PerformOperation(){
            public boolean check(int n){
                return n%2!=0;
            }
        };
    }
    public static PerformOperation isPrime(){
        return new PerformOperation(){
            public boolean check(int n){
                if(n<2)return false;
                for(int i=2;i*i<=n;i++){
                    if(n%i==0)return false;
                }
                return true;
            }
        };
    }
    public static PerformOperation isPalindrome(){
        return new PerformOperation(){
            public boolean check(int n){
                int original=n;
                int reverse=0;
                while(n>0){
                    reverse=reverse*10+n%10;
                    n=n/10;
                }
                return original==reverse;
            }
        };
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int condition=sc.nextInt();
            int number=sc.nextInt();
            if(condition==1){
                if(isOdd().check(number))
                    System.out.println("ODD");
                else
                    System.out.println("EVEN");
            }
            else if(condition==2){
                if(isPrime().check(number))
                    System.out.println("PRIME");
                else
                    System.out.println("COMPOSITE");
            }
            else{
                if(isPalindrome().check(number))
                    System.out.println("PALINDROME");
                else
                    System.out.println("NOT PALINDROME");
            }
        }
        sc.close();
    }
}
OUTPUT:
Input (stdin)
5
1 4
2 5
3 898
1 3
2 12
Your Output (stdout)
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
Expected Output
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
