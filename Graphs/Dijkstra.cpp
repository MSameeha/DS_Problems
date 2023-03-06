#include <bits/stdc++.h>
using namespace std;

void dijkstra(vector<pair<int, int>> graph[], int numberOfNodes, int numberOfEdges, int source){
    priority_queue < pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>> > pq;
    vector <int> distTo(numberOfNodes+1, INT_MAX);

    distTo[source] = 0;
    pq.push(make_pair(0, source));

    while(!pq.empty()){
        int dist = pq.top().first; 
        int prev = pq.top().second;

        pq.pop();

        vector <pair <int, int> > :: iterator it;
        for(it = graph[prev].begin(); it != graph[prev].end(); it++){
            int next = it->first;
            int nextDist = it->second;
            // cout << prev << " " << next << " " << nextDist << " " << distTo[next] << "\n";
            if(distTo[next] > dist + nextDist){
                distTo[next] = dist + nextDist;
                // cout << distTo[next] << " " << next << " " << "\n";
                pq.push(make_pair(distTo[next], next));
            }
        }
    }

    for(int i = 1; i <= numberOfNodes; i++) cout << distTo[i] << " ";
    cout << "\n";

}

int main(){
    int numberOfEdges, numberOfNodes;
    cin >> numberOfNodes >> numberOfEdges; 

    vector <pair <int, int> > graph[numberOfNodes + 1];

    for(int i = 0; i < numberOfEdges; i++){
        int a, b, weight;
        cin >> a >> b >> weight;
        graph[a].push_back(make_pair(b, weight));
        graph[b].push_back(make_pair(a, weight));
    }

    dijkstra(graph, numberOfNodes, numberOfEdges, 1);
}