package main.java.com.company;
/**
 * Класс представляющий объект в коллекции
 * @author Denis Popov
 * @version 1.0
 * @param <T> тип элемента Списка
 */
public class Node<T> {
    private T data; //Значение элмента
    private Node<T> next; // Ссылка на след элемент
    public Node(T data){
        setData(data);
    }
    // Гетеры и сетеры
    public void setData(T data) {
        this.data = data;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public T getData() {
        return data;
    }
    public Node<T> getNext() {
        return next;
    }
}
