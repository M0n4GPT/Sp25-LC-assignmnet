class Solution(object):
    def decodeString(self, s: str) -> str:
        """
        :type s: str
        :rtype: str
        """
        stack,res,times = [],"",0
        for c in s:
            if c=='[':
                stack.append([times,res])
                res, times = "",0
            elif c==']':
                cur_times,last_res = stack.pop()
                res = last_res + cur_times*res
            elif '0'<=c<='9':
                times = times*10+int(c)
            else:
                res +=c
        return res
        
