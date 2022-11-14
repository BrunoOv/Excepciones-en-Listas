package uaslp.objetos.list.List.ArrayList;

import uaslp.objetos.list.List.Iterator;
import uaslp.objetos.list.List.List;
import uaslp.objetos.list.List.exceptions.NullNotAllowedException;
import uaslp.objetos.list.List.exceptions.WrongIndexException;

public class ArrayList<T> implements List<T> {
    private T[] data;
    private int size;
    /*UNCHECKED*/
    public ArrayList(){
        data = (T[])new Object[2];
    }
    public void addAtTail(T data) throws NullNotAllowedException {
        if(data==null){
            throw new NullNotAllowedException();
        }
        if(size==this.data.length){
            increaseArraySize();
        }
        this.data[size] = data;
        size++;
    }
    public void addAtFront(T data)throws NullNotAllowedException{
        if(data==null){
            throw new NullNotAllowedException();
        }
        if(size == this.data.length ){
            increaseArraySize();
        }
        for(int i = size; i> 0; i--){
            this.data[i] = this.data[i-1];
        }
        this.data[0] = data;
        size++;
    }
    public void remove(int indexToRemove)throws WrongIndexException {
        if(indexToRemove < 0 || indexToRemove >= size) {throw new WrongIndexException();}
        for(int i = indexToRemove; i< size-1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
    }
    /*UNCHECKED*/
    public void removeAll(){
        for(int i = 0; i < size; i++){
            data[i] = null;
        }
        size = 0;
    }
    public void setAt(int index, T data) throws WrongIndexException,NullNotAllowedException{
        if(data==null){
            throw new NullNotAllowedException();
        }
        if(index < 0 || index >= size){
            throw new WrongIndexException();
        }
        this.data[index] = data;
    }

    public T getAt(int index)throws WrongIndexException {
        if(index < 0 || index >= size){
           throw new WrongIndexException();
        }
        return this.data[index];
    }
    /*UNCHECKED*/
    public void removeAllWithValue(T value){
        T[] newArray = (T[])new Object[data.length];
        int count = 0;
        for(int i = 0; i<size; i++){
            if (!data[i].equals(value)){
                newArray[count++] = data[i];
            }
        }
        this.data= newArray;
        size = count;

    }
    public int getSize() {
        return size;
    }
    /*UNCHECKED*/
    private void increaseArraySize(){
        T[] newArray=(T[])new Object[this.data.length*2];
        for(int i=0;i< data.length;i++){
            newArray[i]=data[i];
        }
        data=newArray;
    }
    /*Iterator ArrayList*/
    public Iterator<T> getIterator(){
        return new Iterator<T>() {
        int currentIndex = 0;
        public boolean hasNext(){
            return currentIndex<size;
        }
        public T next(){
            return data[currentIndex++];
        }
       };
    }

}


