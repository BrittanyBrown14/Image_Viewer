package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.LinkedList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    Button next_btn;
    Button prev_btn;

    ImageView imageView;


    LinkedList<Integer> linkedList = new LinkedList<>();
    ListIterator<Integer> itr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next_btn = findViewById(R.id.next_Btn);
        prev_btn = findViewById(R.id.previous_Btn);

        imageView = findViewById(R.id.imageView);

        linkedList.add(0, R.drawable.wallpaper0);
        linkedList.add(1, R.drawable.wallpaper1);
        linkedList.add(2, R.drawable.wallpaper2);
        linkedList.add(3, R.drawable.wallpaper3);

        imageView.setImageResource(linkedList.get(0));

        itr = linkedList.listIterator(0);
    }

    public void ChangeImageF(View view)
    {
        try
        {
            if(itr.hasNext())
            {
                imageView.setImageResource(itr.next());
            }
            else
            {
                itr = linkedList.listIterator(0);
                imageView.setImageResource(itr.next());
            }
        }
        catch (Exception exception)
        {
            // setup the alert builder
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("It's Broken");
            builder.setMessage(exception.toString());

            // add a button
            builder.setPositiveButton("OK", null);

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    public void ChangeImageB(View view)
    {
        try
        {
            if(itr.hasPrevious())
            {
                imageView.setImageResource(itr.previous());
            }
            else
            {
                itr = linkedList.listIterator(3);
                imageView.setImageResource(itr.previous());
            }
        }
        catch (Exception exception)
        {
            // setup the alert builder
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("It's Broken");
            builder.setMessage(exception.toString());

            // add a button
            builder.setPositiveButton("OK", null);

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}