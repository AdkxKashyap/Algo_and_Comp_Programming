const {performance}=require('perf_hooks') 

function bestSum(targetSum,numbers,memo={}){
    if(memo[targetSum]) return memo[targetSum]
    if(targetSum==0) return []
    if(targetSum<0) return null
    let tmpArr
    numbers.forEach(num => {
        let remainder=targetSum-num
        var remainderArr=bestSum(remainder,numbers,memo)
        if(remainderArr){
            if(tmpArr){
                tmpArr=tmpArr.length>remainderArr.length?[...remainderArr,num]:tmpArr
                memo[targetSum]=tmpArr
            }
            else{
                tmpArr=[...remainderArr,num]
                memo[targetSum]=tmpArr
            }
        }
    });
    if(tmpArr) return tmpArr
    else return null
} 
var t0=performance.now()
console.log(bestSum(100,[1,2,5,25]))
var t1=performance.now()
console.log(t1-t0)