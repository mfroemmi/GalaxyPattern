package com.example.galaxypattern

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox

class Scene1 : VBox() {
    val scene = this
    var label1: Label = Label("This is the First Scene")
    var button1: Button = Button("Switch scene")

    fun start() {
        scene.children.addAll(label1, button1)
    }
}