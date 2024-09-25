package com.example.project5_artspaceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var prevButtonMA:Button
    lateinit var nextButtonMA:Button
    lateinit var imageViewMA: ImageView
    lateinit var descriptionTextView:TextView
    lateinit var authorTextView:TextView

    var currentPhoto = 0
    val listPhotos = listOf(
        Photos("Me", "Charles Agano(2022)",R.drawable.me),
        Photos("ID pic during High School", "Charles Agano(2017)",R.drawable.id_pic),
        Photos("Family Pic","Vacation of the Family (2022)", R.drawable.fam_pic),
        Photos("Meme of Bulalord","GMA News (2014)",R.drawable.meme),
        Photos("Hero","Jose Rizal", R.drawable.rizal))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imageViewMA = findViewById(R.id.imageViewAM)
        descriptionTextView = findViewById(R.id.textDescriptionAM)
        authorTextView = findViewById(R.id.textArtistAM)
        prevButtonMA = findViewById(R.id.prevButtonAM)
        nextButtonMA = findViewById(R.id.nextButtonAM)
        prevButtonMA.setOnClickListener{
            prevPhoto()
        }
        nextButtonMA.setOnClickListener{
            nextPhoto()
        }
        displayPhoto()
    }

    private fun nextPhoto(){
        currentPhoto = (currentPhoto+1)
        displayPhoto()
        if (currentPhoto == 4)
            currentPhoto = currentPhoto - 5
    }
    private fun prevPhoto(){
        if(currentPhoto == 0){
            currentPhoto = currentPhoto + 5
        }
        currentPhoto = (currentPhoto-1)
        displayPhoto()

    }
    private fun displayPhoto(){
        val displayNow = listPhotos[currentPhoto]
        imageViewMA.setImageResource(displayNow.ImageResourceID)
        descriptionTextView.text = displayNow.description
        authorTextView.text = displayNow.author
    }
        data class Photos(val description:String, val author:String, val ImageResourceID:Int)
}




