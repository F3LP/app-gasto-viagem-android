package com.example.gastodeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.btnCalcular) {
            calculate()
        }
    }

    private fun calculate() = if (validationOK()) {

        try {
            val distance = editDistance.text.toString().toFloat()
            val price = editPrice.text.toString().toFloat()
            val autonomy = editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            textTotalValue.text = "R$ ${"%.2f".format((totalValue))}"
        } catch (nfe: NumberFormatException) {
            Toast.makeText(applicationContext, getString(R.string.not_valores_validos), Toast.LENGTH_LONG).show()
        }

    } else {
        Toast.makeText(applicationContext, getString(R.string.notificacao), Toast.LENGTH_LONG)
            .show()
    }

    private fun validationOK(): Boolean =
        (editDistance.text.toString() != "" && editPrice.text.toString() != "" && editAutonomy.text.toString() != "" && editAutonomy.text.toString() != "0")

}