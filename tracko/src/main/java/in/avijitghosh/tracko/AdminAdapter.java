package in.avijitghosh.tracko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;





public class AdminAdapter extends BaseAdapter {
    Context context;
    DeliveryDataPoint[] emp;

    public AdminAdapter(Context context, DeliveryDataPoint[] emp) {
        this.context=context;
        this.emp=emp;
    }

    @Override
    public int getCount() {
        return emp.length;
    }

    @Override
    public Object getItem(int i) {
        return emp[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_row_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_person_name);
        //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvName.setText(emp[position].name);

        TextView tv2 = (TextView) convertView.findViewById(R.id.tv_person_pin);

        tv2.setText("Orders fulfilled: "+emp[position].number);

        TextView tv3 = (TextView) convertView.findViewById(R.id.amt);

        tv3.setText("Last seen: "+ emp[position].last);



        //tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}
