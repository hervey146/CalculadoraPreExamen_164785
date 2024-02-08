package mx.edu.potros.calculadora_hectoralcantar_164785

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculadora.R

class MainActivity : AppCompatActivity() {
    //0->nada, 1->suma, 2->resta; 3->mult; 4->div
    var oper: Int = 0
    var number: Int = 0
    lateinit var numeros: TextView
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numeros = findViewById(R.id.numeros)
        resultado = findViewById(R.id.resultado)

        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        val btnResultado: Button = findViewById(R.id.btnResultado)

        btnResultado.setOnClickListener {
            var number2: Int = numeros.text.toString().toInt()
            var resp: Int = 0

            when (oper) {
                1 -> resp = number + number2
                2 -> resp = number - number2
                3 -> resp = number * number2
                4 -> resp = number / number2
            }

            resultado.setText(resp.toString())
            numeros.setText("")

        }

        btnBorrar.setOnClickListener {
            numeros.setText("")
            resultado.setText("")
            number = 0
            oper = 0
        }
    }

    fun presionarDigito(view: View) {
        var num = numeros.text.toString()

        when (view.id) {
            R.id.btn0 -> numeros.setText(num + "0")
            R.id.btn1 -> numeros.setText(num + "1")
            R.id.btn2 -> numeros.setText(num + "2")
            R.id.btn3 -> numeros.setText(num + "3")
            R.id.btn4 -> numeros.setText(num + "4")
            R.id.btn5 -> numeros.setText(num + "5")
            R.id.btn6 -> numeros.setText(num + "6")
            R.id.btn7 -> numeros.setText(num + "7")
            R.id.btn8 -> numeros.setText(num + "8")
            R.id.btn9 -> numeros.setText(num + "9")
        }
    }

    fun clicOperacion(view: View) {
        number = numeros.text.toString().toInt()
        var num2_txt: String = numeros.text.toString()
        numeros.setText("")
        when(view.id) {
            R.id.btnSuma -> {
                resultado.setText(num2_txt + "+")
                oper = 1
            }
            R.id.btnResta -> {
                resultado.setText(num2_txt + "-")
                oper = 2
            }
            R.id.btnMultiplicar -> {
                resultado.setText(num2_txt + "x")
                oper = 3
            }
            R.id.btnDividir -> {
                resultado.setText(num2_txt + "÷")
                oper = 4
            }
        }
    }

}