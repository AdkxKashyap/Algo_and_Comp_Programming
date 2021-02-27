//Best Time to Buy and Sell Stock

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  const len = prices.length;
  var cpIndex = 0;
  var spIndex = cpIndex + 1;
  var profit = 0;
  while (cpIndex < len && spIndex < len) {
    if (prices[spIndex] - prices[cpIndex] < 0) {
      cpIndex = spIndex;
      spIndex = spIndex + 1;
    } else {
      let tmpProfit = prices[spIndex] - prices[cpIndex];
      profit = tmpProfit > profit ? tmpProfit : profit;
      spIndex+=1
    }
  }
  return profit;
};
console.log(maxProfit([7,1,5,3,6,4]))