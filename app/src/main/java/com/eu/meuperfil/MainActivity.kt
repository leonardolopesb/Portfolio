package com.eu.meuperfil

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Path
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.eu.meuperfil.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedImageUri: Uri

    private lateinit var button: Button
    private lateinit var image: ImageView

    companion object {
        val REQUEST_CODE_PICK_IMAGE = 100
        val REQUEST_STORAGE_CODE = 200  // For permission request
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Status bar color
        window.statusBarColor = Color.parseColor("#80232323")

        // Inflate layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnClicar.setOnClickListener {
            // Check storage permission before opening gallery
            openGalleryForImage()
        }
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_STORAGE_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGalleryForImage()  // Retry opening gallery now that permission is granted
            } else {
                // Handle permission denied case (optional: show explanation or retry)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.data!!
            binding.imgPerfil.setImageURI(selectedImageUri)

            // Call the save function here
            saveImage(selectedImageUri)
        }
    }

    private fun saveImage(imageUri: Uri) {
        val context = applicationContext

        try {
            val inputStream = contentResolver.openInputStream(imageUri) ?: return
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()

            // Create a unique file name with timestamp
            val fileName = "IMG_${System.currentTimeMillis()}.jpg"
            val outputFile = File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), fileName)

            val outputStream = FileOutputStream(outputFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)  // Adjust quality as needed
            outputStream.close()

            // Update the gallery (optional, to show the saved image immediately)
            //MediaStore.Images.Media.scanFile(context, arrayOf(outputFile.absolutePath), null)

            // Inform the user about successful saving
            Toast.makeText(context, "Imagem salva com sucesso!", Toast.LENGTH_SHORT).show()

            // Get the absolute path of the saved image
            val imagePath = outputFile.absolutePath

            binding.btnPortfolio.setOnClickListener {
                navegarHome(imagePath)
            }

        } catch (e: Exception) {
            e.printStackTrace()
            // Handle errors (optional: show a toast for failed saving)
        }
    }

    private fun navegarHome(imagePath: String){
        val intent = Intent(this, Home::class.java)

        intent.putExtra("imagePath", imagePath)

        startActivity(intent)
    }
}