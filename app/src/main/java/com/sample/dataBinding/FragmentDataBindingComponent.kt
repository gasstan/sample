package com.sample.dataBinding

import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment

/**
 * A Data Binding Component implementation for fragments.
 */
class FragmentDataBindingComponent() : DataBindingComponent {
    private val adapter = FragmentBindingAdapters()

    override fun getFragmentBindingAdapters() = adapter
}
