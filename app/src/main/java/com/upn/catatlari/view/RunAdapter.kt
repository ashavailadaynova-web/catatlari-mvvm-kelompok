package com.upn.catatlari.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upn.catatlari.databinding.ItemRunBinding
import com.upn.catatlari.model.Run
import com.upn.catatlari.viewmodel.RunViewModel

class RunAdapter(
    private val viewModel: RunViewModel,
    private val onEditClick: (Run) -> Unit // Callback khusus untuk tombol edit
) : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

    private var runList = mutableListOf<Run>()

    fun setData(runItems: List<Run>) {
        runList.clear()
        runList.addAll(runItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder =
        RunViewHolder(ItemRunBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        val currentItem = runList[position]
        holder.bind(currentItem)

        // Tombol Hapus
        holder.getBinding().btnDeleteRun.setOnClickListener {
            viewModel.deleteRun(currentItem)
        }

        // Tombol Edit
        holder.getBinding().btnEditRun.setOnClickListener {
            onEditClick(currentItem)
        }
    }

    override fun getItemCount(): Int = runList.size

    inner class RunViewHolder(private val binding: ItemRunBinding) : RecyclerView.ViewHolder(binding.root) {

        fun getBinding() = binding

        fun bind(run: Run) {
            binding.txtRunDate.text = run.runDate
            binding.txtRunDistance.text = "${run.runDistance} M"
            binding.txtRunDuration.text = "${run.runDuration} menit"
        }
    }
}