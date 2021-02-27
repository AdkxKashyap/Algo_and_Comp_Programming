
function floydWarshall(graph=[],v){
    // var memo=[...graph]
    //memo is used to store prev results 
    //next is used to store shortest path b/w two nodes.
    var {memo,next}=setup(graph,v)
    // console.log(v)

    for(let k=0;k<v;k++){
        for(let i=0;i<v;i++){
            if(k==i)continue;
            for(let j=0;j<v;j++){
        
                const newDist=memo[i][k]+memo[k][j]
                if(memo[i][j]>newDist){
                    memo[i][j]=newDist
                    next[i][j]=next[i][k]
                }
            }
        }
    }

    return{
        memo,
        next
    }
}

function setup(graph,v){
    var memo=[...graph]
    var next=[]
    for(let i=0;i<v;i++){
        var tmp=[]
        for(let j=0;j<v;j++){
            if(graph[i][j]!=Infinity){
                tmp.push(j)
            } 
            else{
                tmp.push(null)
            }    
        }
        next.push(tmp)
    }
    // console.log(next)
    return {
        memo,
        next
    }
}

function shortestPath(graph=[],start,end){
    const {memo,next}=floydWarshall(graph,graph.length)
    var path=[]
    if(next[start][end]==null){
        return null
    }
    path.push(start)
    while(start!=end){
        start=next[start][end]
        path.push(start)
    }
    
    return path

}

const graph=[
    [0,3,Infinity,7],
    [8,0,2,Infinity],
    [5,Infinity,0,1],
    [2,Infinity,Infinity,0]
]
const v=graph.length

const sPath=shortestPath(graph,0,2)
console.log(sPath)