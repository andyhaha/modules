package com.andy.modules.ui

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.andy.modularization.Component
import com.andy.modularization.ServiceManager
import com.andy.modularization.getString
import com.andy.modularization.holderId
import com.andy.modules.R
import com.andy.modules.databinding.LayoutTitleBarBinding

class TitleBar(
    override val activity: AppCompatActivity,
    private val binding: LayoutTitleBarBinding,
) : Component() {

    companion object {
        private const val TAG = "TitleBar"
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate: Initializing TitleBar component")
        binding.textTitle.text = getString(R.string.title)
        // It is important to note that the generic parameter
        // for ServiceManager.getService<BottomBar>
        // must be the concrete class name, not the interface.
        // Otherwise, the corresponding service cannot be found.
        val service = ServiceManager.getService<BottomBar>(holderId)
        service?.sayHello("Hello from TitleBar")
    }

    override fun onStart() {
        Log.d(TAG, "onStart: TitleBar component started")
    }

    override fun onResume() {
        Log.d(TAG, "onResume: TitleBar component resumed")
    }

    override fun onPause() {
        Log.d(TAG, "onPause: TitleBar component paused")
    }

    override fun onStop() {
        Log.d(TAG, "onStop: TitleBar component stopped")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: TitleBar component destroyed")
    }
}