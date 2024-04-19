package com.example.calculater

import android.graphics.Path.Op
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btn0: Button
    lateinit var txt: TextView
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var minus:Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var zero2: Button
    lateinit var point: Button
    lateinit var div: Button
    lateinit var multi: Button
    lateinit var pluse: Button
    lateinit var ac: Button
    lateinit var sum: Button
    lateinit var qq:Button
    lateinit var delet:Button

    var firstnum = 0.0
    var secondnum = 0.0
    var ans = 0.0

    var btnarray = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0 = findViewById(R.id.zero)
        btn1 = findViewById(R.id.one)
        btn2 = findViewById(R.id.two)
        btn3 = findViewById(R.id.thre)
        btn4 = findViewById(R.id.four)
        btn5 = findViewById(R.id.five)
        btn6 = findViewById(R.id.six)
        btn7 = findViewById(R.id.seven)
        btn8 = findViewById(R.id.eight)
        btn9 = findViewById(R.id.Nine)
        zero2 = findViewById(R.id.zero2)
        point = findViewById(R.id.point)
        div = findViewById(R.id.division)
        multi = findViewById(R.id.multi)
        pluse = findViewById(R.id.pluse)
        minus = findViewById(R.id.minus)
        ac = findViewById(R.id.Ac)
        sum = findViewById(R.id.sum)
        qq = findViewById(R.id.qq)
        txt = findViewById(R.id.txt)
        delet=findViewById(R.id.delet)

        btnarray.add(0, btn0)
        btnarray.add(1, btn1)
        btnarray.add(2, btn2)
        btnarray.add(3, btn3)
        btnarray.add(4, btn4)
        btnarray.add(5, btn5)
        btnarray.add(6, btn6)
        btnarray.add(7, btn7)
        btnarray.add(8, btn8)
        btnarray.add(9, btn9)
        btnarray.add(10, zero2)
        btnarray.add(11, point)
        btnarray.add(12, div)
        btnarray.add(13, multi)
        btnarray.add(14, pluse)
        btnarray.add(15, minus)
        btnarray.add(16, ac)
        btnarray.add(17, sum)
        btnarray.add(18,qq)
        btnarray.add(19,delet)

        click(0)
        click(1)
        click(2)
        click(3)
        click(4)
        click(5)
        click(6)
        click(7)
        click(8)
        click(9)
        click(10)
        click(11)
        click(12)
        click(13)
        click(14)
        click(15)
        click(16)
        click(17)
        click(18)
        click(19)
    }


    private fun click(i: Int) {

        try {
            btnarray[i].setOnClickListener {

                try {
                    if (i == 12 || i == 13 || i == 14 || i == 15) {
                        proces(i)
                    } else if (i == 17) {
                        answer(i)
                    } else if (i == 16) {
                        txt.setText("")
                    } else if (i == 0) {
                        val S = txt.text
                        if (i == 0 == S.isEmpty()) {
                            txt.setText(txt.text.toString() + "0")
                        } else if (S.equals("0") == S.isEmpty()) {
                            txt.setText(txt.text.toString() + "0")
                        }
                    } else if (i == 10) {
                        val S = txt.text
                        if (i == 10 == S.isEmpty()) {
                            txt.setText(txt.text.toString() + "0")
                        } else if (S.equals("0") == S.isEmpty()) {
                            txt.setText(txt.text.toString() + "00")
                        }
                    } else if (i == 11) {
                        val S = txt.text
                        if (1 > S.indexOf(".")) {
                            if (S.isEmpty()) {
                                txt.setText(txt.text.toString() + "0.")
                            } else {
                                txt.setText(txt.text.toString() + ".")
                            }
                        }
                    }else if(i == 19){
                        txt.setText(txt.text.substring(0, txt.text.length - 1))
                    }
                    else if (i == 18) {
                        firstnum = txt.text.toString().toDouble() / 100
                        txt.setText(firstnum.toString())


                    } else {
                        txt.setText(txt.text.toString() + btnarray[i].text.toString())
                    }
                }catch (e:Exception){

                }
            }
        }catch (e:NumberFormatException){

        }
    }
var temp =0.0


        private fun proces(i: Int) {

            temp = txt.text.toString().toDouble()

            try {
                if (Operatering.pluse) {
                    firstnum = firstnum + temp
                } else if (Operatering.div) {
                    firstnum = firstnum / temp
                } else if (Operatering.multi) {
                    firstnum = firstnum * temp
                } else if (Operatering.minus) {
                    firstnum = firstnum - temp
                } else {
                    firstnum = temp
                }
            }catch (e:NumberFormatException){

            }


            try {
                if (i == 12) {
                    Operatering.div = true
                } else if (i == 13) {
                    Operatering.multi = true
                } else if (i == 14) {
                    Operatering.pluse = true
                } else if (i == 15) {
                    Operatering.minus = true
                }

                txt.setText("")
            }catch (e:Exception){

            }

        }


        private fun answer(i: Int) {
            try {
                secondnum = txt.text.toString().toDouble()
                if (Operatering.pluse) {
                    ans = firstnum + secondnum
                } else if (Operatering.div) {
                    ans = firstnum / secondnum
                } else if (Operatering.multi) {
                    ans = firstnum * secondnum
                } else if (Operatering.minus) {
                    ans = firstnum - secondnum
                }

                txt.setText(ans.toString())
                Operatering.pluse = false
                Operatering.div = false
                Operatering.multi = false
                Operatering.minus = false
            }catch (e:NumberFormatException){

            }
        }


}


class Operatering {


        companion object {
        var pluse: Boolean = false
        var div: Boolean = false
        var multi: Boolean = false
        var minus: Boolean = false
    }


}