package arrayList;

public class ArrayList<E> implements ArrayInterface<E> {
    private int size;
    private int capacity;
    private E[] myArray;

    //constructors
    public ArrayList() {
        this.capacity =5;
        this.size=0;
        myArray = (E[]) new Object[this.capacity];
    }

    public ArrayList(int capacity){
        this.size=0;
        myArray = (E[]) new Object[this.capacity];
    }

    public void add(E a){
        if (size<capacity) {
            myArray[size]=a; //set object at first empty space
            size++;
        } else {
            this.reallocate(); //TODO
            this.add(a);
        }
    }

    public void reallocate(){
        //double capacity of ArrayList
        this.capacity*=2; //shorthand 
        E[] temp = (E[]) new Object[this.capacity];
        //copy over the elements to new array
        for(int i = 0; i<myArray.length; i++){
            temp[i] = myArray[i];
        }
        this.myArray =temp;
    }

    public void add(int index, E a){
        //check if index is valid
        if(index<0 || index >size){
            System.out.println("invalid index");
            return;
        } else if (index ==size){
            //adds to the end so we use existing add method
            this.add(a);
        } else {
            //shift all contents over from index to the end by 1

            if(this.capacity ==this.size){
                //this means array is full
                this.reallocate();
            }
                
            for(int i=size-1; i>index; i--){
                this.myArray[i] = this.myArray[i-1];
            }
            this.myArray[index]=a; //add intended object to index
            this.size++;
        }
        //check off by 1 error
    }

    public E remove (int index){
        //invalid index: <0  , >size, 
        if (index<0 || index>=size){
            System.out.println("invalid index");
            return null;
        }
        E temp =myArray[index];
        //then shift remaining elements to fill that empty space
        for(int i =index; i<size-1; i++){
            this.myArray[i] = this.myArray[i+1];
        }
        size--;
        return temp;

    }
    public E get(int index){
        //index validity check
        if (index<0 || index>=size){
            System.out.println("invalid index");
            return null;
        }
        return myArray[index];
    }

    public void set(int index, E a){
        //index validity check
        if (index<0 || index>=size){
            System.out.println("invalid index");
            return;
        }
        myArray[index] = a;
    }
     
    public int getSize(){
        return this.size;
    }
     
    public int indexOf(E a){
        //returns the index of the value being searched
        for(int i=0; i<size;i++){
            if(myArray[i].equals(a)){
                return i; 
            }
        }
        return -1; //if nothing matches object
    }

    public String toString(){
        //called by sysout.print()
        String s="";
        for(int i=0;i<size; i++){
            s+= myArray[i] + "\n";
        }
        return s;
    }
     //lastly create a toString method that will concatenate all the values to a string and return the string. 


}
