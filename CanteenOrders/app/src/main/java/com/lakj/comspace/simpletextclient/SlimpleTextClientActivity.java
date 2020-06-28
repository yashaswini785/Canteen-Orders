package com.lakj.comspace.simpletextclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.lakj.comspace.simpletextclient.finalize_order.messsage;
import static com.lakj.comspace.simpletextclient.finalize_order.printwriter;

/**
 * This is a simple Android mobile client
 * This application read any string massage typed on the text field and
 * send it to the server when the Send button is pressed
 * Author by Lak J Comspace
 */
public class SlimpleTextClientActivity extends Activity {


    /*
    private Socket client;
    private PrintWriter printwriter;
    private EditText textField;
    private Button button;
    private String messsage;
    */
    static String tbl_no;
    static String times;

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slimple_text_client);
    }
/*
  TextView textField = (EditText) findViewById(R.id.table_no); // reference to the text field
   Button   button = (Button) findViewById(R.id.button1); // reference to the send button

        // Button press event listener
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                messsage = textField.getText().toString(); // get the text message on the text field
                textField.setText(""); // Reset the text field to blank
                SendMessage sendMessageTask = new SendMessage();
                sendMessageTask.execute();
            }
        }
    }

    private class SendMessage extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {

                client = new Socket("192.168.1.149", 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                printwriter.write(messsage); // write the message to output stream
                printwriter.flush();
                printwriter.close();
                client.close(); // closing the connection
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.slimple_text_client, menu);
        return true;
    }*/

    public void nextact(View view) {

        EditText table = (EditText) findViewById(R.id.table_no);
        if (table.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),
                    "Please,enter your  name", Toast.LENGTH_SHORT).show();
        }
        EditText table1 = (EditText) findViewById(R.id.time);
        if (table1.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),
                    "Please,enter the time you pickup ur order", Toast.LENGTH_SHORT).show();
        } else {

            Editable newTxt = (Editable) table.getText();
            String tbl_no = newTxt.toString();
            Editable newTxt1 = (Editable) table1.getText();
            String times = newTxt1.toString();
            // get the text message on the text field
            //SendMessage sendMessageTask = new SendMessage();
            //sendMessageTask.execute();

            try {
                if (tbl_no != null && times != null) {


                    finalize_order.name = tbl_no.toString();
                    finalize_order.period = times.toString();
                    Intent intent = new Intent(this, canteen.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadin, R.anim.fadout);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please,enter your name and time ", Toast.LENGTH_SHORT).show();
                }
            }catch(Exception e)
            {

            }

        }

    }
}

