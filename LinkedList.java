public class LinkedList {
    private Node headNode;

    //Class constructor
    public LinkedList(){
        this.headNode = null;
    }

    //headNode setter and getter
    public void setHeadNode(Node newHead){
        this.headNode = newHead;
    }

    public Node getHeadNode(){
        return this.headNode;
    }


    //INSERT methods for the Linked List
    public void addToHead(String data){
        Node newHead = new Node(data);
        Node currentHead = this.getHeadNode();
        this.setHeadNode(newHead);
        this.headNode.setNextNode(currentHead);
    }

    public void addToTail(String data){
        if(this.headNode == null){
            this.addToHead(data);
            return;
        }

        Node newTail = new Node(data);

        Node currentNode = this.headNode;

        while(currentNode.getNextNode() != null){
            currentNode = currentNode.getNextNode();
        }
        
        currentNode.setNextNode(newTail);
    }

    public void addAfter(Node positionNode, String data){
        if(positionNode.getNextNode() == null){
            this.addToTail(data);
        }
        else{
            Node insertNode = new Node(data);
            insertNode.setNextNode(positionNode.getNextNode());
            positionNode.setNextNode(insertNode);
        }
    }

    public void addBefore(Node positionNode, String data){
        if(positionNode == this.headNode){
            this.addToHead(data);
        }
        else{
            //find previous node of position node
            Node prevNode = this.headNode;
            while(prevNode.getNextNode() != positionNode && prevNode.getNextNode() != null){

                prevNode = prevNode.getNextNode();
            }
            Node insertNode = new Node(data);
            prevNode.setNextNode(insertNode);
            insertNode.setNextNode(positionNode);
        }
    }

    public void addToPosition(int position, String data){
        if(position == 0){
            this.addToHead(data);
        }

        Node countNode = this.headNode;
        for(int i = 1; i < position; i++){

            if(countNode == null){
                System.out.println("Position couldn't be reached.");
                return;
            }

            countNode = countNode.getNextNode();
        }

        this.addBefore(countNode, data);
    }

    public Node getNodeFromPosition(int position){
        Node searchNode = this.headNode;
        
        for(int i = 1; i < position; i++)
        {
            if(searchNode == null){
                System.out.println("Position couldn't be reached.");
                return null;
            }

            searchNode = searchNode.getNextNode();
        }

        return searchNode;
    }

    //REMOVE methods
    public void removeHead(){
        if(this.headNode == null)
        {
            System.out.println("The list is empty!");
        }
        else{
            this.setHeadNode(this.headNode.getNextNode());
        }
    }

    public void removeTail(){
        if(this.headNode == null)
        {
            System.out.println("The list is empty!");
        }
        else{
            int length = this.getSize();

            if(length == 1){
                this.headNode = null;
                return;
            }

            Node prevNode = this.getNodeFromPosition(length-1);
            prevNode.setNextNode(null);
        }
    }

    public void removeNodeFromPosition(int position){
        if(position == 1){
            this.removeHead();
            return;
        }

        if(position == this.getSize()){
            this.removeTail();
            return;
        }

        if(position > this.getSize() || position <= 0)
        {
            System.out.println("Position cannot be reached.");
            return;
        }

        Node prevNode = this.getNodeFromPosition(position-1);
        Node removeNode = this.getNodeFromPosition(position);

        prevNode.setNextNode(removeNode.getNextNode());

    }

    //SEARCH node method
    public Node searchNode(String data){
        Node searchNode = this.headNode;
        while(searchNode != null){
            if(searchNode.getData() == data){
                return searchNode;
            }
            searchNode = searchNode.getNextNode();
        }
        return null;
    } 

    //SIZE of the List
    public int getSize(){
        Node countNode = this.headNode;
        int count = 0;

        while(countNode != null){
            countNode = countNode.getNextNode();
            count++;
        }

        return count;
    }

    //PRINT method
    public void printList(){      
        if(this.headNode == null){
            System.out.println("<empty>");
        }

        System.out.println("<head>");

        Node currentNode = this.headNode;

        while(currentNode != null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
        System.out.println("<tail>");
    }

    public Node findPrevNode(String data){
      
        if(this.headNode.getData() == data){
            return null;
        }

        Node prevNode = null;
        Node searchNode = this.headNode;

        while(searchNode != null){
            if(searchNode.getData() == data){
                break;
            }
            prevNode = searchNode;
            searchNode = searchNode.getNextNode();
        }

        return prevNode;
    }

    public void swapNodes(String dataA, String dataB){
        Node prevNodeA = this.findPrevNode(dataA);
        Node prevNodeB = this.findPrevNode(dataB);

        if(prevNodeA == prevNodeB){
            return;
        }

        if(prevNodeA == null || prevNodeB == null){
            if(prevNodeA == null)
            {
                Node nodeA = this.headNode;
                Node nodeB = prevNodeB.getNextNode();
                Node aux = nodeA.getNextNode();

                if(prevNodeB == this.headNode){
                    prevNodeB.setNextNode(nodeA);
                    nodeA.setNextNode(nodeB.getNextNode());
                    nodeB.setNextNode(nodeA);
                    this.headNode = nodeB;
                }
                else
                {
                    prevNodeB.setNextNode(nodeA);
                    nodeA.setNextNode(nodeB.getNextNode());
                    nodeB.setNextNode(aux);
                    this.headNode = nodeB;
                }
            }

            if(prevNodeB == null)
            {
                Node nodeB = this.headNode;
                Node nodeA = prevNodeA.getNextNode();
                Node aux = nodeB.getNextNode();

                if(prevNodeA == this.headNode){
                    prevNodeA.setNextNode(nodeB);
                    nodeB.setNextNode(nodeA.getNextNode());
                    nodeA.setNextNode(nodeB);
                    this.headNode = nodeA;
                }
                else
                {
                    prevNodeA.setNextNode(nodeB);
                    nodeB.setNextNode(nodeA.getNextNode());
                    nodeA.setNextNode(aux);
                    this.headNode = nodeA;
                }
            }
        }
        else{
            Node nodeA = prevNodeA.getNextNode();
            Node nodeB = prevNodeB.getNextNode();
            Node aux = nodeA.getNextNode();

            if(prevNodeB == prevNodeA.getNextNode()){
                prevNodeA.setNextNode(nodeB);
                prevNodeB.setNextNode(nodeA);
                nodeA.setNextNode(nodeB.getNextNode());
                nodeB.setNextNode(nodeA);

            }
            else{
                prevNodeA.setNextNode(nodeB);
                prevNodeB.setNextNode(nodeA);
                nodeA.setNextNode(nodeB.getNextNode());
                nodeB.setNextNode(aux);
            }
        }
    }

    public Node nthlast(int n){
        int totalNums = this.getSize();
        int count = 0;
        Node currentNode = this.headNode;

        if(n > totalNums || n <= 0){
            System.out.println("Invalid position.");
            return null;
        }

        if(n == totalNums)
        {
            return this.headNode;
        }

        while(totalNums - count != n){
            currentNode = currentNode.getNextNode();
            count++;
        }
        return currentNode;
    }

    public void ndiff(int n){

        if(n <= 0 || n >= this.getSize()){
            System.out.println("Invalid n.");
            return;
        }

        n -= 1;
        Node currentNode = this.headNode;
        Node currentNode2 = this.headNode;
        int count = 0;
        int count2 = 0;

        System.out.println(this.getSize() * n);

        while(currentNode != null){
            currentNode = currentNode.getNextNode();
            count++;

            while((count - count2 > n) && (currentNode != null)){
                System.out.println("[ " + currentNode2.getData() + " , " + currentNode.getData() + " ]");
                currentNode2 = currentNode2.getNextNode();
                count2++;
            }
        }
    }
        
}
