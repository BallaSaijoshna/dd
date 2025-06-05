class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int mergedarr[] = new int[n1+n2];

        int i=0,j=0,k=0;

        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                mergedarr[k++] = nums1[i++];
            }
            else{
                mergedarr[k++] = nums2[j++];
            }

        }

        while(i<n1){
            mergedarr[k++] = nums1[i++];
        }

        while(j<n2){
            mergedarr[k++] = nums2[j++];
        }

        if(mergedarr.length%2!=0){
            return mergedarr[mergedarr.length/2];
        }

        return((double)(mergedarr[(mergedarr.length/2)-1] + mergedarr[(mergedarr.length/2)])/2);

    }
}
