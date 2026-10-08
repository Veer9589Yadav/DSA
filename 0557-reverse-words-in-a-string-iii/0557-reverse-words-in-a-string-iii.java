class Solution {

    public void reverse(char[] arr, int st, int e){
        while(st < e){
            char temp = arr[st];
            arr[st] = arr[e];
            arr[e] = temp;
            st++;
            e--;
        }
    }

    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        int st = 0,
            e = 0;
        while(st < charArr.length){
            while(e < charArr.length && charArr[e] != ' '){
                e++;
            }
            reverse(charArr,st,e-1);
            st = e+1;
            e = e+1;
        }
        return new String(charArr);
    }
}