package com.genius.broadcastbestpractice

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper

class ForceOfflineReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        // 检查上下文是否为 Activity 类型
        if (context is Activity) {
            // 创建并显示 AlertDialog
            AlertDialog.Builder(context)
                .setTitle("下线通知")
                .setMessage("当前账号在另一台设备上登录，您被迫下线!!!")
                .setCancelable(false) // 禁止点击外部取消
                .setPositiveButton("确定") { dialog, _ ->
                    dialog.dismiss()
                    // 跳转到登录界面并清除所有任务栈
                    val newIntent = Intent(context, LoginActivity::class.java)
                    newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(newIntent)
                    // 结束当前 Activity
                    context.finish()
                }
                .show()
        } else {
            // 如果上下文不是 Activity（如 Service），则使用 Toast 作为备选
            Toast.makeText(context, "当前账号在另一台设备上登录，您被迫下线!!!", Toast.LENGTH_SHORT).show()
        }
    }
}

//        AlertDialog.Builder(ContextThemeWrapper(context, R.style.Theme_BroadcastBestPractice)).apply {
//            setTitle("下线通知")
//            setMessage("当前账号在另一台设备上登录，您被迫下线")
//            setCancelable(false)
//            setPositiveButton("确定") { _, _ ->
//                //跳转到登录界面
//                val newIntent = Intent(context, LoginActivity::class.java)
//                newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//                context.startActivity(newIntent)
//            }
//            show()
//        }