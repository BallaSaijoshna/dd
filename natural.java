class RecursionDemo{
static int sum(int n){
if(n==1)
return1;
}else{
return n+sumNaturalNumber(n-1);
}
}
public static void main(String[]args){
int number=10;
int result=sumNaturalNumbers(number);
System.out.println("sum of first"+number+"natural number is"+result);
}
}