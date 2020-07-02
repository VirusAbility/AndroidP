package sch.build.androidp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.text.SimpleDateFormat;
import java.util.Date;

import sch.build.androidp.MainActivity;
import sch.build.androidp.R;

public class HomeFragment extends Fragment {
    private ImageView lock;
    private Button selColor;

    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("HH");
    String formatDate = sdfNow.format(date);
    boolean isTime = false;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
        textView.setText(formatDate);

        lock = root.findViewById(R.id.lockDown);
        selColor = root.findViewById(R.id.setColor);

        if(Integer.parseInt(formatDate) > 12) {
            isTime = true;
            lock.setVisibility(View.INVISIBLE);
        } else {
            isTime = false;
            lock.setVisibility(View.VISIBLE);
        }

        selColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTime) { //정해진 시간이 지났을때
                    Toast.makeText(root.getContext(), "설정합니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(root.getContext(), "아직 오늘의 색을 선택할 수 있는 시간이 되지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
}
