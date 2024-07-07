package com.example.alkyeassignment.adapters

import android.os.Build
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.TypefaceSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeassignment.R
import com.example.alkyeassignment.databinding.ItemRvMiddleBinding

class MiddleAdapter(
    private val count: Int = 0
) : RecyclerView.Adapter<MiddleAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvMiddleBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = count

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    class ViewHolder(private val binding: ItemRvMiddleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind() {
            if (adapterPosition != 0)
                binding.bookImg.visibility = View.GONE
            else
                binding.bookImg.visibility = View.VISIBLE
            val text =
                "Step Into Tomorrow: Exploring Spatial Computing’s Impact On Industries And The Metaverse!"
            val fontLater = binding.root.context.resources.getFont(R.font.strawford_medium)
            val spannedText = SpannableStringBuilder(text)
            spannedText.setSpan(
                TypefaceSpan(fontLater),
                "Step Into Tomorrow:".length,
                text.length - 1,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.tvDescription.text = spannedText

        }
    }
}