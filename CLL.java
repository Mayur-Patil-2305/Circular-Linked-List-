class node{         //create node
    private node link;
    private int data;

    public node(){
        this.link=null;
        this.data=0;
    }

    public node(node link, int data) {
        this.link = link;
        this.data = data;
    }

    public node getLink() {
        return link;
    }

    public void setLink(node link) {
        this.link = link;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

public class CLL{               //creating circular linked list
    private node front;     //two pointers front and rear
    private node rear;
    private int size;       //counter for traversing

    public CLL(){        //non parameterized default constructor
        this.front=null;
        this.rear=null;
        this.size=0;
    }

    public void insert(int data,int position){      //insert at position function
        if(position==1) {                           //insert at first position
            node tmp = new node(front, data);       //create temporary node
            if (front == null) {                    //check if list is empty
                front = tmp;
                tmp.setLink(front);
                rear = front;
            } else {
                rear.setLink(tmp);
                front = tmp;
            }
            size++;
        }
        else if(position>1 && position<size){       //check is entered position is valid or not
            node tmp=new node(null,data);      //temporary node
            node p=front;                           //node pointing to front
            while(position!=1){                     //traverse untill required node found
                p=p.getLink();
                position--;
            }
            node q=p.getLink();                     //next node of p
            p.setLink(tmp);
            tmp.setLink(q);
            size++;
        }
        else if(position==size+1){                  //insert at last
            node tmp=new node(null,data);
            rear.setLink(tmp);
            tmp.setLink(front);
            rear=tmp;
            size++;
        }

        else{
            System.out.println("Enter Valid position");
        }

    }

    public void delete(int data){       //delete data
        int counter=size;
        node p=front;       //two pointers p and q for delete operation
        node q=front;       //one is always next to other
        q=q.getLink();
        if(size==0){
            System.out.println("List is Empty");
            return;
        }

        while(counter!=0){
            if(q.getData()==data)
                break;
            p=p.getLink();
            q=q.getLink();
            counter--;
        }

        if(counter==0){
            System.out.println("Entered Data Not Exists in List");
        }
        else {
            if(size==1){
                front=null;
                rear=null;
                size=0;
            }
            else if (front.getData() == data) {
                front = front.getLink();
                rear.setLink(front);
                size--;
            } else if (rear.getData() == data) {
                p.setLink(front);
                rear = p;
                size--;
            } else {
                node tmp = q.getLink();
                p.setLink(tmp);
                size--;
            }
        }
    }
    public void display(){      //traversing circular linked list
        int counter=size;
        if(size==0)
        {
            front=null;
            rear=null;
            size=0;
            System.out.println("List Is Empty");
        }
        else{
            node p=front;
            while(counter!=-1){
                System.out.print(p.getData()+" - >");
                p=p.getLink();
                counter--;
            }
        }
    }

}
