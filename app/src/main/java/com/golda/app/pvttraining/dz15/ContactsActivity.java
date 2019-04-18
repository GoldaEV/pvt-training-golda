package com.golda.app.pvttraining.dz15;

import android.Manifest;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.golda.app.pvttraining.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {
    private TextView vDisplayName;
    private TextView vFirstName;
    private TextView vMiddleName;
    private TextView vLastName;
    private ImageView iPhoto;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        vDisplayName = findViewById(R.id.displayName);
        vFirstName = findViewById(R.id.firstName);
        vMiddleName = findViewById(R.id.middleName);
        vLastName = findViewById(R.id.lastName);
        iPhoto = findViewById(R.id.photo);

        showContacts();
    }

    private void showContacts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            getContact();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showContacts();
            } else {
                Toast.makeText(this, "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void getContact() {
        Cursor cursor = App
                .getAppContext()
                .getContentResolver()
                .query(ContactsContract.Contacts.CONTENT_URI, null, null, null,
                        null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));

                // get firstName & lastName
                Cursor nameCur = App.getAppContext().getContentResolver()
                        .query(ContactsContract.Data.CONTENT_URI,
                                null,
                                ContactsContract.Data.MIMETYPE
                                        + " = ? AND "
                                        + ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID
                                        + " = ?",
                                new String[] {
                                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE,
                                        Long.valueOf(id).toString() }, null);
                if (nameCur != null) {
                    if (nameCur.moveToFirst()) {

                        String displayName = nameCur.getString(nameCur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        if (displayName == null) displayName = "";
                        vDisplayName.setText(displayName);

                        String firstName  = nameCur.getString(nameCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME));
                        if (firstName == null) firstName = "";
                        vFirstName.setText(firstName);

                        String middleName = nameCur.getString(nameCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.MIDDLE_NAME));
                        if (middleName == null) middleName = "";
                        vMiddleName.setText(middleName);

                        String lastName = nameCur.getString(nameCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME));
                        if (lastName == null) lastName = "";
                        lastName = middleName + (middleName.length()>0?" ":"") + lastName;
                        vLastName.setText(lastName);

                        Log.d("--> ", lastName);
                    }
                    nameCur.close();
                }

                Bitmap photo = null;

                try {
                    InputStream inputStream = ContactsContract.Contacts.openContactPhotoInputStream(App.getAppContext().getContentResolver(),
                            ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.valueOf(id)));

                    if (inputStream != null) {
                        photo = BitmapFactory.decodeStream(inputStream);
                    }

                    if (inputStream != null) inputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                iPhoto.setImageBitmap(photo);
            }
        }

        if (cursor != null) { cursor.close(); }
    }
}
