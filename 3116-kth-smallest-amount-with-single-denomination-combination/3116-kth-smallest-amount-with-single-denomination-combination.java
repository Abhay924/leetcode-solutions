class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long lo=1,hi=(long)k*Arrays.stream(coins).min().getAsInt();
        while(lo<hi){
            long mid=lo+(hi-lo)/2;
            if(count(mid,coins)>=k) hi=mid;
            else lo=mid+1;
        }
        return lo;
    }

    long count(long x,int[] coins){
        int n=coins.length;
        long res=0;

        for(int mask=1;mask<(1<<n);mask++){
            long lcm=1;
            int bits=0;
            boolean valid=true;

            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    bits++;

                    long g=gcd(lcm,coins[i]);
                    lcm=lcm/g*coins[i];
                    if(lcm>x){
                        valid=false;
                        break;
                    }
                }
            }

            if(!valid) continue;
            long v=x/lcm;
            if((bits&1)==1) res+=v;
            else res-=v;
        }
        return res;
    }

    long gcd(long a,long b){
        while(b!=0){
            long t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna