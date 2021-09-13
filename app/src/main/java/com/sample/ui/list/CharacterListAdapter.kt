package com.sample.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.sample.R
import com.sample.databinding.CharacterListItemBinding
import com.sample.model.Character
import com.sample.ui.common.DataBoundListAdapter

typealias OnItemClick = (character: Character) -> Unit

class CharacterListAdapter(
    private val dataBindingComponent: DataBindingComponent,
    private val onItemClick: OnItemClick
) : DataBoundListAdapter<Character, CharacterListItemBinding>(
    object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
            oldItem.name == newItem.name
                    && oldItem.origin == newItem.origin

    }) {

    override fun createBinding(parent: ViewGroup): CharacterListItemBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.character_list_item,
            parent,
            false,
            dataBindingComponent
        )

    override fun bind(binding: CharacterListItemBinding, item: Character) {
       binding.character = item
        binding.root.setOnClickListener{
            onItemClick(item)
        }
    }
}