package com.example.safekiosk

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    // Demonstration-only local PIN. Change before any legitimate deployment.
    private val demoPin = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        showLockDemo()
    }

    private fun showLockDemo() {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 48, 32, 48)
        }

        val title = TextView(this).apply {
            text = "ডিভাইস ব্যবহারের ডেমো স্ক্রিন"
            textSize = 24f
            gravity = Gravity.CENTER
        }
        val contact = TextView(this).apply {
            text = "সহায়তার নম্বর: 01762880064"
            textSize = 18f
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 24)
        }
        val pin = EditText(this).apply {
            hint = "ডেমো PIN লিখুন"
            inputType = 2
        }
        val unlock = Button(this).apply {
            text = "ডেমো আনলক"
            setOnClickListener {
                if (pin.text.toString() == demoPin) {
                    Toast.makeText(this@MainActivity, "ডেমো আনলক হয়েছে", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    pin.error = "ভুল PIN"
                }
            }
        }
        val exit = Button(this).apply {
            text = "জরুরি বের হওয়া"
            setOnClickListener { finish() }
        }
        val note = TextView(this).apply {
            text = "এটি কেবল একটি সাধারণ অ্যাপ-স্ক্রিন ডেমো। এটি ফোন লক করে না, পাওয়ার/রিসেট আটকায় না এবং Device Admin বা Accessibility অনুমতি নেয় না।"
            textSize = 14f
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 0)
        }

        root.addView(title)
        root.addView(contact)
        root.addView(pin)
        root.addView(unlock)
        root.addView(exit)
        root.addView(note)
        setContentView(root)
    }
}
