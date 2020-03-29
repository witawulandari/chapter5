package com.example.challengechapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        var position = 0

        val adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        dots_indicator.setViewPager(viewPager)

    }
}
