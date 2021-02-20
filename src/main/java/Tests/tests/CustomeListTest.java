package main.java.Tests.tests;

import main.java.com.company.CustomeList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomeListTest {



    @Test
    void add() {
        CustomeList<String> strlist=new CustomeList<String>();
        strlist.add("First");
        assertEquals("First",strlist.getByIndex(0));

        strlist.add("Second");
        strlist.add("Third");
        assertTrue(strlist.contains("Third"));
    }

    @Test
    void removeFirstOrDefault() {
        CustomeList<Integer> intlist=new CustomeList<Integer>();

        intlist.add(0);
        intlist.add(1);
        intlist.add(2);
        intlist.add(3);
        intlist.add(4);

        assertTrue(intlist.contains(2));
        intlist.removeFirstOrDefault(2);
        assertFalse(intlist.contains(2));

    }

    @Test
    void removeByIndex() {
        CustomeList<Integer> intlist=new CustomeList<Integer>();

        intlist.add(0);
        intlist.add(1);
        intlist.add(2);
        intlist.add(3);
        intlist.add(4);

        assertTrue(intlist.contains(2));
        intlist.removeByIndex(2);
        assertFalse(intlist.contains(2));
    }

    @Test
    void getByIndex() {
        CustomeList<Double> dblist =new CustomeList<Double>();
        dblist.add(2.2);
        dblist.add(3.6);
        dblist.add(1.4);
        dblist.add(5.3);

        assertEquals(1.4,dblist.getByIndex(2));

        assertNull(dblist.getByIndex(67));
    }

    @Test
    void getCount() {
        CustomeList<Double> dblist =new CustomeList<Double>();
        dblist.add(2.2);
        dblist.add(3.6);
        dblist.add(1.4);
        dblist.add(5.3);
        assertEquals(4,dblist.getCount());
        dblist.add(5.3);
        assertEquals(5,dblist.getCount());
        dblist.removeByIndex(3);
        assertEquals(4,dblist.getCount());
    }

    @Test
    void isEmpty() {
        CustomeList<String> strlist=new CustomeList<String>();
        assertTrue(strlist.isEmpty());
        strlist.add("d");
        assertFalse(strlist.isEmpty());
    }

    @Test
    void clear() {
        CustomeList<String> strlist=new CustomeList<String>();

        strlist.add("d");
        assertFalse(strlist.isEmpty());
        strlist.clear();
        assertTrue(strlist.isEmpty());

    }

    @Test
    void contains() {
        CustomeList<Integer> intlist=new CustomeList<Integer>();

        intlist.add(6);
        intlist.add(7);
        intlist.add(8);
        intlist.add(9);

        assertTrue(intlist.contains(6));
        assertFalse(intlist.contains(2));
    }
    @Test
    void testIterator(){
        CustomeList<String> strlist=new CustomeList<String>();

        strlist.add("a");
        strlist.add("b");
        strlist.add("c");
        strlist.add("d");
        strlist.add("e");

        int temp=0;

        for(String s:strlist)
        {
            System.out.println(s);
            temp++;
        }
        assertEquals(5,strlist.getCount());
    }
}