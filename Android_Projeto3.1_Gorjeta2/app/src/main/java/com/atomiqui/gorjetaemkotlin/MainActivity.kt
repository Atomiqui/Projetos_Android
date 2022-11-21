package com.atomiqui.gorjetaemkotlin

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    // Aparentemente não se faz isso, basta usar um cast que o tipo é atribuido automaticamente
    // private lateinit var textInput_preco: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val pois essas variaveis não vai ser alteradas (nem devem)
        val textInput_preco = findViewById<TextInputEditText>(R.id.inputText_preco)
        val text_gorjeta = findViewById<TextView>(R.id.text_gorjeta)
        val text_total = findViewById<TextView>(R.id.text_total)
        val text_aviso = findViewById<TextView>(R.id.text_aviso)
        val text_percent = findViewById<TextView>(R.id.text_aviso)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val gorjeta: Double
                val porcentagem = seekBar!!.progress.toDouble()

                try {
                    var totalInicial : Double = textInput_preco.getText().toString().toDouble()
                    gorjeta = porcentagem / 100 * totalInicial
                    val df = DecimalFormat("#.00")

                    text_percent.setText("$porcentagem%")
                    text_gorjeta.setText("R$ " + df.format(gorjeta))
                    text_total.setText("R$ " + df.format(totalInicial + gorjeta))
                    text_aviso.text = ""
                }
                catch (e: Exception) {
                    seekBar.setProgress(0)
                    text_percent.setText("0%")
                    text_gorjeta.setText("")
                    text_total.setText("")
                    text_aviso.text = "Insira um valor válido!"
                }
                /*try {
                    var porcentagem : Int = seekBar!!.progress

                    var totalInicial : Double = textInput_preco.getText().toString().toDouble()
                    var gorjeta : Double = (porcentagem / 100) * totalInicial

                    val df = DecimalFormat("#.00")

                    text_percent.setText(porcentagem.toString() + "%")
                    text_gorjeta.setText("R$ " + df.format(gorjeta))
                    text_total.setText("R$ " + df.format(totalInicial + gorjeta))

                    text_aviso.text = ""
                }
                catch(e : Exception) {
                    seekBar?.setProgress(0)
                    text_percent.setText("0%")
                    text_gorjeta.setText("")
                    text_total.setText("")
                    text_aviso.text = "Insira um valor válido!"
                }*/
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
