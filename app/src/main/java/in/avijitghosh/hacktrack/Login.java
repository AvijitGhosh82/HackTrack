package in.avijitghosh.hacktrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private String access;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






            setContentView(R.layout.activity_login);

            final EditText login = (EditText) findViewById(R.id.username);
            final EditText pass = (EditText) findViewById(R.id.password);


        Button b=(Button)findViewById(R.id.butt);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String user=login.getText().toString();
                    String passw=pass.getText().toString();
                    if(user.equals("delivery") && passw.equals("password"))
                    {
                        Intent ii=new Intent(Login.this, MainActivity.class);
                        startActivity(ii);
                    }
                    else if(user.equals("admin") && passw.equals("password"))
                    {
                        Intent ii=new Intent(Login.this, Adminpanel.class);
                        startActivity(ii);
                    }
                    else
                        Toast.makeText(Login.this, "Wrong username/password", Toast.LENGTH_LONG).show();
                }
            });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
