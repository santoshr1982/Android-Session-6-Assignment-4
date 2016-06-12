package app.menu.sub.rsantosh.com.contextmenu.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.menu.sub.rsantosh.com.contextmenu.Model.Contacts;
import app.menu.sub.rsantosh.com.contextmenu.R;

/**
 * Created by R Santosh on 12-06-2016.
 */
public class ContactAdapter extends ArrayAdapter {

    //Declaration of variables.
    // Declaration of context.
    private Context mContext;
    //Declaration of Array list.
    private ArrayList<Contacts> mArrayContacts;
    //Declaration of Layout inflater.
    private LayoutInflater mLayoutInflater;
    //Declaration of text view.
    private TextView mTextViewName;
    //Declaration of text view.
    private TextView mTextViewPhone;

    //Constructor.
    public ContactAdapter(Context context, int resource,ArrayList<Contacts> mArrayContacts) {
        super(context, resource);
        this.mContext = context;
        this.mArrayContacts = mArrayContacts;
        this.mLayoutInflater = mLayoutInflater.from(mContext);
    }

    //Getting the size of the array.
    @Override
    public int getCount() {
        return mArrayContacts.size();
    }

    //Getting the position of the array list.
    @Override
    public Object getItem(int position) {
        return mArrayContacts.get(position);
    }

    //Generating the custom view.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Checking if the convert view is null.
        if (convertView == null){

            //If the convert view is empty then the view will not be created.
            convertView = mLayoutInflater.inflate(R.layout.contact_list_item,parent,false);

        }

        //Initialisation of tex view.
        mTextViewName = (TextView) convertView.findViewById(R.id.contact_name);
        //Initialisation of tex view.
        mTextViewPhone = (TextView) convertView.findViewById(R.id.contact_no);

        //Creating the object of view and getting the position of the array.
        Contacts mContactat = (Contacts) getItem(position);

        //Setting the text for the textview.
        mTextViewName.setText(mContactat.strContactName);
        //Setting the text for the textview.
        mTextViewPhone.setText(mContactat.strContactNo);

        //Returning the convert view.
        return convertView;
    }
}

