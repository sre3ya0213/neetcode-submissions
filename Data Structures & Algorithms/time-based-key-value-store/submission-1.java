class TimeMap {

    class Emotion {
            String value;
            int time;
            public Emotion(String value,int time) {
                this.value = value;
                this.time = time;
            }
        }
    private Map<String,List<Emotion>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();   
    }
    
    public void set(String key, String value, int timestamp) {
        List<Emotion> emotion = timeMap.getOrDefault(key,new ArrayList<>());
        emotion.add(new Emotion(value,timestamp));
        timeMap.put(key,emotion);
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }
        List<Emotion> emotion = timeMap.get(key);
        int l=0;
        int r=emotion.size()-1;
        String value = "";
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(emotion.get(mid).time > timestamp) {
                r = mid-1;
            }
            else {
                value = emotion.get(mid).value;
                l = mid+1;
            }    
        }

        return value;
        
    }
}
