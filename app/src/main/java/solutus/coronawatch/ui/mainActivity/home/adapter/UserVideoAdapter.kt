package solutus.coronawatch.ui.mainActivity.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.coronawatch_mobile.R
import com.squareup.picasso.Picasso
import solutus.coronawatch.data.entity.Video


class UserVideoAdapter(val context: Context) : RecyclerView.Adapter<UserVideoAdapter.UserVideoHolder>() {
    private var userVideos: List<Video> = ArrayList()
    private var listener: OnItemClickListener? = null
    private var longListener : OnItemLongClickListener? = null
    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): UserVideoHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_video_section, parent, false)
        return UserVideoHolder(itemView)
    }


    override fun onBindViewHolder(@NonNull holder: UserVideoHolder, position: Int) {
        val currentVideo: Video = userVideos[position]
        //set video title
        holder.videoTitleView.text = currentVideo.title
        //set video thumnnil
        Picasso.get().load(currentVideo.thumbnail).into(holder.videoThumbnail)
        //set videoStatus
        //holder.videoStatus.text = currentVideo.


    }

    override fun getItemCount(): Int {
        return userVideos.size
    }

    fun setVideos(videos: List<Video>) {
        this.userVideos = videos
        notifyDataSetChanged()
    }

    fun getVideoAt(position: Int): Video? {
        return userVideos[position]
    }


    inner class UserVideoHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        internal val videoTitleView: TextView = itemView.findViewById(R.id.video_title)
        internal val videoThumbnail: ImageView = itemView.findViewById(R.id.video_thumbnil)



        init {
            videoThumbnail.setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener!!.onItemClick(userVideos[position])
                }
            }
            videoThumbnail.setOnLongClickListener {
                val position = adapterPosition
                if(longListener != null && position !=  RecyclerView.NO_POSITION){
                    longListener!!.onItemLongClick(userVideos[position])
                }
                 true
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(video: Video)
    }
    interface OnItemLongClickListener {
        fun onItemLongClick(video: Video) : Boolean
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    fun setOnItemLongClickListener(longListener:OnItemLongClickListener?) {
        this.longListener = longListener
    }


}
