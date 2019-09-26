package in.arjunsn.constraintlayoutdemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileViewActivity extends Fragment {
  private int containerId;
  @BindView(R.id.bg_image) ImageView profileImage;
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    containerId = container.getId();
    return inflater.inflate(R.layout.activity_profile_view, container, false);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    final Bundle bundle = new Bundle();

    super.onActivityCreated(savedInstanceState);
    TextView button_go_2nd = (TextView) getActivity().findViewById(R.id.view_profile_btn);
    profileImage = getActivity().findViewById(R.id.bg_image);
     button_go_2nd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
            showFullDetail();
      }
    });


  }

  public void showFullDetail() {
    Intent detailsIntent = new Intent(getActivity(), ProfileViewActivity2.class);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
      ActivityOptionsCompat optionsCompat =
          ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), profileImage,
              "profile_image");
      startActivity(detailsIntent, optionsCompat.toBundle());
    } else {
      startActivity(detailsIntent);
    }
  }
}
