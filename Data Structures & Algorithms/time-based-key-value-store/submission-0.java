class TimeMap {
    class Pair {
        int timeStamp;
        String value;
        public Pair(int timeStamp,String value) {
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }
    private Map<String,List<Pair>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> ls = store.getOrDefault(key,new ArrayList<>());
        ls.add(new Pair(timestamp,value));
        store.put(key,ls);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> ls = store.get(key);
        if(ls == null) {
            return "";
        }
        int l=0;
        int r = ls.size()-1;
        int mid=0;
        int k=-1;
        while(l<=r) {
            mid = l + (r-l)/2;
            if(ls.get(mid).timeStamp == timestamp) {
                return ls.get(mid).value;
            }
            if(ls.get(mid).timeStamp < timestamp) {
                k=mid;
                l=mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return k >= 0 ? ls.get(k).value : "";   
    }
}
