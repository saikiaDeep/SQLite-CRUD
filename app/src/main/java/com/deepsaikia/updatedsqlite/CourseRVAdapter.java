package com.deepsaikia.updatedsqlite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder>{
    // variable for our array list and context
    private ArrayList<CourseModal> courseModalArrayList;
    private Context context;

    // constructor
    public CourseRVAdapter(ArrayList<CourseModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public CourseRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRVAdapter.ViewHolder holder, int position) {
        CourseModal modal = courseModalArrayList.get(position);
        holder.courseNameTV.setText(modal.getCourseName());
        holder.courseDescTV.setText(modal.getCourseDescription());
        holder.courseDurationTV.setText(modal.getCourseDuration());
        holder.courseTracksTV.setText(modal.getCourseTracks());
        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateCourseActivity.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getCourseName());
                i.putExtra("description", modal.getCourseDescription());
                i.putExtra("duration", modal.getCourseDuration());
                i.putExtra("tracks", modal.getCourseTracks());

                // starting our activity.
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView courseNameTV, courseDescTV, courseDurationTV, courseTracksTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);
            courseTracksTV = itemView.findViewById(R.id.idTVCourseTracks);
        }
    }
}
