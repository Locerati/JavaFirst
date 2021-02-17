package com.company;

import java.util.Iterator;

/**
 * Класс - коллекция позволяющий хранить сколь угодное количество элементов
 * и производить манипуляции с ними
 * @author Denis Popov
 * @version 1.0
 * @param <T> тип элемента Списка
 */
public class CustomeList<T> implements Iterable<T> {
    /** Первый элемент списка */
    Node<T> head;
    /** Последний элемент списка*/
    Node<T> tail;
    /** Количество элементов в списке*/
    int count;

    /** Геттер возвращающий первый элемент*/
    public Node<T> GetHead(){
        return  head;
    }
    /** Геттер возвращающий последний элемент*/
    public Node<T> GetTail(){
        return tail;
    }
    /** Метод добавления элемента*/
    public void Add(T data){
        Node<T> node=new Node<T>(data);
        if(head==null) //Если коллекция пуста, то инициализируем head
            head=node;
        else
            tail.SetNext(node);
        tail=node; //Перестраиваем tail
        count++;
    }

    /**
     *  Метод удаления элмента в списке, если он там имеется
     * @param data - принимает элемент который нужно удалить
     * @return - возвращает логическое значение равное успешному или неуспешному результату
     */
    public boolean RemoveFirstOrDefault(T data)
    {
        Node<T> current = head; // временные переменные для обхода по коллекции
        Node<T> previous = null;

        while (current != null) //пока не дойдем до конца
        {
            if (current.GetData().equals(data))
            {
                // Если унаш элемент в середине или в конце
                if (previous != null)
                {
                    // убираем узел current, previous ссылается на current.Next
                    previous.SetNext(current.GetNext());

                    // Если current.Next не установлен, значит узел последний
                    if (current.GetNext() == null)
                        tail = previous;
                }
                else
                {
                    // если удаляется первый элемент, то переустанавливаем значение head
                    head = head.GetNext();

                    // если после удаления список пуст, сбрасываем tail
                    if (head == null)
                        tail = null;
                }
                count--; //уменьшаем количество элементов
                return true;
            }

            previous = current;
            current = current.GetNext();
        }
        return false; //Если элемент не найден, то возвращаем отрицательный результат
    }
    /**
     *  Метод удаления элмента в списке по индексу, если он там имеется
     * @param index - принимает индекс элмента, который нужно удалить
     * @return - возвращает логическое значение равное успешному или неуспешному результату
     */
    public boolean RemoveByIndex(int index)
    {
        Node<T> current = head; // временные переменные для обхода по коллекции
        Node<T> previous = null;
        int temp=0;
        if (index>count-1||index<0) // Если индекс лежит за пределами имеющихся
        {
            return false; // Возращаем отрицательный результат
        }

        while (temp<=index) //Пока не дойдем до нашего индекса, перебираем коллекцию
        {
            if (temp==index)
            {
                // Если узел в середине или в конце
                if (previous != null)
                {
                    // убираем узел current, теперь previous ссылается  на current.Next
                    previous.SetNext(current.GetNext());

                    // Если current.Next не установлен, значит узел последний,изменяем переменную tail
                    if (current.GetNext() == null)
                        tail = previous;
                }
                else
                {
                    // если удаляется первый элемент, то переустанавливаем значение head
                    head = head.GetNext();

                    // если после удаления список пуст, сбрасываем tail
                    if (head == null)
                        tail = null;
                }
                count--; //уменьшаем общее количество элементов
                return true;
            }
            temp++; //Прибаляем шаг
            previous = current;
            current = current.GetNext();
        }
        return false;
    }
    /**
     *  Метод взятия элмента по индексу
     * @param index - принимает индекс элмента, который нужно найти
     * @return - возвращает элемент или null, если элемент не найден
     */

    public T GetByIndex(int index){
        int temp=0;
        Node<T> current = head;
        while(temp<=index && current != null){ //доходим до нужного нам индекса
            if (temp==index){
                return current.GetData();
            }
            else {
                current=current.GetNext();
            }
            temp++;
        }
        return null; //Возращаем null как не найденное значение

    }
    /** Метод возвращающий кол-во элементов коллекции*/
    public int GetCount() {  return count;  }
    /** Метод проверяющий пуста ли коллекция*/
    public boolean IsEmpty() { return count == 0; }

    /** Очистка коллекции */
    public void Clear()
    {
        head = null;
        tail = null;
        count = 0;
    }
    /** Метод проверяющий содержит ли коллекция элемент*/
    public boolean Contains(T data)
    {
        Node<T> current = head;
        while (current != null)
        {
            if (current.GetData().equals(data))
                return true;
            current = current.GetNext();
        }
        return false;
    }
    /**
     * Реализация интерфейса Iterable
     * @see CustomeListIterator
     * */

    @Override
    public Iterator<T> iterator() {
        return new CustomeListIterator<T>(this);
    }
}
