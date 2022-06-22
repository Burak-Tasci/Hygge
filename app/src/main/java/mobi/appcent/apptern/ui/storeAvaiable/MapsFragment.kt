package mobi.appcent.apptern.ui.storeAvaiable

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Transformations.map
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import mobi.appcent.apptern.R
import mobi.appcent.apptern.data.model.remote.response.Store
import mobi.appcent.apptern.databinding.FragmentDetailBinding
import mobi.appcent.apptern.databinding.FragmentMapsBinding
import mobi.appcent.apptern.ui.MainActivity
import mobi.appcent.apptern.ui.base.BaseFragment
import java.text.ChoiceFormat.nextDouble
import java.util.*
import kotlin.random.Random

class MapsFragment: BaseFragment(), OnMapReadyCallback {

    val args: MapsFragmentArgs by navArgs()
    private lateinit var binding: FragmentMapsBinding
    private var store: Store? = null
    private lateinit var mMap: GoogleMap
    private lateinit var locationManager: LocationManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as MainActivity).isEnabledBackButton(true)
        binding = FragmentMapsBinding.inflate(layoutInflater)
        store = args.store
        val mapFragment = childFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        locationManager = requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager


        if (ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // permission not granted
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                0
            )
        } else {
            // permission granted
            setMap()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 0){
            if (grantResults.size > 0){
                if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    // permission granted
                    setMap()
                }
            }
        }
    }

    private fun setMap(){

        mMap.clear()
        // when the location changes
        store?.let {
            val loc = LatLng(Random.nextDouble(36.0,42.0), Random.nextDouble(26.0,45.0))
            mMap.addMarker(MarkerOptions().position(loc).title(store!!.storeName))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 15f))
        }

    }
}