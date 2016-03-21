package in.avijitghosh.tracko;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Avijit Ghosh on 02 Oct 2015.
 */
public class TrackObject {
    String dbuser, dbpass, dbname, dbtable;
    List<Employee> emplist = new ArrayList<Employee>();


    void setDb(String dbuser,String dbpass,String dbname,String dbtable)
    {
        this.dbname=dbname;
        this.dbpass=dbpass;
        this.dbtable=dbtable;
        this.dbuser=dbuser;
    }

    void newOrder(String empid ,Order order)
    {
        Boolean flag=false;
        if(emplist.size()!=0)
        {
            for (ListIterator<Employee> iter = emplist.listIterator(); iter.hasNext(); )
            {
                Employee element = iter.next();
                if(element.id.equals(empid))
                {
                    element.addorder(order);
                    flag=true;
                }
            }
            if(flag==false)
            {
                Employee newemp=new Employee("Name", empid);
                newemp.addorder(order);
            }
        }
    }

    List<Order> getorders(String empid)
    {
        if(emplist.size()!=0)
        {
            for (ListIterator<Employee> iter = emplist.listIterator(); iter.hasNext(); )
            {
                Employee element = iter.next();
                if(element.id.equals(empid))
                {
                    return element.getorderlist();
                }
            }
        }
        return null;

    }


}
