#!/usr/bin/env python3

# Definition for a undirected graph node
class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        visit = set()
        if not node:
            return None

        primaryNode = UndirectedGraphNode(node.label)
        queue = [(node, primaryNode)]

        while len(queue) > 0:
            node1, node2 = queue.pop(0)
            visit.add(node1)

            for neighbor in node1.neighbors:
                newNeighbor = UndirectedGraphNode(neighbor.label)
                node2.neighbors.append(newNeighbor)
                if neighbor not in visit:
                    visit.add(neighbor)
                    queue.append((neighbor, newNeighbor))

        return primaryNode