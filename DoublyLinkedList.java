public class DoublyLinkedList {
    private DNode headNode;
    private DNode tailNode;

    public DoublyLinkedList(){
        this.headNode = null;
        this.tailNode = null;
    }

    public DNode getHeadNode(){
        return this.headNode;
    }

    public DNode getTailNode(){
        return this.tailNode;
    }

    public void addToHead(String data){
        DNode newHead = new DNode(data);
        DNode oldHead = this.headNode;

        if(oldHead == null){
            this.headNode = newHead;
            this.tailNode = newHead;
        }
        else{
            oldHead.setPrevNode(newHead);
            newHead.setPrevNode(null);
            newHead.setNextNode(oldHead);
            this.headNode = newHead;
        }
    }

    public void addToTail(String data){
        DNode newTail = new DNode(data);
        DNode oldTail = this.tailNode;

        if(oldTail == null){
            this.headNode = oldTail;
            this.tailNode = oldTail;
        }
        else{
            oldTail.setNextNode(newTail);
            newTail.setPrevNode(oldTail);
            newTail.setNextNode(null);
            this.tailNode = newTail;
        }
    }

    public void addToPosition(int position, String data){
        if(this.getSize() < position || position == 0){
            System.out.println("Invalid position.");
            return;
        }

        if(position == 1){
            this.addToHead(data);
            return;
        }

        if(position == this.getSize()){
            this.addToTail(data);
            return;
        }
        
        DNode newNode = new DNode(data);
        DNode currentNode = this.headNode;
        int count = 1;

        while(count != position){
            currentNode = currentNode.getNextNode();
            count++;
        }

        newNode.setNextNode(currentNode);
        newNode.setPrevNode(currentNode.getPrevNode());
        currentNode.getPrevNode().setNextNode(newNode);
        currentNode.setPrevNode(newNode);

    };

    public void removeHead(){
        if(this.headNode == null){
            return;
        }

        if(this.getSize() == 1){
            this.headNode = null;
            this.tailNode = null;
            return;
        }

        this.headNode.getNextNode().setPrevNode(null);
        this.headNode = this.headNode.getNextNode();
    }

    public void removeTail(){
        if(this.tailNode == null){
            return;
        }

        if(this.getSize() == 1){
            this.headNode = null;
            this.tailNode = null;
            return;
        }

        this.tailNode.getPrevNode().setNextNode(null);
        this.tailNode = this.tailNode.getPrevNode();
    }

    public void removeIndex(int index){
        if(index == 0){
            this.removeHead();
            return;
        }

        if(index == this.getSize() - 1){
            this.removeTail();
            return;
        }

        if(index > this.getSize() || index < 0){
            System.out.println("Invalid index.");
            return;
        }
    
        DNode currentNode = this.headNode;
        int count = 0;

        while(count != index && currentNode != null){
            currentNode = currentNode.getNextNode();
            count++;
        }

        currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
        currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
    }

    public int getSize(){
            DNode currentNode = this.headNode;
            int count = 0;

            while(currentNode!= null){
                count++;
                currentNode = currentNode.getNextNode();
            }

            return count;
    }

    public int indexOf(String data){
        DNode searchNode = this.headNode;
        int count = 0;

        while(searchNode != null){ 
            if(searchNode.getData() == data)
            {
                return count;
            }
            searchNode = searchNode.getNextNode();
            count++; 
        }

        if(count >= this.getSize()){
            return -1;
        }

        return count;
    }


    public void printList(){
        if(this.headNode == null){
            System.out.println("<empty>");
        }
        else{
            System.out.println("<head>");
            DNode currentNode = this.headNode;
            while(currentNode != null){
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
            System.out.println("<tail>");
        }
    }

}
