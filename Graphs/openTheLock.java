// https://leetcode.com/problems/open-the-lock/description/?envType=daily-question&envId=2024-04-22

class Solution {
    public int openLock(String[] deadends, String target) {
        Set <String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        //Target won't be in deadends
        if(deadendSet.contains("0000")){
            return -1;
        }
        if(target.equals("0000")){
            return 0;
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>("0000", 0));
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while(!queue.isEmpty()){
            // Pair<String, Integer> pair = queue.poll();
            String currentCombination = queue.peek().getKey();
            int moves = queue.peek().getValue();
            queue.poll();

            if(currentCombination.equals(target)){
                return moves;
            }

            for(int i = 0; i < 4; i++){
                for(int forOrBackward : new int[]{-1, 1}){
                    int newDigit = (currentCombination.charAt(i) - '0' + forOrBackward + 10) % 10;
                    String newCombination = currentCombination.substring(0, i) + newDigit + currentCombination.substring(i+1);

                    if(!visited.contains(newCombination) && !deadendSet.contains(newCombination)){
                        visited.add(newCombination);
                        queue.offer(new Pair<>(newCombination, moves+1));
                    }
                }
            }
        }

        return -1;
    }
}
/*
BFS from every combination by moving it -1 or 1, on every digit. Check if it is already visited or cannot be visited
*/