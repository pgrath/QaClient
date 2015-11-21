package com.example.halper.qaclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CommunicateActivity extends AppCompatActivity {

    public static Socket socket = null;
    public static PrintWriter out = null;
    public static Scanner in = null;
    public static TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate);

        int port;
        String hostname;

        // Get the hostname from the intent

        Intent intent = getIntent();
        hostname = intent.getStringExtra(MainActivity.HOST_NAME);

        // Get the port from the intent.  Default port is 4000

        port = intent.getIntExtra(MainActivity.PORT, 4000);

        // get a handle on the TextView for displaying the status

        tv = (TextView) findViewById(R.id.text_answer);

        // Try to open the connection to the server

        try
        {
            socket = new Socket(hostname, port);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(new InputStreamReader(socket.getInputStream()));

            tv.setText("Connected to server.");
        }
        catch (IOException e)  // socket problems
        {
            tv.setText("Problem: " + e.toString());
            socket = null;
        }

    } // end onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_communicate, menu);
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

    public void sendQuestion(View view)
    {
        EditText et;
        String user_question;
        String answer;
        boolean finished = false;

        // are we connected?

        if(socket == null)
        {
            tv.setText("Not connected.");
        }

        else
        {// get the question to send to the server (place it in "user_question")

            YYY

            // if string is "quit", we're finished (let the
            // server know by sending it "quit".).  Otherwise, send the question
            // and get a response

            if ( YYY )
            {
                YYY (two statements here)
            }

            else
            {
                // send question to server

                YYY

                // read response and display it

                 YYY

                tv.setText("Answer: " + answer);

            }

            // if we're finished, close the connection

            if(finished)
            {
                try
                {
                    out.close();
                    in.close();
                    socket.close();

                    tv.setText("Finished.  Connection closed.");
                }
                catch (IOException e)  // socket problems
                {
                    tv.setText("Problem: " + e.toString());
                }

            }

        }

    } // end sendQuestion

} // end CommunicateActivity
