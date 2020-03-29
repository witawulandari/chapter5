package com.example.challengechapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pemain.*

class PemainActivity : AppCompatActivity(), ResultView {

    var pilih1 = ""
    var pilih2 = ""
    var state1 = true
    var state2 = true
    var view1 : View? = null
    var view2 : View? = null
    private lateinit var controller: Controller
    private val TAG = PemainActivity::class.java.simpleName



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemain)
        controller = Controller(this)
        var nama = intent.extras?.get("nama").toString()

        tvbatu1.setOnClickListener {
            if (state1){
                it.background = getDrawable(R.drawable.select)
                pilih1 = tvbatu1.contentDescription.toString()
                view1 = it
                state1 = false
                Log.d(TAG, pilih1)

            } else {
                Toast.makeText(this, "Can't select more", Toast.LENGTH_SHORT).show()
            }
        }

        tvbatu2.setOnClickListener {
            if (state2){
                it.background = getDrawable(R.drawable.select)
                pilih2 = tvbatu2.contentDescription.toString()
                view2 = it
                state2 = false
                Log.d(TAG, pilih2)

                controller.checkPemenang(pilih1, pilih2)
            } else {
                Toast.makeText(this, "Can't select more", Toast.LENGTH_SHORT).show()
            }
        }

        tvkertas1.setOnClickListener {
            if (state1){
                it.background = getDrawable(R.drawable.select)
                pilih1 = tvkertas1.contentDescription.toString()
                view1 = it
                state1 = false
                Log.d(TAG, pilih1)
            } else {
                Toast.makeText(this, "Can't select more", Toast.LENGTH_SHORT).show()
            }
        }

        tvkertas2.setOnClickListener {
            if (state2){
                it.background = getDrawable(R.drawable.select)
                pilih2 = tvkertas2.contentDescription.toString()
                view2 = it
                state1 = false
                Log.d(TAG, pilih2)

                controller.checkPemenang(pilih1, pilih2)
            } else {
                Toast.makeText(this, "Can't select more", Toast.LENGTH_SHORT).show()
            }
        }

        tvgunting1.setOnClickListener {
            if (state1){
                it.background = getDrawable(R.drawable.select)
                pilih1 = tvgunting1.contentDescription.toString()
                view1 = it
                state1 = false
                Log.d(TAG, pilih1)
            } else {
                Toast.makeText(this, "Can't select more", Toast.LENGTH_SHORT).show()
            }
        }

        tvgunting2.setOnClickListener {
            if (state2){
                it.background = getDrawable(R.drawable.select)
                pilih2 = tvgunting2.contentDescription.toString()
                view2 = it
                state2 = false
                Log.d(TAG, pilih2)

                controller.checkPemenang(pilih1, pilih2)
            } else {
                Toast.makeText(this, "Can't select more", Toast.LENGTH_SHORT).show()
            }
        }

        btnreset.setOnClickListener {
            pilih1 = ""
            pilih2 = ""
            resetHasil(view1, view2)
            textHasil.background = getDrawable(R.drawable.vs)
            state1 = true
            state2 = true
        }

        btnhome.setOnClickListener {
            Intent(this, MenuActivity::class.java).apply {
                putExtra("nama", nama)
                startActivity(this)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                finish()
            }

        }
    }

    fun resetHasil(view1: View?, view2: View?){
        view1?.background = getDrawable(android.R.color.transparent)
        view2?.background = getDrawable(android.R.color.transparent)
    }

    override fun showResult(result: Int) {
        textHasil.background = getDrawable(result)
    }

}
