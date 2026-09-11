class MyHashSet {

    boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}

output:
Input
["MyHashSet","add","add","add","remove","contains","add","add","add","remove","contains","add","add","add","remove","contains","add","add","add","remove","contains"]
[[],[1],[10001],[1],[1],[1],[7],[10007],[7],[7],[7],[123],[10123],[123],[123],[123],[5000],[15000],[5000],[5000],[5000]]
Output
[null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false]
Expected
[null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false]
