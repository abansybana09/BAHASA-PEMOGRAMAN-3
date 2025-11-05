package com.<your>.<application>
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
class Mulai : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mulai)
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/z9FBekMnIm/t41hxd7z_expires_30_days.png").into(findViewById(R.id.rundefined))
        Glide.with(this).load("https://storage.googleapis.com/tagjs-prod.appspot.com/v1/z9FBekMnIm/t41hxd7z_expires_30_days.png").into(findViewById(R.id.r8y1ypub2s9))
    }
}