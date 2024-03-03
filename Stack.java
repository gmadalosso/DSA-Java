public class Stack {
    public LinkedList stack;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack(int maxSize) {
      this.stack = new LinkedList();
      this.size = 0;
      this.maxSize = maxSize;
    }

    public void push(String data){
        if(this.hasSpace()){
            this.stack.addToHead(data);
            this.size++;
            System.out.println("Added " + data +"! Stack size is now " + this.size);
        }else{
            System.out.println("The stack is full!");
        }
    }

    public String pop(){
        if(this.isEmpty())
        {
            System.out.println("The stack is empty!");
            return null;
        }
        else{
            String data = this.stack.getHeadNode().getData();
            this.stack.removeHead();
            this.size--;
            System.out.println("Removed " + data +"! Stack size is now " + this.size);
            return data;
        }

    }

    public String peek(){
        if(this.isEmpty()){
            return this.stack.getHeadNode().getData();
        }
        else{
            System.out.println("The stack is empty!");
            return null;
        }
    }

    public boolean hasSpace(){
        if(this.size < maxSize){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
}
