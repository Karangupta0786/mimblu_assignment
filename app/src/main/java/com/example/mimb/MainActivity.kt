package com.example.mimb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimb.api.RetrofitBuilder
import com.example.mimb.counselerdata.CounsellorListData
import com.example.mimb.counselerdata.CounsellorsList
import com.example.mimb.counselerdata.SymptomsAdapter
import com.example.mimb.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SymptomsAdapter.OnListChanges {

    lateinit var binding: ActivityMainBinding

    lateinit var idList: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Logout.setOnClickListener {
            onBackPressed()
        }

        binding.btnCard.setOnClickListener {
            if (idList.isNotEmpty()) {
                val x = Intent(this@MainActivity,MainActivity2::class.java)
                startActivity(x)
            }
        }
        
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)

        getSymptoms()

    }

    private fun getSymptoms() {
        val symptoms = RetrofitBuilder.retrofit.getSymptoms()
        symptoms.enqueue(object : Callback<CounsellorsList?> {
            override fun onResponse(
                call: Call<CounsellorsList?>,
                response: Response<CounsellorsList?>
            ) {

                Toast.makeText(applicationContext, response.code().toString(), Toast.LENGTH_SHORT).show()

                if (response.isSuccessful){
                    Log.d("symptom", response.body()!!.list.toString())

                    val symptomsAdapter = SymptomsAdapter(response.body()!!.list as ArrayList<CounsellorListData>, applicationContext)
                    binding.recycler.adapter = symptomsAdapter
                    symptomsAdapter.setOnListChangeListener(this@MainActivity)
                    symptomsAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_SHORT).show()
                }


            }

            override fun onFailure(call: Call<CounsellorsList?>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun listChanged(list: ArrayList<Int>) {
        if (list.size == 0){
            binding.btnCard.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.OrangeLite))
            binding.btnCard.isClickable = false
        } else {
            binding.btnCard.isClickable = true
            binding.btnCard.setCardBackgroundColor(ContextCompat.getColor(applicationContext, R.color.Orange))
        }
        idList = list
    }
}