package com.example.ruangkelas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AssigmentActivity extends RecyclerView.Adapter<AssigmentActivity.ViewHolder> {

    private static final String TAG = "ListView";
    private ArrayList<String> NamaPemain = new ArrayList<>();
    private ArrayList<String> PosisiPemain = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> DetailPemain = new ArrayList<>();
    private ArrayList<String> NoPemain = new ArrayList<>();
    private ArrayList<String> UmurPemain = new ArrayList<>();
    private ArrayList<String> WargaNegaraPemain = new ArrayList<>();
    private Context context;

    public AssigmentActivity(Context context, ArrayList<String> NamaPemain, ArrayList<String> LinkGambar, ArrayList<String> PosisiPemain, ArrayList<String> DetailPemain, ArrayList<String> NoPemain, ArrayList<String> UmurPemain, ArrayList<String> WargaNegaraPemain){
        this.NamaPemain = NamaPemain;
        this.LinkGambar = LinkGambar;
        this.PosisiPemain = PosisiPemain;
        this.DetailPemain = DetailPemain;
        this.NoPemain = NoPemain;
        this.UmurPemain = UmurPemain;
        this.WargaNegaraPemain = WargaNegaraPemain;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        Log.d(TAG,"onBindViewHolder: called.");

        Glide.with(context)
                .asBitmap()
                .load(LinkGambar.get(i))
                .into(holder.gambarList);
        holder.namaPemainList.setText(NamaPemain.get(i));
        holder.posisiPemainList.setText(PosisiPemain.get(i));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on: "+ NamaPemain.get(i));
                Toast.makeText(context, "Detail "+NamaPemain.get(i),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DetailAssigmentActivity.class);
                intent.putExtra("link",LinkGambar.get(i));
                intent.putExtra("nama",NamaPemain.get(i));
                intent.putExtra("posisi",PosisiPemain.get(i));
                intent.putExtra("umur",UmurPemain.get(i));
                intent.putExtra("warganegara",WargaNegaraPemain.get(i));
                intent.putExtra("no",NoPemain.get(i));
                intent.putExtra("detail",DetailPemain.get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NamaPemain.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView gambarList;
        TextView namaPemainList;
        TextView posisiPemainList;
        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarList = itemView.findViewById(R.id.imageList);
            namaPemainList = itemView.findViewById(R.id.namaPemainList);
            posisiPemainList = itemView.findViewById(R.id.posisiPemainList);
            parentLayout = itemView.findViewById(R.id.list);
        }
    }
}