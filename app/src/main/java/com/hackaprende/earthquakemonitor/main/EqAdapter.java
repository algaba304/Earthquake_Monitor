package com.hackaprende.earthquakemonitor.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.hackaprende.earthquakemonitor.Earthquake;
import com.hackaprende.earthquakemonitor.UsuarioDTO;
import com.hackaprende.earthquakemonitor.databinding.EqListItemBinding;

class EqAdapter extends ListAdapter<UsuarioDTO, EqAdapter.EqViewHolder> {

    public static final DiffUtil.ItemCallback<UsuarioDTO> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<UsuarioDTO>() {
                @Override
                public boolean areItemsTheSame(@NonNull UsuarioDTO oldItem, @NonNull UsuarioDTO newItem) {
                    return oldItem.getIdUsuario().equals(newItem.getIdUsuario());
                }

                @Override
                public boolean areContentsTheSame(@NonNull UsuarioDTO oldItem, @NonNull UsuarioDTO newItem) {
                    return oldItem.equals(newItem);
                }
            };

    protected EqAdapter() {
        super(DIFF_CALLBACK);
    }

    private OnItemClickListener onItemClickListener;

    interface OnItemClickListener {
        void onItemClick(UsuarioDTO earthquake);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public EqAdapter.EqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EqListItemBinding binding = EqListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new EqViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EqAdapter.EqViewHolder holder, int position) {
        UsuarioDTO earthquake = getItem(position);

        holder.bind(earthquake);
    }

    class EqViewHolder extends RecyclerView.ViewHolder {

        private final EqListItemBinding binding;

        public EqViewHolder(@NonNull EqListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UsuarioDTO earthquake) {
            binding.magnitudeText.setText(earthquake.getNombreUsuaio());
            binding.placeText.setText(earthquake.getCorreoEelectronico());

            binding.getRoot().setOnClickListener( v -> {
                onItemClickListener.onItemClick(earthquake);
            });

            binding.executePendingBindings();
        }
    }
}
