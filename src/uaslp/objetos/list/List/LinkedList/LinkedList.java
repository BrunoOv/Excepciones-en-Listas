package uaslp.objetos.list.List.LinkedList;
import uaslp.objetos.list.List.Iterator;
import uaslp.objetos.list.List.List;
import uaslp.objetos.list.List.exceptions.NullNotAllowedException;
import uaslp.objetos.list.List.exceptions.WrongIndexException;

public class LinkedList<T> implements List<T> {
    private  Node<T> head,tails;
    private int size;
    public LinkedList(){
        head = tails = null;
        size = 0;
    }

    public void addAtTail(T data)throws NullNotAllowedException {
        if(data==null){
            throw new NullNotAllowedException();
        }
        Node<T> node = new Node<>(data);
        if(tails == null) head = node;
        else
        {
            node.previous = tails;
            tails.next = node;
        }
        tails = node;
        size++;

    }
    public void addAtFront(T data)throws NullNotAllowedException{
        if(data==null){
            throw new NullNotAllowedException();
        }
        Node<T> node = new Node<>(data);
        if(head == null) tails = node;
        else {
            node.next = head;
        }
        head = node;
        size++;
    }
    public void remove(int index) throws WrongIndexException {
        if(index<0||index>=size){
            throw new WrongIndexException();
        }
        int coun = 0;
        if (head != null) {
            Node aux;
            Node ant = null;
            aux = head;
            while (aux != null && coun != index) {
                ant = aux;
                aux = aux.next;
                coun++;
            }
            if (ant == null) {
                head = aux.next;
                size--;
            } else {
                ant.next = aux.next;
                size--;
            }
        }
    }


    public void removeAll()
    {
        while(head!=null){
            head=head.next;
        }
        size=0;

    }

    public void setAt(int index,T data) throws WrongIndexException,NullNotAllowedException{
        if(data==null)throw new NullNotAllowedException();
        if (index<0 || index >= size){
            throw new WrongIndexException();
        }
        Node node=head;
        int coun=0;
        while (node != null && coun != index)
        {
            node= node.next;
            coun++;
        }
        if(node !=null) {
            node.setData(data);
        }
    }

    public T getAt(int index)throws WrongIndexException{
        if(index<0||index>=size){
            throw new WrongIndexException();
        }
        Node<T> node=findNodeByIndex(index);
        return node.data;
    }
    private Node<T> findNodeByIndex(int index){
        Node<T> iteratorNode=head;
        int indexIteratorNode=0;
        while (indexIteratorNode<index) {
            iteratorNode=iteratorNode.next;
            indexIteratorNode++;
        }
        return iteratorNode;
    }
    public void removeAllWithValue(T data){
        Node<T> node = head;
        while (node != null)
        {
            if(node.GetDataNode()==data)
            {
                size--;
                Node<T> aux1,aux2;
                aux1=node.previous;
                aux2=node.next;
                if(aux1 != null)
                {
                    aux1.next=aux2;
                }
                else//elimina el primero
                {
                    head=aux2;
                }
                if(aux2 !=null)
                {
                    aux2.previous= aux1;
                }
                else
                {
                    tails= aux1;
                }
            }
            node=node.next;
        }
    }
    public int getSize() {
        return size;
    }
    public LinkedListIterator getIterator(){
        return new LinkedListIterator();
    }

    ///////NODE//////
    static class Node<T> {
        private Node<T> next,previous;
        private T data;
        public Node(T data) {
            next = previous = null;
            this.data = data;
        }
        public T GetDataNode() {return data;}
        public void setData(T data) {
            this.data = data;
        }
    }

    /////LINKED_LIST_ITERATOR////
    public class LinkedListIterator implements Iterator {
        private Node<T> node;
        public LinkedListIterator(){
            this.node = head;
        }
        public boolean hasNext(){
            return node != null;
        }
        public T next(){
            T dato = node.GetDataNode();
            node = node.next;
            return dato;
        }
    }
}
