package com.example.mvvmcleanarchitecture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmcleanarchitecture.databinding.ActivityHomeBinding
import com.example.mvvmcleanarchitecture.presentation.person.PersonActivity


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.personButton.setOnClickListener {
            val intent = Intent(this,PersonActivity::class.java)
            startActivity(intent)
        }

    }
}