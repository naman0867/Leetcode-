class ExamRoom {
private final int n;
private final TreeSet<Integer> seats = new TreeSet<>();
    public ExamRoom(int n) {
        this.n = n;

    }
    
    public int seat() {
        if(seats.isEmpty()){
            seats.add(0);
             return 0;
        }
        int bestSeat = 0;
        int bestDist = seats.first();  // first occupied seat it is option 1
        Integer prev = null;
        for(int s:seats){
            if(prev != null){
                int d = (s-prev)/2;
                if(d>bestDist){
                    bestDist = d;
                    bestSeat = prev + d;
                }
            }
            prev = s;
        }
        // option 3 : last seats(n-1)
        if(n-1-seats.last()>bestDist){
            bestSeat = n-1;
        }
        seats.add(bestSeat);
        return bestSeat;
    }
    
    public void leave(int p) {
        seats.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */