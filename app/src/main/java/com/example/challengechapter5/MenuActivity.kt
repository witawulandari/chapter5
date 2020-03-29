package com.example.challengechapter5

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    private val TAG = MenuActivity::class.java.simpleName
    var nama = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        nama = intent.extras?.get("nama").toString()

//        if (savedInstanceState != null){
//            nama = savedInstanceState.getString("nama", nama)
//            Log.d(TAG, nama)
//            Log.d(TAG, "not save")
//        } else {
//            nama = savedInstanceState?.getString("nama", nama )!!
//            Log.d(TAG, "save")
//        }

        tvMenu1.text = (nama).plus(" VS Pemain")
        tvMenu2.text = (nama).plus(" VS CPU")


        layoutPemain.setOnClickListener {
            Intent(this, PemainActivity::class.java).apply {
                putExtra("nama", nama)
                startActivity(this)
            }
        }

        layoutCpu.setOnClickListener {
            Intent(this, CpuActivity::class.java).apply {
                putExtra("nama", nama)
                startActivity(this)
            }
        }
    }

    override fun onBackPressed() {
        val alertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("OK"){ _, _ ->
                    System.exit(0)
                }
                setNegativeButton("Cancel"){ dialogInterface: DialogInterface, _ ->
                    dialogInterface.cancel()
                }
            }
            builder.create()
        }
        alertDialog.setTitle("EXIT")
        alertDialog.setMessage("Are you sure want to exit ?")
        alertDialog.show()
    }

}
