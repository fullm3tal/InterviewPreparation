package com.fullm3tal.interviewpreparation.model

class LaunchListResponse {
    var list : ArrayList<LaunchInfo> = ArrayList<LaunchInfo>()
    var loading = true
    var error: String? = null
}