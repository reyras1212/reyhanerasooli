package com.example.falhafez;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adaptershaer extends RecyclerView.Adapter<Adaptershaer.MyViewHolder>{

private Context mcontext;
private List<poets> poetlist;


    public Adaptershaer(Context mcontext, List<poets> poetlist) {
        this.mcontext = mcontext;
        this.poetlist = poetlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewtype) {
        View v;
        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        v=layoutInflater.inflate(R.layout.list_item,parent,false);
        return  new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


     holder.name.setText(poetlist.get(position).getName());
     holder.birth.setText(poetlist.get(position).getBirthYearInLHijri());
     holder.death.setText(poetlist.get(position).getDeathYearInLHijri());
     holder.birthplace.setText(poetlist.get(position).getBirthPlace());



    }

    @Override
    public int getItemCount() {
        return poetlist.size();
    }

    public static class  MyViewHolder extends RecyclerView.ViewHolder{
           TextView name;
        TextView birth;
        TextView death;
        TextView birthplace;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txtname);
            birth=itemView.findViewById(R.id.txtbirth);
            death=itemView.findViewById(R.id.txtdeath);
            birthplace=itemView.findViewById(R.id.txtbirthplace);


        }
    }

}
