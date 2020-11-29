package com.justai.aimybox.assistant.skills

import android.content.Context
import android.content.Intent
import com.github.salomonbrys.kotson.get
import com.google.gson.JsonObject
import com.justai.aimybox.Aimybox
import com.justai.aimybox.api.aimybox.AimyboxRequest
import com.justai.aimybox.api.aimybox.AimyboxResponse
import com.justai.aimybox.assistant.EXTRA_MESSAGE
import com.justai.aimybox.assistant.ui.activities.*
import com.justai.aimybox.core.CustomSkill
import com.justai.aimybox.model.Response
import org.json.JSONObject

class CreateTaskSkill(private val context: Context): CustomSkill<AimyboxRequest, AimyboxResponse> {

    override fun canHandle(response: AimyboxResponse) = response.action == "addTask"

    override suspend fun onResponse(
        response: AimyboxResponse,
        aimybox: Aimybox,
        defaultHandler: suspend (Response) -> Unit
    ) {
        val type = response.intent

        // Create JSON using JSONObject
        val until_date = response.data?.get("data")?.get("term")
        val text = response.data?.get("data")?.get("text")
        val title = response.data?.get("data")?.get("title")

        val jsonObject = JSONObject()
        jsonObject.put("assignee_id", "3232")
        jsonObject.put("author_id", "3540")
        jsonObject.put("until_date", until_date)
        jsonObject.put("title", title)
        jsonObject.put("priority", "1")
        jsonObject.put("type", "1")
        jsonObject.put("text", text)

        val jsonObjectString = jsonObject.toString()

        val intent = Intent(context, AddTaskActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, jsonObjectString)
        }
        aimybox.standby()
        context.startActivity(intent)
    }
}