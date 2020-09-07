package jp.techacademy.motoko.yamanouchi.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val str1 = editText1.text.toString()
        val str2 = editText2.text.toString()
        val intent = Intent(this, SecondActivity::class.java)

        if (str1 == "" || str2 == "") {
            v.id == R.id.button1 || v.id == R.id.button2 ||v.id == R.id.button3 || v.id == R.id.button4
            val snackbar = Snackbar.make(v, "何か数値を入力して下さい", Snackbar.LENGTH_INDEFINITE)
                .setAction("戻る") {
                }.show()
        } else {
            if (v.id == R.id.button1) {
                intent.putExtra("Result", str1.toDouble() + str2.toDouble())
            } else if (v.id == R.id.button2) {
                intent.putExtra("Result", str1.toDouble() - str2.toDouble())
            } else if (v.id == R.id.button3) {
                intent.putExtra("Result", str1.toDouble() * str2.toDouble())
            } else {
                intent.putExtra("Result", str1.toDouble() / str2.toDouble())
            }
                startActivity(intent)
        }
    }
}