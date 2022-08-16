package com.example.galaxypattern.main

class MainViewModel {

    /**
     * Singleton pattern
     */
    companion object {
        @Volatile
        private lateinit var instance: MainViewModel

        fun getInstance(): MainViewModel {
            synchronized(this) {
                if (!Companion::instance.isInitialized) {
                    instance = MainViewModel()
                }
                return instance
            }
        }
    }

    val width = 1024.0
    val height = 768.0
}