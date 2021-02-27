//D-ary indexed pq for dijaktras algo

module.exports = class PriorityQueue {
  constructor(degree) {
    this.queue = []; //this is the main pq
    this.deg = degree; //no. of child nodes
    this.nodeMap = new Map(); //nodeid:key
    this.inverseNodeMap = new Map(); //key:nodeId
    this.trackPQ = new Map(); //key:{val,position} ,managed by pq,only pos changes
  }

  add(node) {
    const weight = node.weight;

    const key = this.getKey();
    this.queue.push({ key, weight });
    const newNodeIndex = this.queue.length - 1;
    this.updateBimap(node.to, key);
    this.trackPQ.set(key, { weight, pos: newNodeIndex });

    const parent = this.getParent(this.queue.length - 1);
    // console.log(parent);
    this.shiftUp(parent, newNodeIndex);
  }
  //   delete() {
  //     const node = this.queue[0];
  //     this.queue[0] = this.queue.pop();
  //     this.shiftDown(0);
  //     return node;
  //   }

  getKey() {
    const key =
      this.nodeMap.size == 0 ? 0 : Array.from(this.nodeMap.values()).pop() + 1; //init unique key for each node id

    return key;
  }

  updateBimap(nodeId, key) {
    //Bidirectional Map so that we can get key from nodeid and vice versa
    this.nodeMap.set(nodeId, key);
    this.inverseNodeMap.set(key, nodeId);
  }

  poll() {
    //returns the node of highest priority
    //deletes the node from bi-map
    //del from queue

    const wt = this.queue[0].weight;
    const nodeId = this.inverseNodeMap.get(this.queue[0].key);
    this.deleteNode(nodeId, this.queue[0].key);

    if (this.getPQ().length == 1) {
      this.queue.pop();
      return {
        nodeId,
        wt,
      };
    }

    this.queue[0] = this.queue.pop();
    this.trackPQ.get(this.queue[0].key)["pos"] = 0;
    this.shiftDown(0);
    return {
      nodeId,
      wt,
    };
  }
  deleteNode(nodeId, key) {
    this.trackPQ.delete(key);
    //del from bi-map
    this.nodeMap.delete(nodeId);
    this.inverseNodeMap.delete(key);
  }
  shiftUp(parent, newNodeIndex) {
    if (parent >= 0) {
      //   console.log(parent);
      if (this.queue[parent].weight > this.queue[newNodeIndex].weight) {
        this.swap(parent, newNodeIndex);
        //update trackPQ
        this.trackPQ.get(this.queue[parent].key)["pos"] = parent;
        this.trackPQ.get(this.queue[newNodeIndex].key)["pos"] = newNodeIndex;
        this.shiftUp(this.getParent(parent), parent);
      }
    }
    return;
  }
  shiftDown(index) {
    var minIndex = index;

    for (let i = 1; i <= this.deg; i++) {
      const child = this.deg * index + i;
      if (
        child < this.queue.length &&
        this.queue[minIndex].weight > this.queue[child].weight
      ) {
        minIndex = child;
      }
    }

    if (!(minIndex == index)) {
      this.swap(minIndex, index);
      this.trackPQ.get(this.queue[minIndex].key)["pos"] = minIndex;
      this.trackPQ.get(this.queue[index].key)["pos"] = index;
      this.shiftDown(minIndex);
    }
  }

  decreaseWeight(nodeId, newWeight) {
    //decrease weight and adjust the heap
    const key = this.nodeMap.get(nodeId);
    const pos = this.trackPQ.get(key).pos;
    this.queue[pos].weight = newWeight;
    this.trackPQ.get(key)["weight"] = newWeight;
    const parent = this.getParent(pos);
    this.shiftUp(parent, pos);
  }
  hasNode(nodeId) {
    if (this.nodeMap.has(nodeId)) {
      return true;
    }
    return false;
  }
  swap(parent, newNodeIndex) {
    [this.queue[parent], this.queue[newNodeIndex]] = [
      this.queue[newNodeIndex],
      this.queue[parent],
    ];
  }

  getPQ() {
    return this.queue;
  }
  displayTrackPQ() {
    return this.trackPQ;
  }
  displayBiMap() {
    return [this.nodeMap, this.inverseNodeMap];
  }
  getParent(index) {
    return Math.floor((index - 1) / this.deg); //divided by no. of child nodes
  }
};

// function node(to, weight) {
//   this.to = to;
//   this.weight = weight;
// }

// node1 = new node("A", 50);
// node2 = new node("B", 12);
// node3 = new node("C", 11);
// node4 = new node("E", 20);
// node5 = new node("F", 35);

// var pq = new PriorityQueue(4);
// pq.add(node1);
// // console.log(pq.display())
// // console.log(pq.displayTrackPQ());
// pq.add(node2);
// // console.log(pq.display())
// // console.log(pq.displayTrackPQ());
// pq.add(node3);
// // console.log(pq.display())
// // console.log(pq.displayTrackPQ());
// pq.add(node4);
// pq.add(node5);

// pq.decreaseWeight('F',4)
// console.log(pq.displayPQ())
// console.log(pq.displayTrackPQ());
