class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_sum = nums[0]
        current_sum = 0
        
        for num in nums:
            # If current_sum is negative, reset it to 0 before adding num
            if current_sum < 0:
                current_sum = 0
            
            current_sum += num
            
            # Update max_sum if current_sum is greater
            if current_sum > max_sum:
                max_sum = current_sum
                
        return max_sum