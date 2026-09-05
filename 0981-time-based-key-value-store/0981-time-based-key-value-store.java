class TimeMap {
    HashMap<String,ArrayList<Pair>> map;
    class Pair{
        String value;
        int timestamp;
        Pair(String value,int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }

    public TimeMap() {
        map=new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        ArrayList<Pair> list=map.get(key);
        int left=0;
        int right=list.size()-1;
        String answer="";
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid).timestamp <= timestamp){
                answer=list.get(mid).value;
                left=mid+1;

            }
            else{
                right=mid-1;
            }
        }
        return answer;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */