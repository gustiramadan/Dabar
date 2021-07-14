package com.informatika.databarang

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.informatika.databarang.model.ResponseUsersItem
import com.informatika.databarang.network.koneksi
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        koneksi.service.getUser().enqueue(object : Callback<List<ResponseUsersItem?>?>{
            override fun onFailure(call: retrofit2.Call<List<ResponseUsersItem?>?>, t: Throwable) {
               Log.d( "pesan1", t.localizedMessage)
            }

            override fun onResponse(
                call: retrofit2.Call<List<ResponseUsersItem?>?>,
                response: Response<List<ResponseUsersItem?>?>
            ) {
                if(response.isSuccessful){
                    Log.d("pesan", response.body().toString())
                } else{
                    Log.d("pesan", "data gagal dimuat")
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}