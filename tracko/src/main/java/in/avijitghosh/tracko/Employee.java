package in.avijitghosh.tracko;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avijit Ghosh on 02 Oct 2015.
 */
public class Employee {
    String name, id;
    List<Order> orderlist = new ArrayList<Order>();


    public Employee(String name, String id)
    {
        this.name=name;
        this.id=id;
    }

    void addorder(Order order)
    {
        orderlist.add(order);
    }

    public List<Order> getorderlist()
    {
        return orderlist;
    }



}
