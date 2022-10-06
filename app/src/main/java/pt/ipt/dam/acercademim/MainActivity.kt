package pt.ipt.dam.acercademim

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find the button
        findViewById<Button>(R.id.bt_mostra_nickname).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(it: View) {
        //write here the button action
        //make a reference to the txtBox (to present the nickname)
        val nicknameTxt = findViewById<TextView>(R.id.txtView_show_nickname)

        //make reference to the txtBox where user will write the nickname
        val nicknameTxtBox = findViewById<EditText>(R.id.txtBox_nickName)

        //write the nickname to the TxtView
        nicknameTxt.text = nicknameTxtBox.text

        //change visibility
        nicknameTxt.visibility = View.VISIBLE
        nicknameTxtBox.visibility = View.GONE
        it.visibility = View.GONE

        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}