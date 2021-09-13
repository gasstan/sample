package com.sample.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sample.R
import com.sample.dataBinding.FragmentDataBindingComponent
import com.sample.databinding.FragmentDetailBinding
import com.sample.utils.autoCleared

class DetailFragment : Fragment() {

    val args: DetailFragmentArgs by navArgs()
    private var binding by autoCleared<FragmentDetailBinding>()

    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false,
            dataBindingComponent
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.character = args.character
    }

}