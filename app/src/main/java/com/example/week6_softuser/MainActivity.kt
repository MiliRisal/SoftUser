package com.example.week6_softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etUn: EditText
    private lateinit var etPw: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUn = findViewById(R.id.etUn)
        etPw = findViewById(R.id.etPw)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener{
            if(etUn.text.toString() == "softwarica" && etPw.text.toString() == "coventry"){
                val intent = Intent(
                        this,
                        DashBoardActivity::class.java
                )
                startActivity(intent)
            }
            else if(etUn.text.toString().equals("") || etPw.text.toString().equals("")){
                Toast.makeText(this,"Can't leave field empty!",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Invalid username or password!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    /*override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnLogin->{
                if(etUn.text.toString() == "softwarica" && etPw.text.toString() == "coventry"){
                    val intent = Intent(
                        this,
                        DashBoardActivity::class.java
                    )
                    startActivity(intent)
                }
                if(etUn.text.toString() == "" && etPw.text.toString() == ""){
                    Toast.makeText(this,"Can't leave field empty!",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Invalid!",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }*/
}