class RecursionDemo{
static boolean isPalindrome(string s,int start,int end){
if(start>=end){
return true;
}
if(s.charAt(start)!=s.char(end)){
return false;
}
return isPalindrome(s,start+1,end-1);
public static void main(String[]args){
String s="madam";
if(isPalindrome(s,0,s.length()-1))
{
System.out.println(s+"is notPalindrome");
}
}
}