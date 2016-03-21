package in.avijitghosh.tracko;

/**
 * Created by Avijit Ghosh on 02 Oct 2015.
 */
public class DeliveryDataPoint {
    public String lat, lng, name, number, last;

    public DeliveryDataPoint(String lat, String lng, String name, String number, String last)
    {
        this.lat=lat;
        this.lng=lng;
        this.name=name;
        this.number=number;
        this.last=last;
    }
}
