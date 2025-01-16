import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.elektropolnilnice_app.MyApplication
import com.example.elektropolnilnice_app.R
import com.example.elektropolnilnice_app.databinding.FragmentMapBinding
import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager

class MapFragment : Fragment() {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializiraj MapView
        mapView = binding.mapView
        mapView.getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS) { style ->
            addMarkersToMap(style)

        }
    }

    private fun addMarkersToMap(style: Style) {

        val app = requireActivity().application as MyApplication
        val allStations = app.allStations

        style.addImage("marker-icon", BitmapFactory.decodeResource(resources, R.drawable.marker_logo))

        val annotationApi = mapView.annotations
        val pointAnnotationManager = annotationApi.createPointAnnotationManager()

        allStations.forEach { station ->
            val lat = station.latitude
            val lon = station.longitude

            val pointAnnotationOptions = PointAnnotationOptions()
                .withPoint(Point.fromLngLat(lon, lat))
                .withIconImage("marker-icon")
                .withIconSize(0.15)

            pointAnnotationManager.create(pointAnnotationOptions)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }
}
