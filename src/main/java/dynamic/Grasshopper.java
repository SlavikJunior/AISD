package dynamic;

public class Grasshopper {

    public static int grasshopper(int steps) {
        int[] nums = new int[steps + 1];

        nums[0] = 1;

        for (int i = 1; i <= steps; i++) {
            if ((i - 1) >= 0) {
                nums[i] += nums[i - 1];
            }

            if ((i - 2) >= 0) {
                nums[i] += nums[i - 2];
            }

            if ((i - 3) >= 0) {
                nums[i] += nums[i - 3];
            }
        }

        return nums[steps];
    }

    public static void main(String[] args) {
        System.out.println(grasshopper(8));
    }
}

