package com.kate.lesson

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

  private lateinit var binding: ActivityMainBinding

  //new一個interface出來
  //object : interface name (點setOnClickListener進去看--public interface "OnClickListener")
//  private val onClickListener = object : View.OnClickListener {
//    override fun onClick(v: View) {
//
//      binding.phoneNumber.text="${binding.phoneNumber.text}${(v as Button).text}"
//    }
//
//  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.one.setOnClickListener(this)
    binding.two.setOnClickListener(this)
    binding.three.setOnClickListener(this)
    binding.four.setOnClickListener(this)
    binding.five.setOnClickListener(this)
    binding.six.setOnClickListener(this)

    binding.clear.setOnClickListener {
      binding.phoneNumber.text = ""
    }

  }

  override fun onClick(v: View?) {
    binding.phoneNumber.text = "${binding.phoneNumber.text}${(v as Button).text}"
  }
}