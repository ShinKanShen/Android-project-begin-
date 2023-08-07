package com.example.noteapp;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class toastmess {
    static  void showtoast(Context context, String mess){
        Toast.makeText(context,mess,Toast.LENGTH_SHORT).show();
    }

    static CollectionReference getcollectionReferenceForNotes(){
        FirebaseUser currentUser= FirebaseAuth.getInstance().getCurrentUser();
         return FirebaseFirestore.getInstance().collection("notes")
                .document(currentUser.getUid()).collection("My_notes");
    }

    static  String timestampstring(Timestamp timestamp){
       return new SimpleDateFormat("MM//dd/yyyy").format(timestamp.toDate());
    }
}
