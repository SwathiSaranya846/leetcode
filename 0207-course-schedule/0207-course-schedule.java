class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        int[] outDegree=new int[numCourses];
        for(int i=0;i<n;i++){
            outDegree[prerequisites[i][1]]++;
        }
        int[][] graph=new int[numCourses][];
        for(int i=0;i<numCourses;i++){
            graph[i]=new int[outDegree[i]];
        }
        for(int i=0;i<numCourses;i++){
            outDegree[i]=0;
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<n;i++){
            int from=prerequisites[i][1];
            int to=prerequisites[i][0];
            graph[from][outDegree[from]++]=to;
            indegree[to]++;
        }
        int[] queue=new int[numCourses];
        int front=0,rear=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue[rear++]=i;
            }
        }
        int count=0;
        while(count<rear){
            int course=queue[front++];
            count++;
            for(int i=0;i<graph[course].length;i++){
                int next=graph[course][i];
                indegree[next]--;
                if(indegree[next]==0){
                    queue[rear++]=next;
                }
            }
        }
        return count==numCourses;
        
    }
} 