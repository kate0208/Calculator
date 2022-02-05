package com.kate.lesson

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kate.lesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding


  //new一個interface出來
  //object : interface name (點setOnClickListener進去看--public interface "OnClickListener")
  private val onClickListener = object : View.OnClickListener {
    override fun onClick(v: View) {
      println((v as TextView).text)
    }

  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.one.setOnClickListener(onClickListener)
    binding.two.setOnClickListener(onClickListener)
    binding.three.setOnClickListener(onClickListener)
    binding.four.setOnClickListener(onClickListener)
    binding.five.setOnClickListener(onClickListener)
    binding.six.setOnClickListener(onClickListener)


  }
}