//https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1#
class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while(j < size && i <= j) {
            int diff = arr[j] - arr[i];
            if(diff == n) return true;
            else if(diff < n) j++;
            else i++;
        }
        return false;
    }
}