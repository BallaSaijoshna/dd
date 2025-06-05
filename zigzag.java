class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        char [][] arr = new char[numRows][s.length()];
        int charCount = 0;

        int currentRow = 0;
        int currentCol = 0;

        int charIndex = 0;

        boolean goingDown = true;
        if(numRows == 1){
            return s;
        }

        while(charIndex < s.length()){
            arr[currentRow][currentCol] = s.charAt(charIndex++);
            if(currentRow == 0){
                goingDown = true;
            }
            else if(currentRow == numRows - 1) {
                goingDown = false;
            }

            if(goingDown){
                currentRow++;
            }
            else{
                currentRow--;
                currentCol++;
            }
        }
        

        for(int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (arr[i][j] != 0) {
                    sb.append(arr[i][j]);
                    charCount++;
                    if(charCount == s.length()){
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
