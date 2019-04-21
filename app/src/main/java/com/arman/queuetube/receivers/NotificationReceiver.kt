package com.arman.queuetube.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

import com.arman.queuetube.config.Constants
import com.arman.queuetube.fragments.main.PlayerFragment

class NotificationReceiver(private val playerFragment: PlayerFragment) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "Received notification action: " + intent.action!!)
        when (intent.action) {
            Constants.Action.Notification.PLAY_ACTION -> this.playerFragment.play()
            Constants.Action.Notification.PAUSE_ACTION -> this.playerFragment.pause()
            Constants.Action.Notification.NEXT_ACTION -> this.playerFragment.skip()
            Constants.Action.Notification.STOP_ACTION -> this.playerFragment.stop()
            else -> {
            }
        }
    }

    companion object {

        const val TAG = "NotificationReceiver"

    }

}
