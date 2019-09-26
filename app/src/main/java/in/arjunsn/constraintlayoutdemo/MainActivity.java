package in.arjunsn.constraintlayoutdemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
  private Fragment fragment;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BottomNavigationView bottomNavigationView = (BottomNavigationView)
            findViewById(R.id.bt_nav_view);

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction().replace(R.id.container_nav_bt,
              new ProfileViewActivity()).commit();
      bottomNavigationView.setSelectedItemId(R.id.nav_bt_home);
    }

    bottomNavigationView.setOnNavigationItemSelectedListener(
            new BottomNavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                  case R.id.nav_bt_home:
                    fragment = new ProfileViewActivity();
                    break;
                  case R.id.nav_bt_info:
                    fragment = new ProfileViewScrollActivity();
                    break;
                  case R.id.nav_bt_list:
                    fragment = new FeedActivity();
                    break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container_nav_bt,
                        fragment).commit();
                return true;
              }
            });

  }
}