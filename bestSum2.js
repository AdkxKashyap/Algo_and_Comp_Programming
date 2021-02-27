//using tabulation
const {performance}=require('perf_hooks') 

function bestSum(target,numbers){
    var table=new Array(target+1).fill(null)
    table[0]=[] //start case
    for(let i=0;i<=target;i++){
        if(table[i]){
            for(let num of numbers){
                if(i+num<=target){
                    const newArr=[...table[i],num]
                    if(table[i+num]){
                        if(table[i+num].length>newArr.length){
                            table[i+num]=newArr
                        }
                    }
                    else{
                        table[i+num]=newArr
                    }
                }
                
            }
        }
    }
    return table[target]
}
var t0=performance.now()
console.log(bestSum(100,[1,2,5,25]))
var t1=performance.now()
console.log(t1-t0)