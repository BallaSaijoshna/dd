class Solution {
       public static int reverse(int x) {
        // Check for too large of int

        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
        	return 0;
        }

        // Gets the number of digits in x 
        int numOfDigits =(int)Math.floor(Math.log10(Math.abs(x))) + 1;

        int result = 0;

        // Keeps track of the current digit
        int currentDigit = 0;
        
        while(numOfDigits > 0){
            currentDigit = x % 10;
            x /= 10;
            result += currentDigit * Math.pow(10, --numOfDigits);
        }

        // Check for too large of int
        if(result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE) {
        	return 0;
        }

        return result;
    }
}
