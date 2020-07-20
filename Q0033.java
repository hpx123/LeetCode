public class Q0033 {
    public static int search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        int key = 0;
        int middle = 0;
        if(nums.length == 1 ){
            if(nums[0] == target){
                return 0;
            }else {
                return -1;
            }
        }else if(nums.length == 0){
            return -1;
        }
        if(nums[end] < nums[0]) {
            while (begin <= end) {
                middle = begin + (end - begin) / 2;
                if (nums[middle] > nums[middle + 1]) {
                    key = middle + 1;
                    break;
                }
                if (nums[middle] < nums[middle - 1]) {
                    key = middle;
                    break;
                }
                if (nums[middle] > nums[0]) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            if(target == nums[key]){
                return key;
            }else if(target <= nums[nums.length - 1]){
                begin = key + 1;
                end = nums.length - 1;
            }else if(target >= nums[0]){
                begin = 0;
                end = key -1 ;
            }
        }
        System.out.println(key);
        System.out.println(begin + " " +end);
        while (begin <= end){
            middle = begin + (end - begin) / 2;
            if(nums[middle] > target){
                end = middle - 1;
            }else if(nums[middle] < target){
                begin = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 2));
    }
}
