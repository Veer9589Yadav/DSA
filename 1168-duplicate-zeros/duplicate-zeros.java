class Solution {
    public void duplicateZeros(int[] arr) {
        int pz = 0;
        int li = arr.length -1;
        for(int i=0; i<= li-pz; i++){
            if(arr[i] == 0){
                //edge case 
                if(i == li-pz){
                    arr[li] = 0;
                    li -= 1;
                    break;
                }
                pz++;
            }
        }
        int newli = li - pz;
        for (int i = newli; i>=0; i-- ){
            if (arr[i] == 0){
                arr[i+pz] =0;
                pz--;
                arr[i+pz] =0;
            } else {
                arr[i+pz] = arr[i];
            }
        }
    }
}