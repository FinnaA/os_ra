package com.justai.aimybox.assistant.model

import com.google.gson.annotations.SerializedName

data class ActionTaskInfo (
    @SerializedName("assignee_id") val assignee_id: Int?,
    @SerializedName("author_id") val author_id: Int?,
    @SerializedName("until_date") val until_date: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("priority") val priority: Int?,
    @SerializedName("type") val type: Int?,
    @SerializedName("text") val text: String?
)