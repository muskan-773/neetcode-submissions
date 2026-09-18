class Solution {
public:

    bool dfs(int node, vector<vector<int>>& adj,
             vector<int>& vis, vector<int>& pathVis) {

        vis[node] = 1;
        pathVis[node] = 1;

        for (auto it : adj[node]) {

            // If node is not visited
            if (!vis[it]) {

                if (dfs(it, adj, vis, pathVis)) {
                    return true;
                }
            }

            // Cycle detected
            else if (pathVis[it]) {
                return true;
            }
        }

        // Remove node from current DFS path
        pathVis[node] = 0;

        return false;
    }

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {

        // Create adjacency list
        vector<vector<int>> adj(numCourses);

        for (auto edge : prerequisites) {

            int course = edge[0];
            int prerequisite = edge[1];

            // prerequisite → course
            adj[prerequisite].push_back(course);
        }

        vector<int> vis(numCourses, 0);
        vector<int> pathVis(numCourses, 0);

        // DFS for every course
        for (int i = 0; i < numCourses; i++) {

            if (!vis[i]) {

                if (dfs(i, adj, vis, pathVis)) {
                    return false;
                }
            }
        }

        return true;
    }
};