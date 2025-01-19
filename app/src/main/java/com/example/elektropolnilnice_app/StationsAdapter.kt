package com.example.elektropolnilnice_app.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elektropolnilnice_app.R
import com.example.elektropolnilnice_app.models.ChargingStation
import kotlin.random.Random

class ChargingStationAdapter(
    private val stations: List<ChargingStation>,
    private val onItemClick: (ChargingStation) -> Unit
) : RecyclerView.Adapter<ChargingStationAdapter.StationViewHolder>() {

    class StationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val stationTitle: TextView = itemView.findViewById(R.id.textViewStationTitle)
        val stationLocation: TextView = itemView.findViewById(R.id.textViewStationLocation)
        val stationStatus: View = itemView.findViewById(R.id.viewStationStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_station, parent, false)
        return StationViewHolder(view)
    }

    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        val station = stations[position]

        holder.stationTitle.text = station.title ?: "Unknown Station"
        holder.stationLocation.text =
            "${station.town ?: "Unknown Town"}, ${station.country ?: "Unknown Country"}"


        // Nastavimo naključen status
        val isFree = Random.nextBoolean()
        holder.stationStatus.setBackgroundColor(
            if (isFree) Color.GREEN else Color.RED
        )

        holder.itemView.setOnClickListener {
            onItemClick(station)
        }
    }

    override fun getItemCount() = stations.size
}
