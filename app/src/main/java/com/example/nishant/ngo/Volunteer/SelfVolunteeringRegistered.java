package com.example.nishant.ngo.Volunteer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nishant.ngo.GlobalApplication;
import com.example.nishant.ngo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nishant on 3/23/2019.
 */


public class SelfVolunteeringRegistered extends Fragment {

    EditText registrationName,registrationEmail,registrationMobileno,registrationAge,registrationAddress;
    String strregistrationName,strregistrationEmail,strregistrationMobileno,strregistrationAge,strregistrationAddress;

    Spinner spinnerMF;
    String strspinnerMF;
    VolunteerGetterSetter user;
Button btn1;
    CheckBox registrationCheckBox;
    Button registrationVolunteeringButton;

    private StorageReference mStorageRef;
    private DatabaseReference VolunteerRegisterDatabase;


    ListView listview;

    List<VolunteerGetterSetter> vgslist;

    /* My created Varibale */
    RecyclerView recyclerViewUsers;

    ArrayList listUsers;

    UsersRecyclerAdapter usersRecyclerAdapter;

    ListView userListView;

    FirebaseAuth firebaseAuth;
    String VolunteerID;
    String volunteerid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selfvounteeringregistered,container,false);
    //    Toast.makeText(GlobalApplication.getAppContext(),"Tab2",Toast.LENGTH_SHORT).show();
        VolunteerRegisterDatabase = FirebaseDatabase.getInstance().getReference("/Volunteer Register");
btn1=(Button)view.findViewById(R.id.btn);


        registrationName = (EditText) view.findViewById(R.id.registrationName);

        registrationEmail = (EditText) view.findViewById(R.id.registrationEmail);

        registrationMobileno = (EditText) view.findViewById(R.id.registrationMobileno);

        registrationAge = (EditText) view.findViewById(R.id.registrationAge);

        registrationAddress = (EditText) view.findViewById(R.id.registrationAddress);

        spinnerMF = (Spinner) view.findViewById(R.id.spinnerMF);

        registrationCheckBox = (CheckBox) view.findViewById(R.id.registrationCheckBox);

        registrationVolunteeringButton = (Button) view.findViewById(R.id.registrationVolunteeringButton);

        listview = (ListView) view.findViewById(R.id.userlistview);

        vgslist = new ArrayList<>();

        /*
       VolunteerID = VolunteerRegisterDatabase.push().getKey();

        VolunteerGetterSetter volunteerGetterSetter=new VolunteerGetterSetter(VolunteerID,strregistrationName,strregistrationEmail,strregistrationMobileno,strregistrationAge,strregistrationAddress,strspinnerMF);

        VolunteerRegisterDatabase.child(VolunteerID).setValue(volunteerGetterSetter);
*/




        recyclerViewUsers = (RecyclerView) view.findViewById(R.id.recyclerViewUsers);



        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(listUsers);
        Context context = GlobalApplication.getAppContext();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(usersRecyclerAdapter);

        //   userlistReference = FirebaseDatabase.getInstance().getReference().child("");
        onStart();
        userListView = (ListView) view.findViewById(R.id.userlistview);


btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        testRecycler();
    }
});




        return view;
    }
    void testRecycler()
    {

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


        //DatabaseReference myRef = firebaseDatabase.getReference("/Volunteer Register");

        FirebaseDatabase.getInstance().getReference("/Volunteer Register")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            // UserProfile user = snapshot.getValue(UserProfile.class);

                            //     System.out.println(user.getAddress());
//                            usernamelist = new ArrayList<>((ArrayList) snapshot.getValue());
//                            arrayAdapter = new ArrayAdapter(StudentViewActivity.this, android.R.layout.simple_list_item_1, usernamelist);
//                            userListView.setAdapter(arrayAdapter);

                            // ArrayList<String> list = new ArrayList<String>();
                            ArrayList<String> list = new ArrayList<String>();
                            if(snapshot.child("strregistrationName")!=null && snapshot.child("strregistrationEmail")!=null ) {
                                list.add("Name: " + snapshot.child("strregistrationName").toString());
                                list.add("Email " + snapshot.child("strregistrationEmail").toString());
                            }


                            String name,email,pass;
                            String address,phno,sclass,dateofadmission,gender,dob,key;
                            if(snapshot.child("strregistrationName").getValue()!=null&&snapshot.child("strregistrationEmail").getValue()!=null && snapshot.child("strregistrationMobileno").getValue()!=null && snapshot.child("strregistrationAge").getValue()!=null&&snapshot.child("strregistrationAddress").getValue()!=null && snapshot.child("spinnerMF").getValue()!=null&&snapshot.child("volunteerID").getValue()!=null) {
                                name = snapshot.child("strregistrationName").getValue().toString();
                                strregistrationEmail = snapshot.child("strregistrationEmail").getValue().toString();
                                strregistrationMobileno = snapshot.child("strregistrationMobileno").getValue().toString();
                                strregistrationAge= snapshot.child("strregistrationAge").getValue().toString();
                                strregistrationAddress= snapshot.child("strregistrationAddress").getValue().toString();
                                strspinnerMF=snapshot.child("spinnerMF").getValue().toString();
                                volunteerid = snapshot.child("volunteerID").getValue().toString();
                                 user= new VolunteerGetterSetter(volunteerid,name,strregistrationEmail, strregistrationMobileno,  strregistrationAge,  strregistrationAddress, strspinnerMF);
                            }
                            else
                            {
                                /*
                                name="null";
                                email="null";
                                strregistrationMobileno = "null";
                                strregistrationAge= "null";
                                strregistrationAddress= "null";
                                strspinnerMF="null";
                                volunteerid="null";*/
                            }
//

                            /*VolunteerGetterSetter user= new VolunteerGetterSetter(volunteerid,strregistrationName,strregistrationEmail, strregistrationMobileno,  strregistrationAge,  strregistrationAddress, strspinnerMF);*/
                            //  VolunteerGetterSetter user= dataSnapshot.getValue(VolunteerGetterSetter.class);

                            if(user!=null)
                            {
                                listUsers.add(user);
                                Toast.makeText(GlobalApplication.getAppContext(),"User View details added",Toast.LENGTH_SHORT).show();
                            }
                            usersRecyclerAdapter.notifyDataSetChanged();
                            //rrayAdapter = new ArrayAdapter(StudentViewActivity.this, android.R.layout.simple_list_item_1, list);
                            //userListView.setAdapter(arrayAdapter);
                            Log.d("item id",snapshot.getValue().toString());
                            Log.d("item id",snapshot.child("spinnerMF").toString());
                            //       Log.d("item id",snapshot.child("strregistrationName").getValue().toString());


                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

    }



}
