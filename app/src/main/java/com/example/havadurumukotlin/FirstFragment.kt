package com.example.havadurumukotlin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.havadurumukotlin.FirstViewModel.FirstViewModel
import com.example.havadurumukotlin.adapter.RecyclerViewAdapter
import io.reactivex.Single
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {

    private lateinit var viewModel:FirstViewModel
    private var recycleradapter=RecyclerViewAdapter(arrayListOf())
    private lateinit var editText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root=inflater.inflate(R.layout.fragment_first, container, false)

        editText=root.findViewById(R.id.edittextid)

        return root

     }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonid.setOnClickListener {
            val abc = editText.text.toString()
            viewModel.getDataFromAPI1(abc)

            val imm: InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken,0)


        }


        viewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)

        recycler_view1.layoutManager= LinearLayoutManager(context)
        recycler_view1.adapter=recycleradapter

        observeLiveData()


    }

//    private fun hideMyKeyboard(view: View){
//        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view.windowToken,0)
//    }

    private fun observeLiveData(){

        viewModel.canlihaber.observe(viewLifecycleOwner, Observer { haber->
            haber?.let {
                val abc = editText.text.toString()
                recycler_view1.visibility=View.VISIBLE
                recycleradapter.updateCountyList(haber)

                texthavadurumu.text=haber[0].description
                textderece.text=haber[0].degree
                textsehir.text=abc

            }
        })

    }

 }