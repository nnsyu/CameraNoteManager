package com.ewoo.cameranotemanager.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseManager {

    public static DatabaseReference mainRef = FirebaseDatabase.getInstance().getReference("camnote");
    public static DatabaseReference passwordRef = mainRef.child("password");
    public static DatabaseReference adminKeyRef = mainRef.child("adminkey");
}
