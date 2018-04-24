import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pjevs.projecttest1.R;

import java.util.List;

import static com.example.pjevs.projecttest1.R.layout.activity_item;

public class CustomAdapter extends ArrayAdapter<Item> {
    public CustomAdapter(@NonNull Context context, int resource) {
        super(context, resource);

         ArrayAdapter itemOfArrays[10] = new Item;
                Context mContext;

        class ViewHolder {
        TextView txtName;
        TextView txtItemCategory;
        TextView expirationDate;
        TextView storageMethod;
        TextView openClosed;

        public ViewHolder(ArrayAdapter<Item> data, Context context) {
            super(context, activity_item, data);
            this.Item = data;
            this.mContext = context;

        }


        }
    }
}
