class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int odd = 0;     
        int even = 1;     
        int prefixParity = 0;
        long result = 0;

        for (int num : arr) {
            prefixParity = (prefixParity + num) & 1;

            if (prefixParity == 0) {
                result += odd;  
                even++;
            } else {
                result += even;  
                odd++;
            }
            result %= MOD;
        }

        return (int) result;
    }
}