package com.company;
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
        SetData(data);
    }
    // Гетеры и сетеры
    public void SetData(T data) {
        this.data = data;
    }
    public void SetNext(Node<T> next) {
        this.next = next;
    }
    public T GetData() {
        return data;
    }
    public Node<T> GetNext() {
        return next;
    }
}
