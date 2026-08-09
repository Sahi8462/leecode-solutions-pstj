class Solution(object):
    def maximumWealth(self, accounts):
        """
        :type accounts: List[List[int]]
        :rtype: int
        """
        # Sum each row (customer wealth) and find the maximum
        return max(sum(customer) for customer in accounts)