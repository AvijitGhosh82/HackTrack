package in.avijitghosh.tracko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Avijit Ghosh on 10 Sep 2015.
 */


/**
 * Created by Avijit Ghosh on 14 Jul 2015.
 */
public class VisitAdapter extends BaseAdapter {
    Context context;
    Employee emp;

    public VisitAdapter(Context context, Employee emp) {
        this.context=context;
        this.emp=emp;
    }

    @Override
    public int getCount() {
        return emp.getorderlist().size();
    }

    @Override
    public Object getItem(int i) {
        return emp.getorderlist().get(i);
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
            convertView = LayoutInflater.from(context).inflate(in.avijitghosh.tracko.R.layout.single_row_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(in.avijitghosh.tracko.R.id.tv_person_name);
        //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvName.setText(emp.getorderlist().get(position).custname.toString());

        TextView tv2 = (TextView) convertView.findViewById(in.avijitghosh.tracko.R.id.tv_person_pin);

        tv2.setText(emp.getorderlist().get(position).addr.toString());

        TextView tv3 = (TextView) convertView.findViewById(in.avijitghosh.tracko.R.id.amt);

        tv3.setText("Rs. "+ emp.getorderlist().get(position).amt.toString());



        //tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}
