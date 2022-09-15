package com.example.galaxypattern.gui.solar.view.infobox

import com.example.galaxypattern.main.MainViewModel
import com.example.galaxypattern.model.Planet
import com.example.galaxypattern.res.Colors
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.*
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight

class InfoBoxView(planet: Planet) : VBox() {

    private val viewModel = MainViewModel.getInstance()

    private val scene = this

    private val widthView = 500.0
    private val heightView = 500.0

    private val headHeight = 25.0
    private val bodyHeight = 475.0

    private var title: Label = Label(planet.name)
    private var close: Label = Label("close")
    private val head = HeadInfoView(widthView, headHeight)
    private val body = BodyInfoView(widthView, bodyHeight)

    private val headStackPane = StackPane()
    private val headHBox = HBox()

    private val bodyStackPane = StackPane()
    private val bodyVBox = VBox()

    var remove = false

    init {
        this.width = widthView
        this.height = heightView

        title.apply {
            style = "-fx-text-fill: #FFFFFF; -fx-font-size: 16; "
            minWidth = widthView * 0.9
            minHeight = headHeight
            alignment = Pos.CENTER
        }
        close.apply {
            style = "-fx-font-size: 12; "
            background = Background(BackgroundFill(Colors.gray, CornerRadii.EMPTY, Insets.EMPTY))
            textFill = Colors.white
            minWidth = widthView * 0.1
            minHeight = headHeight - 1
            alignment = Pos.CENTER
        }
        head.apply {
            setMaxSize(widthView, headHeight)
        }
        body.apply {
            setMaxSize(widthView, bodyHeight)
        }

        close.setOnMouseClicked {
            remove = true
        }

        /**
         * Mouse-Event-Handler to move the info box
         */
        var deltaX = 0.0
        var deltaY = 0.0
        title.onMousePressed = EventHandler { event ->
            if (event != null) {
                deltaX = scene.translateX - event.screenX
                deltaY = scene.translateY - event.screenY
            }
        }
        title.onMouseDragged = EventHandler { event ->
            if (event != null) {
                scene.translateX = event.screenX + deltaX
                scene.translateY = event.screenY + deltaY
            }
        }

        headHBox.children.addAll(title, close)
        headStackPane.children.addAll(head, headHBox)
        bodyVBox.children.addAll(
            getLabel("name", viewModel.planetParams(planet).name()),
            getLabel("atmosphere", viewModel.planetParams(planet).atmosphere()),
            getLabel("density", viewModel.planetParams(planet).density()),
            getLabel("diameter", viewModel.planetParams(planet).diameter()),
            getLabel("moons", viewModel.planetParams(planet).moons()),
            getLabel("mass", viewModel.planetParams(planet).mass()),
            getLabel("distance", viewModel.planetParams(planet).distance()),
            getLabel("inclination", viewModel.planetParams(planet).inclination()),
            getLabel("period", viewModel.planetParams(planet).period()),
            getLabel("rotation", viewModel.planetParams(planet).rotation())
        )
        bodyStackPane.children.addAll(body, bodyVBox)
        scene.children.addAll(headStackPane, bodyStackPane)
    }

    fun update() {
        head.draw()
        body.draw()
    }

    private fun getLabel(title: String, description: String): HBox {
        return HBox(
            Label("$title:").apply {
                font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14.0)
                textFill = Colors.white
                padding = Insets(5.0)
                minWidth = widthView * 0.3
            },
            Label(description).apply {
                font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14.0)
                textFill = Colors.white
                padding = Insets(5.0)
                minWidth = widthView * 0.3
            }).apply { padding = Insets(5.0) }
    }
}