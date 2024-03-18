package com.example.javaserv.service;
import com.google.firebase.database.*;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {
    public void writeToDatabase(String path, Object data) {
        // TODO: Verify path
        DatabaseReference database = FirebaseDatabase.getInstance().getReference(path);
        String userId = database.push().getKey();
        System.out.println("writing");
        database.child(userId).setValueAsync(data);
        System.out.println("finished");
    }
}
