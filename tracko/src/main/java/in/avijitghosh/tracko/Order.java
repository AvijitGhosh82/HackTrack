package in.avijitghosh.tracko;

/**
 * Created by Avijit Ghosh on 02 Oct 2015.
 */
public class Order {
    public String custname, addr, amt, lat, lng;
    Boolean state;
    public Order(String custname, String addr, String amt, String lat, String lng)
    {
        this.custname=custname;
        this.addr=addr;
        this.amt=amt;
        this.lat=lat;
        this.lng=lng;
        this.state=false;
    }

    void complete()
    {
        this.state=true;
    }

    String showlat()
    {
        return lat;
    }

    String showlng()
    {
        return lng;
    }
}
