package com.example.noteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

public class NoteDetailsActivity extends AppCompatActivity {

    EditText edit_tile,edit_content;
    ImageButton save_note;
    TextView pageTitleView;
    String title,content,docId;
    boolean editMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        edit_tile=findViewById(R.id.title_note);
        edit_content=findViewById(R.id.content_note);
        save_note=findViewById(R.id.save_note_add);


        // receive data

        pageTitleView=findViewById(R.id.page_title);
        title=getIntent().getStringExtra("title"); // vi su kien onclik onbinding trong noteadapter nha chú ý còn cần nhiều thứ phải hóc quá nhiều nên cố hắng vậy
        content=getIntent().getStringExtra("content");
        docId=getIntent().getStringExtra("docid");

        edit_tile.setText(title);
        edit_content.setText(content);
        if(docId!=null && !docId.isEmpty()) editMode=true;
        if(editMode) pageTitleView.setText("Edit your note");
        save_note.setOnClickListener(v->setnote());
    }

    private void setnote() {

        String title=String.valueOf(edit_tile.getText());
        String content=String.valueOf(edit_content.getText());

        if(title==null||title.isEmpty()){
            edit_tile.setError("Title is required");
            return;
        }

        Note note=new Note();
        note.setContent(content);
        note.setTitle(title);
        note.setTimestamp(Timestamp.now());
        saveNoteFireBase(note);


    }

    private void saveNoteFireBase(Note note) {
        DocumentReference documentReference;

        if(editMode){
            // update the note
            documentReference=toastmess.getcollectionReferenceForNotes().document(docId);

        }else {
            // create new note
            documentReference=toastmess.getcollectionReferenceForNotes().document();

        }
        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    toastmess.showtoast(NoteDetailsActivity.this,"Add note is Successfully");
                    finish();
                }
                else{
                    toastmess.showtoast(NoteDetailsActivity.this,"Falednwhile adding note");

                }
            }
        });

    }
}