package info.androidhive.firebase;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactUsActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText tvName, tvContactNo, tvEmail, tvMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        init();
        prepareActionBar();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvEmail.getText().toString().trim().length() > 0){
                    if(tvMessage.getText().toString().trim().length() > 0){
                        sendMail(tvEmail.getText().toString(), tvMessage.getText().toString() + "\n\n From :" + "\n\n" + "Name: " + tvName.getText().toString() + "\n Email: " + tvEmail.getText().toString() + "\n ContactNo: " + tvContactNo.getText().toString());
                    }else{
                        Toast.makeText(getApplicationContext(), "Please provide message", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Please provide email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void prepareActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Contact Us");
    }

    void init() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        tvName = (EditText) findViewById(R.id.tvName);
        tvContactNo = (EditText) findViewById(R.id.tvContactNo);
        tvEmail = (EditText) findViewById(R.id.tvEmail);
        tvMessage = (EditText) findViewById(R.id.tvMessage);
        btnSend = (Button) findViewById(R.id.btnSend);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    void sendMail(String email, String  message){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","krunal786u@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Enquiry Request");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }
}
