//eager implimentation using d-ary indexed heap
var PriorityQueue = require("./priorityQueue");
//shortest path from start to all other nodes
function dijakstraShortestPath(graph = new Map(), start, end) {
  var distMap = new Map();
  var visitedMap = new Map();
  var prevMap = new Map();

  graph.forEach((val, key) => {
    distMap.set(key, Infinity);
    visitedMap.set(key, false);
    prevMap.set(key, null);
  });
  distMap.set(start, 0);
  var pq = new PriorityQueue(4);
  pq.add(new Node(start, 0));
  while (pq.getPQ().length) {
    const nodeId = pq.poll().nodeId; //gets nodeid with min val
    visitedMap.set(nodeId, true);
    const edges = graph.get(nodeId);
    if (edges.length == 0) continue;
    for (let edge of edges) {
      if (visitedMap.get(edge.to)) {
        continue;
      }
      const newDistance = distMap.get(nodeId) + edge.cost;
      if (newDistance < distMap.get(edge.to)) {
        distMap.set(edge.to, newDistance);
        prevMap.set(edge.to, nodeId);
        if (pq.hasNode(edge.to)) {
          pq.decreaseWeight(edge.to, newDistance);
        } else {
          pq.add(new Node(edge.to, newDistance));
        }
      }
    }
  }
  return {
    prevMap,
    distMap,
  };
}

function getShortestPath(graph, start, end) {
  const res = dijakstraShortestPath(graph, start);
  const totalCost = res.distMap.get(end);
  var shortestPath = [];
  shortestPath.push(end);
  var prev = res.prevMap.get(end);
  while (prev) {
    shortestPath.unshift(prev);
    prev = res.prevMap.get(prev);
  }

  return {
    shortestPath,
    totalCost,
  };
}

function Node(to, weight) {
  this.to = to;
  this.weight = weight;
}
function Edge(to, cost) {
  this.to = to;
  this.cost = cost;
}

var graph = new Map();

graph.set("A", [new Edge("B", 5), new Edge("C", 8)]);
graph.set("B", [new Edge("C", 2), new Edge("D", 7)]);
graph.set("C", [new Edge("D", 3)]);
graph.set("D", []);

console.log(getShortestPath(graph, "A", "C"));
