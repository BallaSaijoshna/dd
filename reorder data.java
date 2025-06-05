class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digilog = new ArrayList<>();
        List<String> letlog = new ArrayList<>();
        
        for(String str : logs){
            String[] charArray = str.split("\\s+");
            int len = charArray.length;
            String last = charArray[len-1];
            if(last.matches("[0-9]+")){
                digilog.add(str);
            }else{
                letlog.add(str);
            }
        }

        Collections.sort(letlog, (s1,s2) -> {
            String[] part1 = s1.split(" " , 2);
            String[] part2 = s2.split(" " , 2);

            int cmp = part1[1].compareTo(part2[1]);

            if(cmp == 0){
                return part1[0].compareTo(part2[0]);
            }
            
            return cmp;

        });

        for(String digi : digilog){
            letlog.add(digi);
        }

        String[] result = new String[letlog.size()];
        result = letlog.toArray(result);

        return result;

    }
}
