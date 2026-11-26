class Solution {
    public boolean canAliceWin(int n) {
        int take = 10;
        boolean aliceTurn = true;
        while(take > 0 && n>= take){
            n -= take;
            take--;
            aliceTurn = !aliceTurn;
        }
        return !aliceTurn;
    }
}