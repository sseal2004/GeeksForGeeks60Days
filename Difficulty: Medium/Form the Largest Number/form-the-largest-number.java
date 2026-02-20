class Solution {
    public String findLargest(int[] arr) {

        //Covert array into String array
        String [] strArr = new String[arr.length];
        for(int i = 0;i<arr.length;i++){
            strArr[i] = String.valueOf(arr[i]);
        }
        
        //Custom sort 
        Arrays.sort(strArr,(a,b)->(b+a).compareTo(a+b));
        
        //check whether first string is 0 or not.
        if(strArr[0].equals("0")){
            return "0";
        }
        
        //Concatenation 
        StringBuilder result = new StringBuilder();
        for(String s:strArr){
            result.append(s);
        }
        
        return result.toString();
    }
}