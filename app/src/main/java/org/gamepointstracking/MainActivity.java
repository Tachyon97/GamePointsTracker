package org.gamepointstracking

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import org.gamepointstracking.collections.CustomSharedPreference
import org.gamepointstracking.collections.PersonAdapter
import org.gamepointstracking.collections.Players

import java.lang.reflect.Type
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var users: ArrayList<Players>? = ArrayList()
    internal var list: ListView
    private var gson: Gson? = null
    private var preference: CustomSharedPreference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gson = Gson()
        preference = CustomSharedPreference(this)
        retrieveUsers()


    }

    fun addUserButton(view: View) {
        val adapter = PersonAdapter(this, users)
        val builder = AlertDialog.Builder(this)
        list = findViewById(R.id.userList)
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id -> users!![position] }
        builder.setTitle(resources.getString(R.string.addDescription))
        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)
        builder.setPositiveButton(resources.getText(R.string.ok)) { dialog, which ->
            users!!.add(Players(input.text.toString()))
            save(users)
        }
        builder.setNegativeButton(resources.getText(R.string.cancel)) { dialog, which -> dialog.cancel() }
        builder.show()
        list.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    fun removeUserButton(view: View) {
        list = findViewById(R.id.userList)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(resources.getString(R.string.removeDescription))
        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)
        builder.setPositiveButton(resources.getText(R.string.ok)) { dialog, which ->
            if (users!!.contains(input.text.toString())) {
                if (getIndex(input.text.toString()) != -1) {
                    users!!.removeAt(getIndex(input.text.toString()))
                }
            }
        }
        builder.show()
    }

    private fun getIndex(user: String): Int {
        for (p in users!!) {
            if (p.user == user)
                return users!!.indexOf(p)
        }
        return -1
    }

    private fun save(players: ArrayList<Players>?) {
        val jsonUsers = gson!!.toJson(players)
        preference!!.saveUsers(jsonUsers)
    }

    private fun retrieveUsers() {
        val jsonUsers = preference!!.users
        val type = object : TypeToken<List<Players>>() {

        }.type
        users = gson!!.fromJson<ArrayList<Players>>(jsonUsers, type)
        if (users == null) {
            users = ArrayList()
        }
    }
}