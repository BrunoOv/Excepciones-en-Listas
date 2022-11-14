package uaslp.objetos.list.List.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.List.ArrayList.ArrayList;
import uaslp.objetos.list.List.Iterator;
import uaslp.objetos.list.List.List;
import uaslp.objetos.list.List.exceptions.NullNotAllowedException;
import uaslp.objetos.list.List.exceptions.WrongIndexException;

public class ArrayListTest {
    /*LinkedList*/
    @Test
    public void test_addAtTail()throws NullNotAllowedException {
        List lista=new ArrayList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        lista.addAtTail("3");
        lista.addAtTail("4");
        try{
            lista.addAtTail(null);
        }catch (NullNotAllowedException n){
            System.out.println("NullNotAllowedException :c");
        }


    }

    @Test
    public void test_addAtFront()throws NullNotAllowedException{
        List lista=new ArrayList();
        lista.addAtFront("1");
        lista.addAtFront("2");
        lista.addAtFront("3");
        try{
            lista.addAtFront(null);
        }catch (NullNotAllowedException n){
            System.out.println("NullNotAllowedException :c");
        }
    }

    @Test
    public void test_remove() throws WrongIndexException {
        List lista=new ArrayList();
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.addAtTail("1");
        lista.remove(0);//primero
        lista.remove(1);//enmedio
        lista.remove(1);//atras
        lista.remove(0);//final
        try {
            lista.remove(0);//no existe
        }catch (WrongIndexException ne){
            System.out.println("Exception thrown ");
        }

    }
    @Test
    public void test_removeAll() throws NullNotAllowedException {
        List lista=new ArrayList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        lista.removeAll();
    }
    @Test
    public void test_setAt()throws WrongIndexException,NullNotAllowedException {
        List lista=new ArrayList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        lista.setAt(0,"new");//si se va poder xd
        try{
            lista.setAt(2,"new");//no existe index
        }catch (NullNotAllowedException | WrongIndexException ne){
            System.out.println("Exception thrown ");
        }try {
            lista.setAt(1,null);//data null
        }catch (NullNotAllowedException | WrongIndexException ne) {
            System.out.println("Exception thrown ");
        }
    }
    @Test
    public void test_getAt() throws WrongIndexException {
        List lista=new ArrayList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        lista.getAt(0);
        try{
            lista.getAt(2);//no esta
        }catch (WrongIndexException w){
            System.out.println("WrongIndexException ");
        }
    }
    @Test
    public void Test_removeAllWithValue() {
        List lista=new ArrayList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        lista.addAtTail("2");
        lista.addAtTail("1");
        lista.removeAllWithValue("1");
        lista.removeAllWithValue("2");
    }
    @Test
    public void test_getSize() {
        List lista=new ArrayList();
        lista.addAtTail("1");
        lista.addAtTail("2");
        System.out.println(lista.getSize());
    }
    @Test
    public void test_getIterator() throws NullNotAllowedException {
        List lista=new ArrayList();
        lista.addAtTail("1");
        lista.addAtTail("1");
        Iterator iterator=lista.getIterator();

    }
    /*ArrayList Iterator*/
    @Test
    public void test_Iterator_hasNext() throws NullNotAllowedException {
        List lista=new ArrayList();
        lista.addAtTail("1");
        Iterator iterator=lista.getIterator();
    }
    @Test
    public void test_Iterator_next() throws NullNotAllowedException {
        List lista=new ArrayList();
        lista.addAtTail("1");
        lista.addAtTail("1");
        Iterator iterator=lista.getIterator();
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("1",iterator.next());
    }

}
