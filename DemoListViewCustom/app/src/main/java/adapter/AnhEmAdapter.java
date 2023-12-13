package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import model.AnhEm;
import vn.edu.stu.demolistviewcustom.R;

public class AnhEmAdapter extends ArrayAdapter<AnhEm> {
    Activity context;
    int resource;
    List<AnhEm> objects;

    public AnhEmAdapter(@NonNull Activity context, int resource, @NonNull List<AnhEm> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;
        //Nap giao dien tu tai nguyen vao bien view
        LayoutInflater inflater = this.context.getLayoutInflater();
        if (position % 2 == 0) {
            view = inflater.inflate(R.layout.item_anhemchan, null); // nap vao bien view
        }else {
            view = inflater.inflate(R.layout.item_anhemle, null);
        }
        TextView tvTen = view.findViewById(R.id.tvTen);
        TextView tvTuoi = view.findViewById(R.id.tvTuoi);
        AnhEm ae = this.objects.get(position); // vi tri anh em hien tai
        tvTen.setText(ae.getTen());
        tvTuoi .setText(ae.getTuoi() + "");
        return view;
    }
}
