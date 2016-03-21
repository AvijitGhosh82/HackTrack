package in.avijitghosh.hacktrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import in.avijitghosh.tracko.Employee;
import in.avijitghosh.tracko.TrackoActivity;
import in.avijitghosh.tracko.VisitAdapter;

public class MainActivity extends TrackoActivity {

    Employee emp1=Fakedatagenerator.createemployee1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ListView lv=(ListView)findViewById(in.avijitghosh.tracko.R.id.listView);



        VisitAdapter adapter=new VisitAdapter(this, emp1);
        lv.setAdapter(adapter);

        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent i = new Intent(MainActivity.this, OrderDetails.class);
                i.putExtra("name", emp1.getorderlist().get(position).custname );
                i.putExtra("addr", emp1.getorderlist().get(position).addr );
                i.putExtra("amt", emp1.getorderlist().get(position).amt );
                i.putExtra("lat", emp1.getorderlist().get(position).lat );
                i.putExtra("lng", emp1.getorderlist().get(position).lng );
                startActivity(i);

            }
        });

        //setContentView(R.layout.activity_main);

    }


}
