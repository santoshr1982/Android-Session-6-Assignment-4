package app.menu.sub.rsantosh.com.contextmenu;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import app.menu.sub.rsantosh.com.contextmenu.Adapter.ContactAdapter;
import app.menu.sub.rsantosh.com.contextmenu.Model.Contacts;

public class ContextMenuCallSms extends AppCompatActivity {

    //Variable declaration Section.
    //Declaration of list view.
    private ListView mlistview;
    //Declaration of Arraylist.
    private ArrayList<Contacts> mArrayContact;
    // Declaration of Adapter.
    private ContactAdapter mContactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_call_sms);

        //Initialisation of list view.
        mlistview = (ListView) findViewById(R.id.contacts_list);
        //Fetching the values into Array.
        mArrayContact = getData();
        //Initialisation of Adapter.
        mContactAdapter = new ContactAdapter(this,R.layout.contact_list_item,mArrayContact);
        //Setting the adapter to the list view.
        mlistview.setAdapter(mContactAdapter);

        //Registering the context menu for List view.
        registerForContextMenu(mlistview);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //Setting the header to the context menu.
        menu.setHeaderTitle("Select The Action");

        //Creating the context menu items.
        menu.add(1,100,1,"Call");
        menu.add(1,101,2,"Send SMS");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Setting the adapter view.
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        //Switch case statement.
        switch(item.getItemId()) {

            case 100:

                //This code is to make a call.
                String call = "tel:" + String.valueOf(mArrayContact.get(info.position).strContactNo);
                Intent PhoneCall = new Intent(Intent.ACTION_CALL, Uri.parse(call));

                try{

                    //Starting an activity.
                    startActivity(PhoneCall);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"The number is wrong",Toast.LENGTH_LONG).show();
                }

                return  true;

            case 101:

                //This code is to send sms.
                String SMS = "smsto:" + String.valueOf(mArrayContact.get(info.position).strContactNo);
                Intent sms = new Intent(Intent.ACTION_VIEW, Uri.parse(SMS));

                try{
                    //Starting activity.
                    startActivity(sms);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"The number is wrong",Toast.LENGTH_LONG).show();
                }

                return  true;

        }

        return super.onContextItemSelected(item);
    }

    private ArrayList<Contacts> getData() {

        //Initialisation of Arraylist.
        mArrayContact = new ArrayList<>();

        //Hard coding the values to the Arraylist.
        mArrayContact.add(new Contacts("Pushpa", "9988778877"));
        mArrayContact.add(new Contacts("Latha", "9988778874"));
        mArrayContact.add(new Contacts("Arjun", "9988778844"));
        mArrayContact.add(new Contacts("Kiran", "7988778877"));
        mArrayContact.add(new Contacts("Arnav", "9968778877"));

        //Returning Array list object.
        return mArrayContact;
    }
}
