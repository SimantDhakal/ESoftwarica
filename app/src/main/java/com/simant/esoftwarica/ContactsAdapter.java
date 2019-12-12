package com.simant.esoftwarica;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>{

    Context mContext;
    List<Contacts> contactsList;

    public ContactsAdapter(Context mContext, List<Contacts> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_user,parent,false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, final int position) {
        final Contacts contacts = contactsList.get(position);

        Picasso.get()
                .load(contacts.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .resize(180, 180)
                .centerCrop()
                .into(holder.imgProfile);

        holder.tbName.setText(contacts.getName());
        holder.tvRoll.setText(contacts.getRoll());
        holder.tvAddress.setText(contacts.getAddress());
        holder.tvGender.setText(contacts.getGender());

        holder.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the clicked item label
                String itemLabel = String.valueOf(contactsList.get(position));
                contactsList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,contactsList.size());
                Toast.makeText(mContext,"Removed : " + itemLabel,Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("name", contacts.getName());
                intent.putExtra("phone", contacts.getAddress());
                intent.putExtra("profile", contacts.getImage());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();

    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imgProfile;
        ImageView deleteIcon;
        TextView tbName, tvRoll, tvAddress, tvGender;
        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);

//            imgProfile = itemView.findViewById(R.id.imageView);
//            deleteIcon = itemView.findViewById(R.id.imageView4);
//            tbName = itemView.findViewById(R.id.textView);
//            tvRoll = itemView.findViewById(R.id.textView2);
//            tvAddress = itemView.findViewById(R.id.textView3);
//            tvGender = itemView.findViewById(R.id.textView4);

        }

    }

}
