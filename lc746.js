/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function (cost) {
  var memo = new Array(1001);
  return min(findCost(cost, 0, memo), findCost(cost, 1, memo));
};

var findCost = function (cost = [], index, memo = []) {
  if (index >= cost.length) return 0;
  if (memo[index]) return memo[index];
  var lcost = cost[index] + findCost(cost, index + 1, memo);
  var rcost = cost[index] + findCost(cost, index + 2, memo);
  return memo[index]=min(lcost, rcost);
};

var min = function (lcost, rcost) {
  if (lcost < rcost) return lcost;

  return rcost;
};

var array=[0,3,1,0]
console.log(minCostClimbingStairs(array))

