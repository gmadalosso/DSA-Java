public class BinarySearch {

    public static int search(int[] arr, int target){

        int left = 0;
        int right = arr.length;

        while(right > left){
            int middle = Math.floorDiv((left + right), 2);
            int midValue = arr[middle];
    
            if(target == midValue){
                return middle;
            }
            else if(target > midValue){
                left = middle + 1;
            }
            else{
                right = middle;
            }
        }
        
        return -1;
    }
    
}
