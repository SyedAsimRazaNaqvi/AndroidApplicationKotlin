package com.firstapp.msgshareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        btnShowToast.setOnClickListener{
            //code
            Log.i("MainActivity","Button was clicked !")
            Toast.makeText(this,"Button Was clicked !",Toast.LENGTH_SHORT).show()

            }

        btnSendMsgToNextActivty.setOnClickListener{
            Toast.makeText(this,"Send Button was clicked!",Toast.LENGTH_SHORT).show()
            val message:String=etUserMessage.text.toString()

            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("user_message",message)
            startActivity(intent)


        }
        btnShareToOthersApps.setOnClickListener{
            val message :String =etUserMessage.text.toString()

            val intent =Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type="text/plain"

            startActivity(Intent.createChooser(intent,"Please select app: "))
        }
    }

}
