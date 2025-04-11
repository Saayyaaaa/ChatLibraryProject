package com.example.chatlibraryproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatlib.ChatLauncher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ❗ Не обязательно устанавливать layout — мы сразу запускаем чат
        ChatLauncher.start(this)
        finish() // Закроем MainActivity, чтобы не висела в стеке
    }
}
