package xyz.cybernerd404.madscalculator.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import xyz.cybernerd404.madscalculator.History
import xyz.cybernerd404.madscalculator.databinding.HistoryItemLayoutBinding


class HistoryAdapter() :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    var list: List<History> = arrayListOf()

    fun setHistory(response: List<History>) {
        this.list = response
        notifyItemChanged(list.size - 1)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HistoryItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.historyId.text = "${list[position].equation.toString()} => "
        holder.binding.history.text = list[position].ans
    }


    class ViewHolder(val binding: HistoryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

}