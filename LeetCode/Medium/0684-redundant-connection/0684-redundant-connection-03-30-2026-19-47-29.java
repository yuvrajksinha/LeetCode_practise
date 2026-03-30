class Solution {
    class UnionFind{
        private int[] rank;
        private int[] root;
        
        UnionFind(int size){
            rank = new int[size+1];
            root = new int[size+1];
            for(int i=1;i<size+1;i++){
                root[i]=i;
                rank[i]=1;
            }
        }

        public int find(int x){
            if(x==root[x]){
                return x;
            }
            return root[x]=find(root[x]);
        }

        public void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX!=rootY){
                if(rank[rootX]>rank[rootY]){
                    root[rootY]=rootX;
                } else if(rank[rootX]<rank[rootY]){
                    root[rootX]=rootY;
                } else {
                    root[rootY]=rootX;
                    rank[rootX]+=1;
                }
            }
        }

        public boolean connectivity(int x,int y){
            return find(x)==find(y);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        int[] result = new int[2];
        for(int[] edge:edges){
            if(uf.connectivity(edge[0],edge[1])){
                result=edge;
            }
            uf.union(edge[0],edge[1]);
        }
        return result;
    }
}