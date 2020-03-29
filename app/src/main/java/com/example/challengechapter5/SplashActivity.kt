package com.example.challengechapter5

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val restID      = resources.getIdentifier("bright", "raw", packageName)
        val mediaPlayer = MediaPlayer.create(this, restID)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            startActivity(Intent(this, LandingPageActivity::class.java))
            finish()
        }

        val animTitle   = AnimationUtils.loadAnimation(this, R.anim.title)
        val animAssets  = AnimationUtils.loadAnimation(this, R.anim.bkg)
        imageTitle.startAnimation(animTitle)
        imageBatu.startAnimation(animAssets)
        imageKertas.startAnimation(animAssets)
        imageGunting.startAnimation(animAssets)
    }
}
