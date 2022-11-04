package com.sriyank.globotour.city

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.sriyank.globotour.R

class CityAdapter(val context: Context,var cityList : ArrayList<City> )
    : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val itemView =  LayoutInflater.from(context).inflate(R.layout.list_item_city,parent,false)
        return CityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cityList[position]
        holder.setData(city,position)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var currentPosition = -1
        private var currentCity : City? = null

        private val txtCityName = itemView.findViewById<TextView>(R.id.txv_city_name)
        private val imvCityImage = itemView.findViewById<ImageView>(R.id.imv_city)
        private val imvDelete = itemView.findViewById<ImageView>(R.id.imv_delete)
        private val imvFavorite = itemView.findViewById<ImageView>(R.id.imv_favorite)

        private val icFavoriteFilled = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.ic_favorite_filled,
            null)
        private val icFavoriteBorded = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.ic_favorite_bordered,
            null)
        private val delete = ResourcesCompat.getDrawable(
            context.resources,
            R.drawable.ic_delete,
            null)

        fun setData(city: City, position: Int) {
            txtCityName.text = city.name
            imvCityImage.setImageResource(city.imageId)
            imvDelete.setImageDrawable(delete)

            if(city.isFavorite){
                imvFavorite.setImageDrawable(icFavoriteFilled)
            }else{
                imvFavorite.setImageDrawable(icFavoriteBorded)
            }
            this.currentPosition = position
            this.currentCity = city
        }

    }
}