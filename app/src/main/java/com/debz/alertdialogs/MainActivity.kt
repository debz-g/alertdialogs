package com.debz.alertdialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.debz.alertdialogs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addContacts = AlertDialog.Builder(this)
//      We created a AlertDialog class which contains an inner Builder class which will in turn contain all the options for that specific dialog only
            .setTitle("Add Contact")
//      All of the functions under Builder Class returns a builder and not an AlertDialog
            .setMessage("Do you want to add Debayan to your contact list ?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You have added Debayan to your contacts.", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("No") { _, _ ->
//  Check Alert Dialogue video pl-coding at 6:50 to understand more about dialogInterface,i ->
                Toast.makeText(
                    this,
                    "You have not added Debayan to your contacts.",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()
/*  .create() is used so that the Builder Class ultimately return to the AlterDialog Class.
    .setNegativeButton() return a builder. Adding .create() allows it to return an Alert Dialog   */

        binding.btnContact.setOnClickListener {
            addContacts.show()
        }

        val options= arrayOf("First","Second","Third","Fourth","Fifth")
        val optionsAlertDialog=AlertDialog.Builder(this)
            .setTitle("Choose one of these options.")
            .setSingleChoiceItems(options, 0) {dialogInterface, i->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "Accepted.", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(
                    this,
                    "Declined.",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()

        binding.btnDialog2.setOnClickListener {
            optionsAlertDialog.show()
        }

        val multiChoiceDialog=AlertDialog.Builder(this)
            .setTitle("Choose one of these options.")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,true,false,false)) { _, i, isChecked ->
                if(isChecked){
                    Toast.makeText(this, "You checked ${options[i]}",Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this,"You unchecked ${options[i]}",Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "Accepted.", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(
                    this,
                    "Declined.",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()

        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}
