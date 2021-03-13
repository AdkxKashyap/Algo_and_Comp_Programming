var permute = function (nums = []) {
  if (nums.length == 1) return [[nums[0]]];
  var ans=[]
  for (var i = 0; i < nums.length; i++) {
    var delItem = nums.shift();
    var tmpList = permute(nums);
   
    for (let list of tmpList) {
      list.push(delItem);
    }
    ans.push(...tmpList);
    nums.push(delItem);
  }
  return ans;
};

var test=[1,2,3]
// console.log(permute(test))
permute(test)