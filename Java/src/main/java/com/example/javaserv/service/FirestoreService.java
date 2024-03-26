package com.example.javaserv.service;
import com.example.javaserv.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirestoreService {

    Firestore db = FirestoreClient.getFirestore();
    public void addUser(User user) {
        // TODO: Verify path
        DocumentReference docRef = db.collection("users").document(user.getEmail());
    }

    public User getUser(String email) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("users").document(email);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot doc = future.get();
        return doc.toObject(User.class);
    }
}
