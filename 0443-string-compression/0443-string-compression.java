class Solution {
    public int compress(char[] chars) {
        int readIndex = 0;
        int writeIndex = 0;

        while (readIndex < chars.length){
            char currentChar = chars[readIndex];
            int count = 0;

            //count duplicate character ko
            while(readIndex < chars.length && currentChar == chars[readIndex]){
                readIndex++;
                count++;
            }

            //ab mere paas current character and uska count doo available hai
            chars[writeIndex] = currentChar;
            writeIndex++;

            //now insert the count
            if(count > 1){
                String countStr = String.valueOf(count);
                for(char digit : countStr.toCharArray()){
                    chars[writeIndex] = digit;
                    writeIndex++; 
                }
            }
        }
        //return the length of compressed string
        return writeIndex;
    }
}