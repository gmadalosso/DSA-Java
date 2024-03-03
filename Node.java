public class Node {
    private String data;
    private Node nextNode;

    public Node(String data){
        this.data = data;
        this.nextNode = null;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }

    public void setNextNode(Node next){
        this.nextNode = next;
    }

    public Node getNextNode(){
        return this.nextNode;
    }

}
