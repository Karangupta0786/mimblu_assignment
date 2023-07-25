package com.example.mimb.counselerdata

data class CounsellorsList(
    val list: List<CounsellorListData>
)

data class CounsellorListData(
    val created_by_id: Int,
    val created_on: String,
    val id: Int,
    val is_selected: Boolean,
    val state_id: Int,
    val title: String,
    val type_id: Int
)