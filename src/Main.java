import uaslp.objetos.list.List.List;
import uaslp.objetos.list.List.Iterator;
import uaslp.objetos.list.List.ArrayList.ArrayList;
import uaslp.objetos.list.List.LinkedList.LinkedList;
import uaslp.objetos.list.List.exceptions.NullNotAllowedException;
import uaslp.objetos.list.List.exceptions.WrongIndexException;

public class Main {
    public static void main(String[] args) throws NullNotAllowedException {
        List lista = new LinkedList();

        try{
            lista.setAt(10,"hola");
            lista.setAt(10,"hola");
            lista.setAt(10,"hola");
            lista.setAt(10,"hola");
            lista.setAt(10,"hola");
        }catch (WrongIndexException ex){
            System.out.println("No se pudo insetar el dato");
        }catch (NullNotAllowedException e){
            System.out.println("No acepta valores nulos");
        }
    }
}



