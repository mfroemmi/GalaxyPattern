package com.example.galaxypattern.nav

import javafx.scene.Scene
import javafx.stage.Stage

class NavController private constructor() {

    /**
     * Singleton pattern
     */
    companion object {
        @Volatile
        private lateinit var instance: NavController

        fun getInstance(): NavController {
            synchronized(this) {
                if (!Companion::instance.isInitialized) {
                    instance = NavController()
                }
                return instance
            }
        }
    }

    private lateinit var stage: Stage
    private var scenes: MutableList<Pair<Scene, String>> = mutableListOf()

    fun addStage(stage: Stage) {
        this.stage = stage
    }

    fun addScene(pair: Pair<Scene, String>) {
        scenes.add(pair)
    }

    fun navigateTo(name: String) {
        val pair = scenes.find { it.second == name }
        if (pair != null) {
            stage.scene = pair.first
        }
    }
}