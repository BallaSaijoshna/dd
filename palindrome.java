import java.util.Scanner;
public class main{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
System.out.print("Enter a number:");
int num=sc.nextInt();
int original=num;
int reversed=0;
while(num>0){
int digit=num%10;
reversed=reversed*10+digits;
num/=10;
}
if(original==reversed){
System.out.println("is a palindrome number");
}else{
System.out.println("is a not a palindrome number");
}
}
}
