class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        MOD = 10**9 + 7
        f = [0]*n
        f[0]=1
        dayn_unshare=0
        for i,v in enumerate(f):
            if(i+delay>=n):
                dayn_unshare=dayn_unshare+v
            for j in range(i+delay,min(i+forget,n)):
                f[j]=(f[j]+v)%MOD   
        return (f[-1]+dayn_unshare) % MOD
