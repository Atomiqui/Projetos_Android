package com.atomiqui.gorjetaemkotlin

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var textInput_preco: TextInputEditText
    private lateinit var text_gorjeta   : TextView
    private lateinit var text_total     : TextView
    private lateinit var text_aviso     : TextView
    private lateinit var text_percent   : TextView
    private lateinit var seekBar        : SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInput_preco = findViewById(R.id.inputText_preco)
        text_gorjeta    = findViewById(R.id.text_gorjeta)
        text_total      = findViewById(R.id.text_total)
        text_aviso      = findViewById(R.id.text_aviso)
        text_percent    = findViewById(R.id.text_aviso)
        seekBar         = findViewById(R.id.seekBar)

        manageSeekBar()
    }

    private fun manageSeekBar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                var porcentagem = seekBar!!.progress.toDouble()

                try {
                    var totalInicial : Double = textInput_preco.getText().toString().toDouble()
                    var gorjeta: Double = porcentagem / 100 * totalInicial
                    val df = DecimalFormat("#.00")

                    text_percent.setText("$porcentagem%")
                    text_gorjeta.setText("R$ " + df.format(gorjeta))
                    text_total.setText("R$ " + df.format(totalInicial + gorjeta))
                    text_aviso.text = ""
                } catch (e: Exception) {
                    seekBar.setProgress(0)
                    text_percent.setText("0%")
                    text_gorjeta.setText("")
                    text_total.setText("")
                    text_aviso.text = "Insira um valor válido!"
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //TODO("Not yet implemented")
            }

        })
    }
}
