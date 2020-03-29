package com.example.challengechapter5

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_landing_page3.*

/**
 * A simple [Fragment] subclass.
 */
class LandingPage3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landing_page3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_next.setOnClickListener {
            var nama = editText.text.toString()
            val bundle = Bundle()

            Intent(activity, MenuActivity::class.java).apply {
                bundle.putString("nama", nama)
                putExtras(bundle)
                startActivity(this)
            }
        }
    }

}
