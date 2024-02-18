package com.csv.comscivision.serviceimpl;

import com.csv.comscivision.entity.Users;
import com.csv.comscivision.service.CSVService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CSVServiceImpl implements CSVService
{
    @Override
    public String createUserDetail(Users users) throws ExecutionException, InterruptedException
    {
        Firestore firestoreDb = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = firestoreDb.collection("users").document(users.getId()).create(users);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public List<Users> getUserDetail() throws ExecutionException, InterruptedException
    {
//        Firestore firestoreDb = FirestoreClient.getFirestore();
//        DocumentReference documentReference =firestoreDb.collection("users").document();
//        ApiFuture<DocumentSnapshot> future = documentReference.get();
//        DocumentSnapshot documentSnapshot = future.get();
//        List<Users> users;
//        if(documentSnapshot.exists()){
//            users=documentSnapshot.toObject(ArrayList.class);
//            return users;
//        }
        Firestore firestoreDb = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future =firestoreDb.collection("users").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Users> users = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            users.add(document.toObject(Users.class));
        }
        return users;
    }

}
