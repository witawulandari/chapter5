package com.example.challengechapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cpu.*

class CpuActivity : AppCompatActivity(), ResultView {

    var view1: View? = null
    var view2: View? = null
    var state = true

    val controller = Controller(this)
    private val TAG = CpuActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cpu)

        var random =  ""
        var nama = intent.extras?.get("nama").toString()

        tvb1.setOnClickListener {
            if (state){
                it.background = getDrawable(R.drawable.select)
                view1 = it
                random = controller.suit.random()
                Log.d(TAG, random)

                controller.checkPemenangCpu("Batu", randomHasil(random))
                state = false
            } else {
                Toast.makeText(this, "Can't select more", Toast.LENGTH_SHORT).show()
            }

        }

        tvc1.setOnClickListener {
            if (state){
                it.background = getDrawable(R.drawable.select)
                view1 = it
                random = controller.suit.random()
                Log.d(TAG, random)

                controller.checkPemenangCpu("Kertas", randomHasil(random))
                state = false
            } else {
                Toast.makeText(this, "Can't select more", Toast.LENGTH_SHORT).show()
            }
        }

        tvd1.setOnClickListener {
            if(state){
                it.background = getDrawable(R.drawable.select)
                view1 = it
                random = controller.suit.random()
                Log.d(TAG, random)

                controller.checkPemenangCpu("Gunting", randomHasil(random))
                state = false
            } else {
                Toast.makeText(this, "Can't select more", Toast.LENGTH_SHORT).show()
            }
        }

        btn_reset.setOnClickListener {
            resetHasil(view1, view2)
            textResult.background = getDrawable(R.drawable.vs)
            state = true
        }

        btn_home.setOnClickListener {
            Intent(this, MenuActivity::class.java).apply {
                putExtra("nama", nama)
                startActivity(this)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                finish()
            }
        }
    }

    fun randomHasil(random: String): String {
        if(random == "Batu"){
            tvb2.background = getDrawable(R.drawable.select)
            view2 = tvb2
        } else if(random == "Kertas"){
            tvc2.background = getDrawable(R.drawable.select)
            view2 = tvc2
        } else if(random == "Gunting"){
            tvd2.background = getDrawable(R.drawable.select)
            view2 = tvd2
        }
        return random
    }

    fun resetHasil(view1: View?, view2: View?){
        view1?.background = getDrawable(android.R.color.transparent)
        view2?.background = getDrawable(android.R.color.transparent)
    }

    override fun showResult(result: Int) {
        textResult.background = getDrawable(result)
    }

}
