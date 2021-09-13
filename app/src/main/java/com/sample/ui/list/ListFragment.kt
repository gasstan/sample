package com.sample.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.R
import com.sample.dataBinding.FragmentDataBindingComponent
import com.sample.databinding.FragmentListBinding
import com.sample.ui.MainViewModel
import com.sample.utils.autoCleared

class ListFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private var binding by autoCleared<FragmentListBinding>()
    private var adapter by autoCleared<CharacterListAdapter>()

    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false,
            dataBindingComponent
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CharacterListAdapter(dataBindingComponent) {
            val action = ListFragmentDirections.detailFragmentAction(it)
            findNavController().navigate(action)
        }

        binding.run {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        }

        viewModel.getCharacters().observe(viewLifecycleOwner, {
            Log.e("RESULT", it.size.toString())
            adapter.submitList(it)
        })
    }
}