package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var num1: String? = ""
    private var num2: String? = ""
    private var res: Double? = 0.0
    private var sign: String?= ""
    private var newNum = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mostrar: EditText = findViewById<EditText>(R.id.DisplayOp)
        val result: EditText = findViewById<EditText>(R.id.DisplayRes)
        val button0 : Button = findViewById<Button>(R.id.btn0)
        val button1 : Button = findViewById<Button>(R.id.btn1)
        val button2 : Button = findViewById<Button>(R.id.btn2)
        val button3 : Button = findViewById<Button>(R.id.btn3)
        val button4 : Button = findViewById<Button>(R.id.btn4)
        val button5 : Button = findViewById<Button>(R.id.btn5)
        val button6 : Button = findViewById<Button>(R.id.btn6)
        val button7 : Button = findViewById<Button>(R.id.btn7)
        val button8 : Button = findViewById<Button>(R.id.btn8)
        val button9 : Button = findViewById<Button>(R.id.btn9)
        val buttonPlus : Button = findViewById<Button>(R.id.btnPlus)
        val buttonMinus : Button = findViewById<Button>(R.id.btnMinus)
        val buttonMult : Button = findViewById<Button>(R.id.btnMult)
        val buttonDiv : Button = findViewById<Button>(R.id.btnDiv)
        val buttonDec : Button = findViewById<Button>(R.id.btnDec)
        val buttonNeg : Button = findViewById<Button>(R.id.btnNeg)
        val buttonRes : Button = findViewById<Button>(R.id.btnRes)
        val buttonCLR : Button = findViewById<Button>(R.id.btnCLR)

        mostrar.setText("")
        result.setText("")
        val valor = View.OnClickListener { v ->
            val btnTxt = (v as Button).text.toString()
            newNum = newNum + btnTxt
            //newNum.plus(btnTxt);
            //Se intento usar numeros con dos digitos pero el comando "plus" para concatenar los string no funciono
            //Se tiene un bug se repite el segundo digito del numero 1 como el primer digito del numero 2
            AssignNum(mostrar)
            newNum = ""
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
        //Se tiene un bug en donde no se agregan los numeros despues de un decimal


        val operacion = View.OnClickListener { v ->
            val btnOp = (v as Button).text.toString()
            Operacion(btnOp, mostrar, result)
        }

        buttonPlus.setOnClickListener(operacion)
        buttonMinus.setOnClickListener(operacion)
        buttonMult.setOnClickListener(operacion)
        buttonDiv.setOnClickListener(operacion)
        buttonRes.setOnClickListener(operacion)


        buttonCLR.setOnClickListener { _ ->
            res = 0.0
            num1 = ""
            num2 = ""
            mostrar.setText("")
            result.setText("")
        }
        buttonNeg.setOnClickListener {
            val negative = -1 * newNum.toInt()
            //newNum.plus(negative.toString())
            //Nuevamente se intento usar el comando plus pero no funciono
            newNum = negative.toString()
        }//Se deberia corregir o eliminar el negativo
    }

    private fun AssignNum(mostrar: EditText)
    {
        if(num1 == "") {
            num1 = num1 + newNum
            newNum = ""
            mostrar.append(num1)
        }
        else if(num2 == ""||sign != "")
        {
            num2 = num2 + newNum
            newNum=""
            if(sign != "=")
            {
                mostrar.append(num2)
            }
        }
    }

    private fun Operacion(Op: String, mostrar: EditText, result: EditText ){
        when(Op){
            "+" -> {
                sign = "+"
                mostrar.append(sign)
            }
            "-" ->
            {
                sign = "-"
                mostrar.append(sign)
            }
            "*" -> {
                sign = "*"
                mostrar.append(sign)
            }
            "/" -> {
                sign = "/"
                mostrar.append(sign)
            }
            "=" -> {
                when(sign){
                    "+" -> {res = num1!!.toDouble() + num2!!.toDouble()}
                    "-" -> {res = num1!!.toDouble() - num2!!.toDouble()}
                    "*" -> {res = num1!!.toDouble() * num2!!.toDouble()}
                    "/" -> {if (num2!!.toDouble() == 0.0){
                        result.setText("ERROR")
                    }
                    else
                    {
                        res = num1!!.toDouble() / num2!!.toDouble()
                    }}
                }
                result.append(res.toString())
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