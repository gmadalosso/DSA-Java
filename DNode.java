public class DNode {
    private String data;
    private DNode prevNode;
    private DNode nextNode;

    public DNode(String data){
        this.data = data;
        this.prevNode = null;
        this.nextNode = null;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }

    public void setPrevNode(DNode prevNode){
        this.prevNode = prevNode;
    }

    public DNode getPrevNode(){
        return this.prevNode;
    }

    public void setNextNode(DNode nextNode){
        this.nextNode = nextNode;
    }

    public DNode getNextNode(){
        return this.nextNode;
    }
}
