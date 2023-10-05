package com.fullm3tal.interviewpreparation.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LaunchSite : Serializable {

    var id: Long? = null

    @SerializedName("site_id")
    @Expose
    var siteId: String? = null

    @SerializedName("site_name")
    @Expose
    var siteName: String? = null

    @SerializedName("site_name_long")
    @Expose
    var siteNameLong: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()

    /**
     *
     * @param siteNameLong
     * @param siteId
     * @param siteName
     */

    constructor(siteId: String?, siteName: String?, siteNameLong: String?) : super() {
        this.siteId = siteId
        this.siteName = siteName
        this.siteNameLong = siteNameLong
    }

    companion object {
        private const val serialVersionUID = -6309295352089762351L
    }
}
