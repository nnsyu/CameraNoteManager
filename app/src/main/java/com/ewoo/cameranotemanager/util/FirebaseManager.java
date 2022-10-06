package com.ewoo.cameranotemanager.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseManager {

    public static DatabaseReference mainRef = FirebaseDatabase.getInstance().getReference("OurPoem");
    public static DatabaseReference accountRef = mainRef.child("account");
    public static DatabaseReference poemRef = mainRef.child("poem");
}
