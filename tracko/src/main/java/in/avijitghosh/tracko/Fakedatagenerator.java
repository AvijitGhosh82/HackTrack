package in.avijitghosh.tracko;

/**
 * Created by Avijit Ghosh on 02 Oct 2015.
 */
public class Fakedatagenerator {
    public static Employee createemployee1()
    {
        Employee emp1=new Employee("Manish", "1");
        Employee emp2=new Employee("Ritam", "2");
        Employee emp3=new Employee("Ushnish", "3");

        Order o1=new Order("Smruti Ranjan Swain", "Nalanda", "500", "22.315783", "87.316752");
        Order o2=new Order("Gaurav Jain", "Technology Guest House", "1250.50", "22.315719", "87.303685");
        Order o3=new Order("Mayank Jindal", "Tech market", "200", "22.314649", "87.300330");
        Order o4=new Order("Himanshu Mishra", "Gymkhana", "8000", "22.318630", "87.302658");

        emp1.getorderlist().add(o1);
        emp1.getorderlist().add(o2);
        emp1.getorderlist().add(o3);
        emp1.getorderlist().add(o4);

        return emp1;

    }

    public static DeliveryDataPoint[] makepeeps()
    {
        DeliveryDataPoint[] dp = new DeliveryDataPoint[3];
        dp[0]=new DeliveryDataPoint("22.322275", "87.309446", "Manish", "5", "7:30");
        dp[1]=new DeliveryDataPoint("22.287110", "87.296857", "Ushnish", "0", "12:30");
        dp[2]=new DeliveryDataPoint("22.312117", "87.304796", "Ritam", "4", "10:00");

        return dp;

    }

}
