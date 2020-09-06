package com.benmohammad.coroutinesdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benmohammad.coroutinesdagger.views.ReposFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ReposFragment.newInstance())
                .commitNow()
        }
    }
}