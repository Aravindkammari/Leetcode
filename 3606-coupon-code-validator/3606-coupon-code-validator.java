class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
        TreeMap<String, List<String>> map = new TreeMap<>();
        Set<String> set = Set.of(
            "electronics", "grocery", "pharmacy", "restaurant"
        );
        for(int i = 0; i < code.length; i++){
            String str = businessLine[i];
            if(code[i].equals("") || !isActive[i] || !set.contains(str))continue;
            String c = code[i];
            boolean state = true;
            for(int j = 0; j < c.length(); j++){
                if(!Character.isLetterOrDigit(c.charAt(j)) && c.charAt(j) != '_'){
                    state = false;
                    break;
                }
            }
            if(!state)continue;
            map.computeIfAbsent(businessLine[i], k -> new ArrayList<>()).add(code[i]);
        }
        for(String str : map.keySet()){
            List<String> list = map.get(str);
            if(list.size() > 1){
                Collections.sort(list);
            }
            for(int i = 0; i < list.size(); i++){
                ans.add(list.get(i));
            }
        }
        return ans;
    }
}