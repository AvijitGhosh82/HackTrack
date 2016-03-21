package in.avijitghosh.hacktrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import in.avijitghosh.tracko.AdminActivity;
import in.avijitghosh.tracko.AdminAdapter;
import in.avijitghosh.tracko.DeliveryDataPoint;

public class Adminpanel extends AdminActivity {
    DeliveryDataPoint[] emp1= in.avijitghosh.tracko.Fakedatagenerator.makepeeps();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView lv=(ListView)findViewById(in.avijitghosh.tracko.R.id.listView);



        AdminAdapter adapter=new AdminAdapter(this, emp1);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_adminpanel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent ii=new Intent(Adminpanel.this, Login.class);
                startActivity(ii);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
