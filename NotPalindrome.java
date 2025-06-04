import java.util.Scanner;
class Main
{
//Function to check if a string is not palindrome
public static int isnotPalindrome(String s)
{
int left=0;
int right=s.length()-1;
//Continue looping while the two pointers
//have not crossed
while(left<right)
{
//If the character at the current positions
//are not equal
if(s.charAt(left)!=s.charAt(right))
return 0;
//Move the left pointer to the left
//the right pointer to the left
left++;
right--;
}
//If np mismatch is found,return 1(Palindrome)
return 1;
}
public static void main(String[]args)
{
String s="abc";
System.out.println(isnotPalindrome(s));
}
}