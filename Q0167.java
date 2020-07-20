import java.util.Arrays;

/**
 * 在数组中找到两个数，使得它们的和等于目标值，可以首先固定第一个数，
 * 然后寻找第二个数，第二个数等于目标值减去第一个数的差。
 * 利用数组的有序性质，可以通过二分查找的方法寻找第二个数。
 * 为了避免重复寻找，在寻找第二个数时，
 * 只在第一个数的右侧寻找
 *
 */
public class Q0167 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = left + 1;
        int[] twoSum = new int[2];
        if(numbers.length == 0 || numbers.length == 1){
            if(numbers[0] == target) {
                twoSum[0] = 1;
            }
            return twoSum;
        }
        int sum = 0;
        while (left < right){
           if((numbers[left] + numbers[numbers.length - 1]) < target){
               left++;
               right = left + 1;
               continue;
           }
           sum = numbers[right] + numbers[left];
           if(sum < target){
               right++;
           }else if(sum > target){
               left++;
               right = left + 1;
               continue;
           } else {
                   twoSum[0] = left + 1;
                   twoSum[1] = right + 1;
                   break;
           }
        }
        return twoSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,24,50,79,88,150,345};
        int[] two = twoSum(nums, 200);
        System.out.println(Arrays.toString(two));
    }
}
