package com.example.mimb.plansFrags

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mimb.R
import com.example.mimb.api.RetrofitBuilder
import com.example.mimb.plans.PlansAdapter
import com.example.mimb.plans.PlusPlans
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlusPlansFragment : Fragment() {

    lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plus_plans, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recycler.setHasFixedSize(true)



        getPlans()
    }

    private fun getPlans() {
        val plusPlans = RetrofitBuilder.retrofit.getPlan()
        plusPlans.enqueue(object : Callback<PlusPlans?> {
            override fun onResponse(call: Call<PlusPlans?>, response: Response<PlusPlans?>) {

                Toast.makeText(requireContext(), response.code().toString(), Toast.LENGTH_SHORT).show()

                if (response.isSuccessful){
                    Log.d("plans", response.body()!!.list.toString())
                    val plansAdapter = PlansAdapter(response.body()!!.list, requireContext())
                    recycler.adapter = plansAdapter
                    plansAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<PlusPlans?>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}