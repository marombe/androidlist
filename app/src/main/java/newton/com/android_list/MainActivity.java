package newton.com.android_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView myList;
    BaseAdapter adapter;
    ArrayList<Account> arraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = findViewById(R.id.mylist);
        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return arraylist.size();
            }

            @Override
            public Object getItem(int position) {
                return arraylist.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = getLayoutInflater().inflate(R.layout.list_item, null, true);
                TextView txtnames = v.findViewById(R.id.textViewNames);
                TextView txtAccNumber = v.findViewById(R.id.textViewAccnumber);
                TextView txtBalance = v.findViewById(R.id.textViewBalance);
                Account x = arraylist.get(position);
                txtnames.setText(x.getName() );
                txtAccNumber.setText(x.getAccNumber() );

                Locale locale = new Locale("en", "KE");
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                String balance=currencyFormatter.format(x.getBalance());
                txtBalance.setText(balance);
                return v;
            }
        };


        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Account k = arraylist.get(position);
                arraylist.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, k.getName(), Toast.LENGTH_SHORT).show();
            }
        });


        myList.setAdapter(adapter);
        Account ac1 = new Account("Emelda","AC001",100000);
        Account ac2 = new Account("Silvia","AC002",200000);
        Account ac3 = new Account("Dzancoh","AC003",300000);
        Account ac4 = new Account("Valentine","AC004",400000);
        Account ac5 = new Account("Brian","AC005",500000);
        Account ac6 = new Account("Karen","AC006",600000);
        Account ac7 = new Account("Steve","AC007",700000);
        Account ac8 = new Account("Nila","AC008",800000);
        Account ac9 = new Account("Platt","AC009",900000);
        Account ac10 = new Account("Faith.","AC0010",1000000);


        arraylist.add(ac1);
        arraylist.add(ac2);
        arraylist.add(ac3);
        arraylist.add(ac4);
        arraylist.add(ac5);
        arraylist.add(ac6);
        arraylist.add(ac7);
        arraylist.add(ac8);
        arraylist.add(ac9);
        arraylist.add(ac10);

        adapter.notifyDataSetChanged();

    }
}
