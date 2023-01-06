package com.example.serenityhealth.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.serenityhealth.R;
import com.example.serenityhealth.ConsultationActivity;
import com.example.serenityhealth.models.ConsultationModel;

import java.util.ArrayList;


public class ConsultationAdapter extends RecyclerView.Adapter<ConsultationAdapter.MyViewHolder> {
    Context context;
    ArrayList<ConsultationModel> consultations;

    public ConsultationAdapter(Context context, ArrayList<ConsultationModel> consultations) {
        this.context = context;
        this.consultations = consultations;
    }

    @NonNull
    @Override
    public ConsultationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConsultationAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.consultation_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultationAdapter.MyViewHolder holder, int position) {
        holder.patientImage.setImageResource(consultations.get(position).getImage());
        holder.patientName.setText(consultations.get(position).getPatientId() + "");
        holder.date.setText(consultations.get(position).getDate().toString());
        holder.time.setText(consultations.get(position).getTime().toString());
        holder.proceedButton.setOnClickListener(view -> {
            context.startActivity(new Intent(context, ConsultationActivity.class));
        });
    }

    @Override
    public int getItemCount() {
        return consultations.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView patientImage;
        TextView patientName;
        TextView date;
        TextView time;
        Button proceedButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            patientImage = itemView.findViewById(R.id.patient_image);
            patientName = itemView.findViewById(R.id.patient_name);
            date = itemView.findViewById(R.id.consultation_date);
            time = itemView.findViewById(R.id.consultation_time);
            proceedButton = itemView.findViewById(R.id.proceed_consultation);
        }
    }
}
