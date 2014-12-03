package com.ListaGenerica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by rolandoantonio on 12-03-14.
 */


public class GenericList extends BaseAdapter {


    private List<?> LISTA_ ;
    private Context CONTEXT_;
    private int LAYOUT_;
    private int OBJVIEW_;


    public GenericList(Context context , List<?> list , int LayoutLocation , int ViewObjective)
    {
        super();
        this.LISTA_ = list;
        this.CONTEXT_ = context;
        this.LAYOUT_ = LayoutLocation;
        this.OBJVIEW_ = ViewObjective;
    }

    @Override
    public int getCount() {
        return this.LISTA_.size();
    }

    @Override
    public Object getItem(int i) {
        return this.LISTA_.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final Object data = (String) this.getItem(i);

        if(view == null && this.CONTEXT_ != null)
        {
            LayoutInflater inflater = (LayoutInflater) this.CONTEXT_.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(this.LAYOUT_ , null);
        }

        TextView  txt = (TextView) view.findViewById(this.OBJVIEW_);
        txt.setText(data.toString());

        return view;
    }
}
