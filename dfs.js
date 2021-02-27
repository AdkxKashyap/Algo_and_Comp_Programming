
function dfs(start,visited=new Set()){
    visited.add(start)
    console.log(start)
    const neighbours=testMap.get(start)
    for(const neighbour of neighbours){
        if(neighbour=='C'){
            return true
        }
        if(!visited.has(neighbour)){
            dfs(neighbour,visited)
        }
    }
    return true;
}

const testMap=new Map([['A',['B']],
['B',['A','C','D']],
['C',['B']],
['D',['B']]])

dfs('A')
console.log(testMap)