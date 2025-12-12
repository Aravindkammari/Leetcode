class Solution {
    public int[] countMentions(int n, List<List<String>> events) {
        int[] online = new int[n];
        int[] mentions = new int[n];
        TreeMap<Integer, List<List<String>>> map = new TreeMap<>();
        for(int i = 0; i < events.size(); i++){
            int timeStamp = Integer.parseInt(events.get(i).get(1));
            map.computeIfAbsent(timeStamp, k -> new ArrayList<>()).add(events.get(i));
        }
        for(int i : map.keySet()){
            List<List<String>> event = map.get(i);
            for(int k = 0; k < event.size(); k++){
                if(event.get(k).get(0).equals("OFFLINE")){
                    int id = Integer.parseInt(event.get(k).get(2));
                    int timeStamp = Integer.parseInt(event.get(k).get(1));
                    online[id] = timeStamp + 60;
                }
            }
            for(int k = 0; k < event.size(); k++){
                if(event.get(k).get(0).equals("MESSAGE")){
                    if(event.get(k).get(2).equals("ALL")){
                        for(int j = 0; j < n; j++){
                            mentions[j]++;
                        }
                    }else if(event.get(k).get(2).equals("HERE")){
                        int timeStamp = Integer.parseInt(event.get(k).get(1));
                        for(int j = 0; j < n; j++){
                            if(online[j] <= timeStamp){
                                online[j] = 0;
                            }
                            if(online[j] == 0){
                                mentions[j]++;
                            }
                        }
                    }else{
                        String[] ids = event.get(k).get(2).split(" ");
                        for(int j = 0; j < ids.length; j++){
                            int id = Integer.parseInt(ids[j].substring(2, ids[j].length()));
                            mentions[id]++;
                        }
                    }
                }
            }
        }
        return mentions;
    }
}