package com.grack.rapalll.linuxanry.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.grack.rapalll.linuxanry.DetailLinuxActivity;
import com.grack.rapalll.linuxanry.R;
import com.grack.rapalll.linuxanry.model.ModelLinux;

import java.util.List;

public class AdapterPengertian extends RecyclerView.Adapter<AdapterPengertian.linuxHolder>{

    private List<ModelLinux> modelLinuxList;
    private Context context;

    public AdapterPengertian(List<ModelLinux> namaPerintah, Context context){
        this.modelLinuxList = namaPerintah;
        this.context = context;
    }


    @NonNull
    @Override
    public linuxHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_pengertian, parent, false);
        return new linuxHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final linuxHolder holder, final int position) {
        final ModelLinux modelLinux = modelLinuxList.get(position);

        holder.namaPerintah.setText(modelLinux.getNamaPerintah());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelLinux linux = modelLinuxList.get(position);
                Intent intent = new Intent(holder.itemView.getContext(), DetailLinuxActivity.class);
                intent.putExtra("detail", new GsonBuilder().create().toJson(linux));
                holder.itemView.getContext().startActivity(intent);

                Toast.makeText(context, "Masuk Gan", Toast.LENGTH_SHORT).show();
            }
        });
//
    }

    @Override
    public int getItemCount() {
        return modelLinuxList.size();
    }

    class linuxHolder extends RecyclerView.ViewHolder{
        private TextView namaPerintah;
        private TextView mpenjelasan;
        private TextView istilah;

        public linuxHolder(@NonNull View itemView) {
            super(itemView);
            namaPerintah = (TextView) itemView.findViewById(R.id.tv_perintah);
            mpenjelasan = (TextView) itemView.findViewById(R.id.tv_penjelasan);
            istilah = (TextView) itemView.findViewById(R.id.tv_istilah);
        }
    }
}



//
//class linuxHolder extends RecyclerView.ViewHolder{
//    private TextView tvperintah;
//
//    public linuxHolder(View itemView) {
//        super(itemView);
//        tvperintah = (TextView) itemView.findViewById(R.id.tv_perintah);
//    }
//}
//

