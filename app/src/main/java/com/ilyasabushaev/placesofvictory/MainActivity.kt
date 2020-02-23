package com.ilyasabushaev.placesofvictory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider


class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView
    private val TARGET_LOCATION: Point = Point(48.741979, 44.538103)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapKitFactory.setApiKey("c712829d-338e-410f-91ad-e88b27a487f0")
        MapKitFactory.initialize(this)

        setContentView(R.layout.activity_main)

        mapView = findViewById(R.id.mapview)
        mapView.onStart()
        mapView.map.move(
            CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5f),
            null
        )
        mapView.map.mapObjects.addPlacemark(TARGET_LOCATION, ImageProvider.fromResource(this, R.drawable.arrow))

    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
    }
}
