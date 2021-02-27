//find minimal cost from source passing through all nodes back to source
//not tested
//https://www.youtube.com/watch?v=JE0JE8ce1V0
const MAX = Infinity;
const n = 4; //number of cities/nodes
const visitedAll = (1 << n) - 1;
//eg if starting pos S=0 mask=0001,currPos=S
function tsp(mask, currentPos, memo) {
  var dist = MAX;
  if (mask == visitedAll) {
    return dist[currentPos][0];
  }
  if (memo[mask][currentPos]) {
    return memo[mask][currentPos];
  }
  for (let city = 0; city < n; city++) {
    if (mask & (1 << city)) {
      continue;
    }
    var newDist = dist[currentPos][city] + tsp(mask ^ (1 << city), city, memo);
    if (newDist < dist) {
      dist = newDist;
    }
  }
  memo[mask][currentPos] = dist;
  return dist;
}

var main=function(){
    
}
