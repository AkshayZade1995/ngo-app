package com.example.nishant.ngo.Volunteer;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.nishant.ngo.GlobalApplication;
import com.example.nishant.ngo.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> {
    FirebaseAuth firebaseAuth;
    private List<VolunteerGetterSetter> listUsers;

    public UsersRecyclerAdapter(List<VolunteerGetterSetter> listUsers) {
        this.listUsers = listUsers;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(GlobalApplication.getAppContext())
                .inflate(R.layout.item_user_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
    //    Toast.makeText(GlobalApplication.getAppContext(),listUsers.get(position).getStrregistrationName(),Toast.LENGTH_SHORT).show();
        holder.textViewName.setText(listUsers.get(position).getStrregistrationName().toString());
        holder.textViewEmail.setText(listUsers.get(position).getStrregistrationEmail());
        holder.textViewspinnerMF.setText(listUsers.get(position).getSpinnerMF());
        holder.textViewstrregistrationAddress.setText(listUsers.get(position).getStrregistrationAddress());
        holder.textViewstrregistrationAge.setText(listUsers.get(position).getStrregistrationAge());
        holder.textViewstrregistrationMobileno.setText(listUsers.get(position).getStrregistrationMobileno());
        holder.volunteerID.setText(listUsers.get(position).getVolunteerID());

    }

    @Override
    public int getItemCount() {
        Log.v(UsersRecyclerAdapter.class.getSimpleName(), "" + listUsers.size());
        return listUsers.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewspinnerMF;
        public AppCompatTextView textViewstrregistrationAddress;
        public AppCompatTextView textViewstrregistrationAge;
        public AppCompatTextView textViewstrregistrationMobileno;
        public AppCompatTextView volunteerID;

        public ImageButton imageButton;

        public UserViewHolder(View view) {
            super(view);

            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
            textViewspinnerMF=(AppCompatTextView) view.findViewById(R.id.textViewspinnerMF);
            textViewstrregistrationAddress=(AppCompatTextView) view.findViewById(R.id.strregistrationAddress);
            textViewstrregistrationAge=(AppCompatTextView) view.findViewById(R.id.strregistrationAge);
            textViewstrregistrationMobileno=(AppCompatTextView) view.findViewById(R.id.strregistrationMobileno);
            volunteerID=(AppCompatTextView) view.findViewById(R.id.textViewvolunteerID);
        }
    }
}
