class Solution {
    class UnionFind{
        private int[] rank,root;

        UnionFind(int size){
            rank = new int[size];
            root = new int[size];
            for(int i=0;i<size;i++){
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
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind(size);
        Map<String,Integer> emailGroups = new HashMap<>(); //get emails set according to index groups
        for(int i=0;i<size;i++){
            int accountSize = accounts.get(i).size(); 
            for(int j=1;j<accountSize;j++){ //skip name so j=1
                String email = accounts.get(i).get(j);
                if(!emailGroups.containsKey(email)){ //if email not in the group
                    emailGroups.put(email,i); //put that email with the index group
                } else { //if email already seen before then 
                    uf.union(i,emailGroups.get(email));//connect the index with the index group where the other email was found
                }
            }
        }
        //now emails have ids so jumble them up into groups according to those ids
        Map<Integer,List<String>> mainGroups = new HashMap<>(); 
        for(String email:emailGroups.keySet()){
            int group = emailGroups.get(email); //get the groupid
            int groupId = uf.find(group); //get the main representing group id(get the root node type) as we did union if two email list had that happen they get the same root now
            if(!mainGroups.containsKey(groupId)){
                mainGroups.put(groupId,new ArrayList<>());
            }
            mainGroups.get(groupId).add(email);
        }

        List<List<String>> mainList = new ArrayList<>(); //now for the main list to be formed
        for(int groupId:mainGroups.keySet()){ //for each group 
            List<String> accountEmails = mainGroups.get(groupId); //get all the emails
            Collections.sort(accountEmails); //sort them 
            accountEmails.add(0,accounts.get(groupId).get(0)); //add the name to the front
            mainList.add(accountEmails); //add it to the main list to be returned
        }
        
        return mainList;
    }
}