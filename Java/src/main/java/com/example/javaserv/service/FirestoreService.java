package com.example.javaserv.service;
import com.example.javaserv.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirestoreService {
    Firestore db;

    @Autowired
    public FirestoreService(Firestore db) {
        this.db = db;
    }
    public void addUser(User user) {
        DocumentReference docRef = db.collection("users").document(user.getEmail());
        ApiFuture<WriteResult> result = docRef.set(user);
    }

    public User getUser(String email) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("users").document(email);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot doc = future.get();
        return doc.toObject(User.class);
    }
}
