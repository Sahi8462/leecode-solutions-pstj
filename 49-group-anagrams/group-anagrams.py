from collections import defaultdict

class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        anagram_map = defaultdict(list)
        
        for s in strs:
            # Sort characters in the string to use as the hash key
            sorted_key = "".join(sorted(s))
            anagram_map[sorted_key].append(s)
            
        return list(anagram_map.values())