package com.example.android2finalproject.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android2finalproject.databinding.FragmentHomeBinding
import com.example.android2finalproject.service.usecase.GetWeatherInfoUseCase
import com.example.android2finalproject.ui.adapter.WeatherAdapter
import com.example.android2finalproject.ui.viewmodel.MainActivityViewModel
import com.example.android2finalproject.ui.viewmodel.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

//    var modelFactory: ViewModelFactory = ViewModelFactory(
//        getWeatherInfoCase = GetWeatherInfoUseCase(),
////        getWeatherInfoHistoryCase =
//    )

//    private val model: MainActivityViewModel by lazy {
//        ViewModelProvider(this, modelFactory)[MainActivityViewModel::class.java]
//    }

//    private val model = MainActivityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val weatherList = listOf(model.historyWeatherInfos)

        val recyclerView: RecyclerView = binding.rcView
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = WeatherAdapter(this, weatherList)
        recyclerView.adapter = adapter

        binding.otherInputEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                hideKeyboard(view)
                true } else { false} }
        binding.imageButton.setOnClickListener {
            hideKeyboard(it)
        }
    }
    fun hideKeyboard(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
