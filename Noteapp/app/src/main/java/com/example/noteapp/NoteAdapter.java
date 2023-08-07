package com.example.noteapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.nio.file.attribute.FileTime;

public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.NoteViewHolder> {

    Context context;


    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options,Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Note note) {

        holder.titletext.setText(note.title);
        holder.contenttext.setText(note.content);
        holder.timestamptext.setText(toastmess.timestampstring(note.timestamp));

        holder.itemView.setOnClickListener(v->{
            Intent intent= new Intent(context,NoteDetailsActivity.class);
            intent.putExtra("title",note.title);
            intent.putExtra("content",note.content);
            String docid=this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docid",docid);
            context.startActivity(intent);

        });

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_notes_items,parent,false);
        return new NoteViewHolder(view);
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        TextView contenttext, titletext, timestamptext;


        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titletext= itemView.findViewById(R.id.note_title_text_view);
            contenttext=itemView.findViewById(R.id.note_content_text_view);
            timestamptext=itemView.findViewById(R.id.note_timestamp_text_view);

        }
    }
}
