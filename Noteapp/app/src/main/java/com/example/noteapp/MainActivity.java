package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton btn_add_note;
    RecyclerView list_note;

    ImageButton imgMenu;


    NoteAdapter noteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add_note=findViewById(R.id.add_note_btn);
        list_note=findViewById(R.id.list_note_view);
        imgMenu=findViewById(R.id.menu_note);



        btn_add_note.setOnClickListener(v-> startActivity(
                new Intent(MainActivity.this, NoteDetailsActivity.class)));
        imgMenu.setOnClickListener(v-> showMenu());
        setupRecyleView();
    }

    private void setupRecyleView() {
        Query query = toastmess.getcollectionReferenceForNotes().orderBy("timestamp",Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Note> option=new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query,Note.class).build();

        list_note.setLayoutManager(new LinearLayoutManager(this));
        noteAdapter = new NoteAdapter(option,this);
        list_note.setAdapter(noteAdapter);

    }
    protected void onStart(){
        super.onStart();
        noteAdapter.startListening();
    }
    protected void onStop(){
        super.onStop();
        noteAdapter.stopListening();

    }
    protected void onResume(){
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }


    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, imgMenu);
        popupMenu.getMenu().add("Logout");
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if(menuItem.getTitle()=="Logout"){
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, LoginAccount.class));
                    finish();
                    return true;
                }
                return false;
            }
        });


    }
}