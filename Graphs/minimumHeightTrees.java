// https://leetcode.com/problems/minimum-height-trees/description/?envType=daily-question&envId=2024-04-23


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);

        int[] degree = new int[n]; //to compute leaf nodes(degree = 1)
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge: edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            adjList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        Queue <Integer> leafNode = new LinkedList<>();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 1){ 
                leafNode.add(i);
            }
        }

        int remainingNodes = n; //can be 2 at max
        while(remainingNodes > 2){
            int size = leafNode.size();
            remainingNodes -= size; 
            for(int i = 0; i < size; i++){
                int leaf = leafNode.poll();
                for(int neighbor : adjList.get(leaf)){
                    if(--degree[neighbor] == 1){
                        leafNode.add(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(leafNode);
    }
}

/*
Intuition: Removing the leaf nodes knowing at max 2 nodes can be the answer. 
Since if it is three, the middle node will be the answer, etc

Removing degree = 1 nodes till we get last 2 or last node

*/