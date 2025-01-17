package com.example.elektropolnilnice_app

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.io.IOException

class PreviewFragment : Fragment() {

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageUri = it.getParcelable("imageUri")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_preview, container, false)
        val imageView = view.findViewById<ImageView>(R.id.previewImageView)
        val resultTextView: TextView = view.findViewById<TextView>(R.id.test)
        imageUri?.let {
            imageView.setImageURI(it)

            try {
                // Load the test image from assets
                val inputStream = requireContext().contentResolver.openInputStream(it)//assets.open("test_image.jpg") // Replace with your image name
                val bitmap = BitmapFactory.decodeStream(inputStream)
                resultTextView.text = "Error loading model or image"

//                // Run the model and display the result
//                val prediction = classifier.predict(bitmap)
//                resultTextView.text = "Prediction: $prediction"

            } catch (e: IOException) {
                e.printStackTrace()
                resultTextView.text = "Error loading model or image"
            }
        }
        return view
    }
}