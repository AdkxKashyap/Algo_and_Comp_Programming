//check https://youtu.be/oBt53YbR9Kk?t=11313

function allConstruct(target,words,memo={}){
    var fArr=[]
    if(target in memo){
        return memo[target]
    }
    if(target=='') return [[]]
    for(let word of words){
        if(target.indexOf(word)==0){
            
            var newTarget=target.slice(word.length)
            // console.log(newTarget)
            var res=allConstruct(newTarget,words,memo)//returns empty arr if nothing is founnd
           
                // console.log(res)
                var resTarget=res.map(resArr=>{
                    // console.log(word)
                    return [word, ...resArr]
                })//if resTarget returns an empty arr map returns an empty arr
                // console.log(resTarget)
                fArr.push(...resTarget)
                
            
        }
    }
    memo[target]=fArr
    return fArr
//     if(fArr.length!=0){
//         memo[target]=fArr
//          return fArr
// }
    // memo[target]=null
    // return null

}

console.log(allConstruct('aaaaaaaaaaaaaaaaaaaaaaaaaaaz',['a','aa','aaa','aaaa','aaaaa','aaaaa','aaaaa']))