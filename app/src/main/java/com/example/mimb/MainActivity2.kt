package com.example.mimb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mimb.api.RetrofitBuilder
import com.example.mimb.databinding.ActivityMain2Binding
import com.example.mimb.plans.PlusPlans
import com.example.mimb.plansFrags.LitePlansFragment
import com.example.mimb.plansFrags.LivePlansFragment
import com.example.mimb.plansFrags.PlusPlansFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener { onBackPressed() }

        replaceFragment(PlusPlansFragment())

        binding.lLite.setOnClickListener {
            binding.lLite.setBackgroundResource(R.drawable.rounded_border)
            binding.lPlus.setBackgroundResource(R.drawable.rounded_border_white)
            binding.lLive.setBackgroundResource(R.drawable.rounded_border_white)
            Toast.makeText(applicationContext, "Lite Plans", Toast.LENGTH_SHORT).show()
            replaceFragment(LitePlansFragment())
        }
        binding.lPlus.setOnClickListener {
            binding.lLite.setBackgroundResource(R.drawable.rounded_border_white)
            binding.lPlus.setBackgroundResource(R.drawable.rounded_border)
            binding.lLive.setBackgroundResource(R.drawable.rounded_border_white)

            replaceFragment(PlusPlansFragment())
        }
        binding.lLive.setOnClickListener {
            binding.lLite.setBackgroundResource(R.drawable.rounded_border_white)
            binding.lPlus.setBackgroundResource(R.drawable.rounded_border_white)
            binding.lLive.setBackgroundResource(R.drawable.rounded_border)
            Toast.makeText(applicationContext, "Live Plans", Toast.LENGTH_SHORT).show()

            replaceFragment(LivePlansFragment())
        }


    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flFragContainer,fragment)
        fragmentTransaction.commit()
    }

}