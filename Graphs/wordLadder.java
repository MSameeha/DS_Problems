package Graphs;

import java.util.*;
//Given a dictionary D and two strings  s and t, write a program to determine if s 
//producces t. Assume all characters are lowercase alphabet. If s produces t, output 
//the length of a shortest production sequence; otherwise output -1.

public class wordLadder {

    int findShortestProductionSequence(String start, String target, HashSet<String> dictionary){
        if(start.equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            // System.out.println("Hey");
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if(curr.equals(target)) return level;
                // System.out.println("Hey yeah");

                char[] currString = curr.toCharArray();

                for(int j = 0; j < currString.length; j++){
                    char currCharacter = currString[j];
                    // System.out.println("Hey there " + curr);

                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(ch != currCharacter){
                            currString[j] = ch;
                            String newString = new String(currString);
                            // System.out.println("Hey world " + newString);

                            if(dictionary.contains(newString) && !visited.contains(newString)){
                                // System.out.println(newString);
                                queue.offer(newString);
                                visited.add(newString);
                            }
                        }
                    }
                    currString[j] = currCharacter;
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.nextLine();
        String target = sc.nextLine();

        // System.out.println("Enter the number of words in the dictionary - ");
        int len_of_dictionary = sc.nextInt();
        HashSet < String> dictionary = new HashSet<>();
        // System.out.println(len_of_dictionary);
        String s = sc.nextLine(); //new line
        for(int i = 0; i < len_of_dictionary; i++){
            s = sc.nextLine();
            dictionary.add(s);
            // System.out.println(" i value is  " + i);
        }

        wordLadder object = new wordLadder();
        System.out.println(object.findShortestProductionSequence(start, target, dictionary));
    }
}
