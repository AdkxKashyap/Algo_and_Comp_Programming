class lc96{
    public int numTrees(int n) {
        int dp[]=new int[n+1];//eg for n=3 0 to 3 traverse so 4 slots are required
        dp[0]=1;//base cases
        dp[1]=1;
        for(int node=2;node<=n;node++){
            int total=0;
            for(int root=1;root<=node;root++){
                total+=dp[root-1]*dp[node-root];//mult the combos
            }
            dp[node]=total;
        }
        return dp[n];
    }
}