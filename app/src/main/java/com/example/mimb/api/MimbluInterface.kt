package com.example.mimb.api

import com.example.mimb.counselerdata.CounsellorsList
import com.example.mimb.plans.PlusPlans
import retrofit2.Call
import retrofit2.http.GET

interface MimbluInterface {

    @GET("mimblu-yii2-1552/api/user/symptoms")
    fun getSymptoms() : Call<CounsellorsList>

    @GET("mimblu-yii2-1552/api/plan/all")
    fun getPlan() : Call<PlusPlans>

}