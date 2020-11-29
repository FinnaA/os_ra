package com.justai.aimybox.assistant.skills

import android.content.Context
import android.content.Intent
import com.justai.aimybox.Aimybox
import com.justai.aimybox.api.aimybox.AimyboxRequest
import com.justai.aimybox.api.aimybox.AimyboxResponse
import com.justai.aimybox.assistant.MainActivity
import com.justai.aimybox.assistant.ui.activities.*
import com.justai.aimybox.core.CustomSkill
import com.justai.aimybox.model.Response

class ChangeViewSkill(private val context: Context): CustomSkill<AimyboxRequest, AimyboxResponse> {

    override fun canHandle(response: AimyboxResponse) = response.action == "changeView"

    override suspend fun onResponse(
        response: AimyboxResponse,
        aimybox: Aimybox,
        defaultHandler: suspend (Response) -> Unit
    ) {
        val intent = when (response.intent) {
            "settings" -> Intent(context, SettingsActivity::class.java)
            "tasks" -> Intent(context, TaskActivity::class.java)//
            "newTask" -> Intent(context, AddTaskActivity::class.java)//
            "search" -> Intent(context, SearchActivity::class.java)
            else -> Intent(context, MainActivity::class.java)
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        aimybox.standby()
        context.startActivity(intent)
    }
}