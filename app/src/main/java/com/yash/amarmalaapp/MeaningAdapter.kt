package com.yash.amarmalaapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yash.amarmalaapp.databinding.MeaningRecyclerRowBinding

class MeaningAdapter(private var meaningList: List<Meaning>) : RecyclerView.Adapter<MeaningAdapter.MeaningViewHolder>(){

    class MeaningViewHolder(private val binding: MeaningRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(meaning: Meaning){
            //binding meanings
            binding.partOfSpeechTv.text = meaning.partOfSpeech
            binding.definationsTv.text = meaning.definitions.joinToString("\n\n") {
                it.definition.toString()
            }
        }
    }

    fun updateNewData(newMeaningList: List<Meaning>){
        meaningList = newMeaningList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder {
       val binding = MeaningRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MeaningViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return meaningList.size
    }

    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        holder.bind(meaningList[position])
    }

}