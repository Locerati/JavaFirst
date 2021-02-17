package tests;

import com.company.CustomeList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomeListTest {



    @Test
    void add() {
        CustomeList<String> strlist=new CustomeList<String>();
        strlist.Add("First");
        assertEquals("First",strlist.GetByIndex(0));

        strlist.Add("Second");
        strlist.Add("Third");
        assertTrue(strlist.Contains("Third"));
    }

    @Test
    void removeFirstOrDefault() {
        CustomeList<Integer> intlist=new CustomeList<Integer>();

        intlist.Add(0);
        intlist.Add(1);
        intlist.Add(2);
        intlist.Add(3);
        intlist.Add(4);

        assertTrue(intlist.Contains(2));
        intlist.RemoveFirstOrDefault(2);
        assertFalse(intlist.Contains(2));

    }

    @Test
    void removeByIndex() {
        CustomeList<Integer> intlist=new CustomeList<Integer>();

        intlist.Add(0);
        intlist.Add(1);
        intlist.Add(2);
        intlist.Add(3);
        intlist.Add(4);

        assertTrue(intlist.Contains(2));
        intlist.RemoveByIndex(2);
        assertFalse(intlist.Contains(2));
    }

    @Test
    void getByIndex() {
        CustomeList<Double> dblist =new CustomeList<Double>();
        dblist.Add(2.2);
        dblist.Add(3.6);
        dblist.Add(1.4);
        dblist.Add(5.3);

        assertEquals(1.4,dblist.GetByIndex(2));

        assertNull(dblist.GetByIndex(67));
    }

    @Test
    void getCount() {
        CustomeList<Double> dblist =new CustomeList<Double>();
        dblist.Add(2.2);
        dblist.Add(3.6);
        dblist.Add(1.4);
        dblist.Add(5.3);
        assertEquals(4,dblist.GetCount());
        dblist.Add(5.3);
        assertEquals(5,dblist.GetCount());
        dblist.RemoveByIndex(3);
        assertEquals(4,dblist.GetCount());
    }

    @Test
    void isEmpty() {
        CustomeList<String> strlist=new CustomeList<String>();
        assertTrue(strlist.IsEmpty());
        strlist.Add("d");
        assertFalse(strlist.IsEmpty());
    }

    @Test
    void clear() {
        CustomeList<String> strlist=new CustomeList<String>();

        strlist.Add("d");
        assertFalse(strlist.IsEmpty());
        strlist.Clear();
        assertTrue(strlist.IsEmpty());

    }

    @Test
    void contains() {
        CustomeList<Integer> intlist=new CustomeList<Integer>();

        intlist.Add(6);
        intlist.Add(7);
        intlist.Add(8);
        intlist.Add(9);

        assertTrue(intlist.Contains(6));
        assertFalse(intlist.Contains(2));
    }
    @Test
    void testIterator(){
        CustomeList<String> strlist=new CustomeList<String>();

        strlist.Add("a");
        strlist.Add("b");
        strlist.Add("c");
        strlist.Add("d");
        strlist.Add("e");

        int temp=0;

        for(String s:strlist)
        {
            System.out.println(s);
            temp++;
        }
        assertEquals(5,strlist.GetCount());
    }
}