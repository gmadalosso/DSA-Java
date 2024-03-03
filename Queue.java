public class Queue {

    public LinkedList queue;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Queue() {
        this(DEFAULT_MAX_SIZE);
    }

    public Queue(int maxSize){
        this.queue = new LinkedList();
        this.size = 0;
        this.maxSize = maxSize;
     }
    
    public void enqueue(String data){
        if(this.hasSpace() == true){
            this.queue.addToTail(data);
            this.size++;
            System.out.println("Added " + data + "! Queue size is now " + this.size);
        }
        else{
            System.out.println("Queue is full!");
        }
    }

    public String dequeue(){
        if(this.isEmpty() == true){
            System.out.println("Queue is empty!");
            return null;
        }
        else{
            String data = this.queue.getHeadNode().getData();
            this.queue.removeHead();
            this.size--;
            System.out.println("Removed " + data + "! Queue size is now " + this.size);
            return data;
        }

    }

    public String peek(){
        if(this.isEmpty() == true){
            return null;
        }
        else{
            return this.queue.getHeadNode().getData();
        }
    }

    public boolean hasSpace(){
        if(this.size < maxSize){
            return true;
        }else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }else{
            return false;
        }
    }
    

}
