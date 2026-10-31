class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)-> Integer.compare(b[1],a[1])
        );
        int totalUnits=0;
        for(int i=0;i< boxTypes.length;i++){
            int boxes=boxTypes[i][0];
            int units=boxTypes[i][1];
            int take=Math.min(boxes,truckSize);
            totalUnits+=take*units;
            truckSize-=take;
            if(truckSize==0){
                break;
            } 
        }
        return totalUnits;
    }
}