package com.example.nishant.ngo.Volunteer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nishant.ngo.GlobalApplication;
import com.example.nishant.ngo.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

/**
 * Created by Nishant on 3/23/2019.
 */

public class SelfVolunteeringRegister extends Fragment {

    EditText registrationName,registrationEmail,registrationMobileno,registrationAge,registrationAddress;
    String strregistrationName,strregistrationEmail,strregistrationMobileno,strregistrationAge,strregistrationAddress;

    Spinner spinnerMF;
    String strspinnerMF;

    CheckBox registrationCheckBox;
    Button registrationVolunteeringButton;

    private StorageReference mStorageRef;
    private DatabaseReference VolunteerRegisterDatabase;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selfvolunteeringregister,container,false );
    //    Toast.makeText(GlobalApplication.getAppContext(),"Tab1",Toast.LENGTH_SHORT).show();
        VolunteerRegisterDatabase = FirebaseDatabase.getInstance().getReference("Volunteer Register");


        registrationName = (EditText) view.findViewById(R.id.registrationName);


        registrationEmail = (EditText) view.findViewById(R.id.registrationEmail);

        registrationMobileno = (EditText) view.findViewById(R.id.registrationMobileno);

        registrationAge = (EditText) view.findViewById(R.id.registrationAge);

        registrationAddress = (EditText) view.findViewById(R.id.registrationAddress);

        spinnerMF = (Spinner) view.findViewById(R.id.spinnerMF);

        registrationCheckBox = (CheckBox) view.findViewById(R.id.registrationCheckBox);

        registrationVolunteeringButton = (Button) view.findViewById(R.id.registrationVolunteeringButton);



        registrationVolunteeringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( (registrationName.getText().toString() != "") && (registrationEmail.getText().toString() != "") && (registrationMobileno.getText().toString() != "") && (registrationAge.getText().toString() != "") && (registrationAddress.getText().toString() != " ") && (spinnerMF.getSelectedItem().toString()!= "") )
                {
                    strregistrationName = registrationName.getText().toString().trim();

                    strregistrationEmail = registrationEmail.getText().toString().trim();
                    strregistrationMobileno = registrationMobileno.getText().toString().trim();
                    strregistrationAge= registrationAge.getText().toString().trim();
                    strregistrationAddress= registrationAddress.getText().toString().trim();
                    strspinnerMF=spinnerMF.getSelectedItem().toString();

                    Toast.makeText(getContext(),"Registration Sucessfull",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getContext(),"FIll All details",Toast.LENGTH_LONG).show();
                }





                String Volunteerid = VolunteerRegisterDatabase.push().getKey();

                VolunteerGetterSetter volunteerGetterSetter=new VolunteerGetterSetter(Volunteerid,strregistrationName,strregistrationEmail,strregistrationMobileno,strregistrationAge,strregistrationAddress,strspinnerMF);

                VolunteerRegisterDatabase.child(Volunteerid).setValue(volunteerGetterSetter);


            }
        });





        return view;
    }
}
