class Main{
public static void solveHanoi(int n, char source,char auxiliar,char destination){
if(n==1)
{
System.out.println("Move disk 1 from"+source+"to"+destination);
return;
}
solveHanoi(n-1,source,destination,auxiliary);
System.out.println("Move disk"+n+"from"+source+"to"+destination);
solveHanoi(n-1,auxiliary,source,destination);
}
public static void main(String[]args){
int num()
System.out.println("towers to Hano;solution for"+numdisks+"disks:");
solveHanoi(numDisks,'A','B','C');
}
}