package com.yihaoxing.demo.test.leetcode;

/**
 * <p></p>
 *
 * @author yihaoxing
 * @since 2022/9/18 14:44
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 7, 9, 6, 3, 4, 5, 10, 8, 6};
        //quickSort(nums, 0, nums.length - 1);

        quickSort2(nums, 0, nums.length - 1);
    }

    /**
     * 先以最左边的数值作为比较值.也就是把它当做轴pivot.此时pivot = nums[left]
     * 从右往左找,j--,当找到值小于pivot时,停止.再从左往右找,i++,当找到值大于pivot时,停止.此时交换nums[i]与nums[j]的值
     * 继续找,直到i=j,表示数组找完了,此时左边都是小于pivot的,右边都是大于pivot的,这时,把nums[i]的值和nums[left]的值互换.
     * 到此第一个轴的位置就确定好了.
     * 然后以第一个轴为中间点,将数组划分为两个数组,继续重复上述操作.这里就要用到递归.
     * 要注意,要有跳出递归的判断条件,即left>=right.当数组不停的拆分,拆分到最后只剩下1个元素时,此时left = right.跳出递归.
     */

    /**
     * 快排
     *
     * @param nums  用于排序的数组
     * @param left  左边界
     * @param right 右边界
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //轴的值
        int pivot = nums[left];

        int i = left;
        int j = right;


        while (i < j) {


            while (nums[j] >= pivot && i < j) {
                j--;
            }

            while (nums[i] <= pivot && i < j) {
                i++;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        //更换轴的位置
        nums[left] = nums[i];
        nums[i] = pivot;

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);

    }


    public static void quickSort2(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }


        int num = nums[left];

        int i = left;
        int j = right;

        while (i < j) {

            while (num <= nums[j] && i < j) {
                j--;
            }
            while (num >= nums[i] && i < j) {
                i++;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        nums[left] = nums[i];
        nums[i] = num;


        //[3,1,5,8,7] i=2

        //[3,1] 0,1
        //num=3
        //[1,3] 1,1
        quickSort2(nums, left, i - 1);

        //[8,7] 3,4
        //num = 8
        //[7,8] 4,4
        quickSort2(nums, i + 1, right);//代码最前边之所以判断left >= right 才返回,而不是left == right,就是以为这里设置的left=i+1,这个时候会出现left > right的情况.
    }
}
