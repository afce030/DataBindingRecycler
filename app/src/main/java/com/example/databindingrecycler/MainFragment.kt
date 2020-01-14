package com.example.databindingrecycler


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingrecycler.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var adapterM: MessagesAdapter

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bindingUtil : FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        bindingUtil.lifecycleOwner = this
        val view = bindingUtil.root

        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        bindingUtil.mainViewModel = viewModel

        recycler = bindingUtil.rvMessages
        adapterM = MessagesAdapter(context!!)
        recycler.apply{
            adapter = adapterM
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        return view
    }

}
