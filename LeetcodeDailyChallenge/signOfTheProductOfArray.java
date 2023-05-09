package LeetcodeDailyChallenge;

class signOfTheProductArray {
    public int arraySign(int[] nums) {
        int neg_cnt = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                return 0;
            else if(nums[i] < 0)
                neg_cnt++;
        } 

        return (neg_cnt % 2 == 0)? 1 : -1;
    }
}