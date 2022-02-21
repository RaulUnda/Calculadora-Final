package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var num1: Double? = null
    private var num2: Double? = null
    private var res: Double? = null
    private var sign: String?= ""
    private var newNum: String? = ""
    private val mostrar: EditText = findViewById<EditText>(R.id.DisplayOp)
    private val result: EditText = findViewById<EditText>(R.id.DisplayRes)
    private val button0 : Button = findViewById<Button>(R.id.btn0)
    private val button1 : Button = findViewById<Button>(R.id.btn1)
    private val button2 : Button = findViewById<Button>(R.id.btn2)
    private val button3 : Button = findViewById<Button>(R.id.btn3)
    private val button4 : Button = findViewById<Button>(R.id.btn4)
    private val button5 : Button = findViewById<Button>(R.id.btn5)
    private val button6 : Button = findViewById<Button>(R.id.btn6)
    private val button7 : Button = findViewById<Button>(R.id.btn7)
    private val button8 : Button = findViewById<Button>(R.id.btn8)
    private val button9 : Button = findViewById<Button>(R.id.btn9)
    private val buttonPlus : Button = findViewById<Button>(R.id.btnPlus)
    private val buttonMinus : Button = findViewById<Button>(R.id.btnMinus)
    private val buttonMult : Button = findViewById<Button>(R.id.btnMult)
    private val buttonDiv : Button = findViewById<Button>(R.id.btnDiv)
    private val buttonDec : Button = findViewById<Button>(R.id.btnDec)
    private val buttonNeg : Button = findViewById<Button>(R.id.btnNeg)
    private val buttonRes : Button = findViewById<Button>(R.id.btnRes)
    private val buttonCLR : Button = findViewById<Button>(R.id.btnCLR)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val valor = View.OnClickListener { v -> val btnVal = v as Button
            newNum.plus(btnVal.toString())
        }


        button0.setOnClickListener(valor)
        button1.setOnClickListener(valor)
        button2.setOnClickListener(valor)
        button3.setOnClickListener(valor)
        button4.setOnClickListener(valor)
        button5.setOnClickListener(valor)
        button6.setOnClickListener(valor)
        button7.setOnClickListener(valor)
        button8.setOnClickListener(valor)
        button9.setOnClickListener(valor)
        buttonDec.setOnClickListener(valor)

        val operacion = View.OnClickListener { v ->
            val btnOp = (v as Button).text.toString()
            Operacion(btnOp)
        }

        buttonPlus.setOnClickListener(operacion)
        buttonMinus.setOnClickListener(operacion)
        buttonMult.setOnClickListener(operacion)
        buttonDiv.setOnClickListener(operacion)
        buttonRes.setOnClickListener(operacion)


        buttonCLR.setOnClickListener { _ ->
            res = 0.0
            num1 = null
            num2 = null
            if(num1 == null || num2 == null)
            {
                mostrar.setText("")
            }
            if(res == 0.0)
            {
                result.setText("")
            }
        }
        buttonNeg.setOnClickListener {
            val negative = -1 * newNum!!.toInt()
            newNum = negative.toString()
        }
    }

    private fun Operacion(Op: String ){
        if(num1 == null)
        {
            num1 = newNum?.toDouble()
        }
        else if(num2 == null)
        {
            num2 = newNum?.toDouble()
        }
        newNum = ""
        mostrar.append(num1.toString())
        when(Op){
            "+" -> {
                res = num1!! + num2!!
                sign = "+"
                mostrar.append(sign)
            }
            "-" ->
            {
                res = num1!! - num2!!
                sign = "-"
                mostrar.append(sign)
            }
            "*" -> {
                res = num1!! * num2!!
                sign = "*"
                mostrar.append(sign)
            }
            "/" -> if (num2 == 0.0){
                result.setText("ERROR")
            }
            else{
                res = num1!! / num2!!
                sign = "/"
                mostrar.append(sign)
            }
            "=" -> {
                mostrar.append(num2.toString())
                result.append(res.toString())
                num1 = res
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}