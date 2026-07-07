class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            if (c != '0') {
                sb.append(c);
                sum += c - '0';
            }
        }
        return sb.length() == 0 ? 0 : Long.parseLong(sb.toString()) * sum;
    }
}