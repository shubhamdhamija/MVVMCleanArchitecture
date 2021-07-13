package com.example.mvvmcleanarchitecture.presentation.person

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.databinding.ActivityPersonBinding
import com.example.mvvmcleanarchitecture.presentation.person.di.injector
import javax.inject.Inject


class PersonActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: PersonViewModelFactory
    private lateinit var personViewModel: PersonViewModel
    private lateinit var binding: ActivityPersonBinding
    private lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_person)
        (application as injector).createPersonSubComponent().inject(this)

        personViewModel = ViewModelProvider(this, factory)
            .get(PersonViewModel::class.java)
        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PersonAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }
    private fun displayPopularMovies(){
        binding.personProgressBar.visibility = View.VISIBLE
        val responseLiveData = personViewModel.GetPersons()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.personProgressBar.visibility = View.GONE
            }else{
                binding.personProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
            }
        })

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateMovies(){
        binding.personProgressBar.visibility = View.VISIBLE
        val response = personViewModel.UpdatePersons()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.personProgressBar.visibility = View.GONE
            }else{
                binding.personProgressBar.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

}


