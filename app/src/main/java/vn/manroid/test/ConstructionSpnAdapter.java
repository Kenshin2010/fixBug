package vn.manroid.test;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ConstructionSpnAdapter extends RecyclerView.Adapter<ConstructionSpnAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<AppParamDTO> listAppParam;
    private AppParamDTO appParamDTO;

    public ConstructionSpnAdapter(Context context, List<AppParamDTO> listAppParam) {
        this.context = context;
        this.listAppParam = listAppParam;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ConstructionSpnAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_construction_spn, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        appParamDTO = listAppParam.get(position);
        holder.tvPostion.setText(position + 1 + ".");
        holder.tvName.setText(appParamDTO.getName());
        holder.tvNumber.setText(appParamDTO.getAmount() + "");
    }

    @Override
    public int getItemCount() {
        return listAppParam.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvPostion;
        private TextView tvNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvNumber = itemView.findViewById(R.id.tv_number_1);
            tvPostion = itemView.findViewById(R.id.tv_postion);
        }
    }

}
