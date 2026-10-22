class MapSum {

    private final Map<String, Integer> map = new HashMap<>();
    
    public void insert(String key, int val) {
        map.put(key,val);
    }
    
    public int sum(String prefix) {
        int total = 0;
        for(Map.Entry<String,Integer> e:map.entrySet()){
            if(e.getKey().startsWith(prefix)){
                total += e.getValue();
            }
        }
        return total;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */