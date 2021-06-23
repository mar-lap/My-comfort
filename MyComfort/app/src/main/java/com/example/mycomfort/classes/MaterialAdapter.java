package com.example.mycomfort.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycomfort.R;
import com.example.mycomfort.classes.Material;

import java.util.List;

public class MaterialAdapter extends ArrayAdapter <Material> {
    private LayoutInflater inflater;
    private int layout;
    private List<Material> materials;

    public MaterialAdapter(Context context, int resource, List <Material> materials) {
        super (context, resource, materials);
        this.materials = materials;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolderItem(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        Material material = materials.get(position);

        viewHolder.imgArt.setImageResource(material.getImageResource());
        viewHolder.artText.setText((String) material.getName());

        return convertView;
    }

    private class ViewHolderItem {
        final ImageView imgArt;
        final TextView artText;

        ViewHolderItem(View view) {
            imgArt = (ImageView)view.findViewById(R.id.image_art_pr);
            artText = (TextView) view.findViewById(R.id.name_art_pr);
        }
    }
}
