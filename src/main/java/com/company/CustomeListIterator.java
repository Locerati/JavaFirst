
package main.java.com.company;


import java.util.Iterator;
/**
 * Класс реализующий интерфейс Iterator для обхода элементов коллекции
 * @author Denis Popov
 * @version 1.0
 * @param <T> тип элемента Списка
 */
public class CustomeListIterator<T> implements Iterator<T> {
    Node<T> current;
    public CustomeListIterator(CustomeList<T> list){
        current=list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        T data = current.getData();
        current=current.getNext();
        return data;
    }

    @Override
    public void remove() {

    }
}
