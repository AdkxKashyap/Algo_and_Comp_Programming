var divisorGame = function(N) {
    var memo=new Array(1001)
    return solve(N,memo)
};

var solve=function(N,memo=[]){
    if(N==1) return 0
    if(memo[N])return memo[N]
    for(let i=1;i<=N/2;i++){
        if(N%i==0){
            if(solve(N-1,memo)==0)return memo[N]=1
        }
    }
    memo[N]=0
    return 0

}
console.log(divisorGame())