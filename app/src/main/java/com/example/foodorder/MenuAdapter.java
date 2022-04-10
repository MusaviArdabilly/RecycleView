package com.example.foodorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Context context;
    private static ArrayList<MenuModel> menuList;

    public MenuAdapter(Context context, ArrayList<MenuModel> menuList){
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuModel menuModel = menuList.get(position);
        holder.setDetail(menuModel);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama, tvDetail,tvHarga;
        private ImageView btnDelete;
        private MenuAdapter adapter;

        public MenuViewHolder(@NonNull View itemView){
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDetail = itemView.findViewById(R.id.tv_detail);
            tvHarga = itemView.findViewById(R.id.tv_harga);
            btnDelete = itemView.findViewById(R.id.btn_delete);

            btnDelete.setOnClickListener(view -> {
                adapter.menuList.remove(getAdapterPosition());
                adapter.notifyItemRemoved(getAdapterPosition());
            });
        }

        public void setDetail(MenuModel menuModel){
            tvNama.setText(menuModel.getNama());
            tvDetail.setText(menuModel.getDetail());
            tvHarga.setText(String.format("Rp. %s", menuModel.getHarga()));
        }

        public MenuViewHolder linkAdapter(MenuAdapter adapter){
            this.adapter = adapter;
            return this;
        }
    }
}

