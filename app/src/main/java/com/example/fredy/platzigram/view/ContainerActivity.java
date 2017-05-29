package com.example.fredy.platzigram.view;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.fredy.platzigram.R;
import com.example.fredy.platzigram.view.fragments.HomeFragment;
import com.example.fredy.platzigram.view.fragments.ProfileFragment;
import com.example.fredy.platzigram.view.fragments.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    //Atributos de los componentes
    private BottomBar bottomBar;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        //metodos a llamar
        llamandobottombar();

        //setToolbar(getResources().getString(R.string.Home));
    }

    //soporte a toolbar
  /*  public void setToolbar(String tittle){
        toolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
    }
*/
    public void llamandobottombar(){
        bottomBar =(BottomBar)findViewById(R.id.my_bootombar);

        //fragment que se mostrara por default
        bottomBar.setDefaultTab(R.id.tab_home);

        //escuchando cualquier click en un tab
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tab_home:
                        //Llamando al fragment de home
                        HomeFragment homefragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.my_container,homefragment)
                             .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();
                        break;
                    case R.id.tab_buscar:
                        //Llamando al fragment de buscar
                        SearchFragment searchfragment = new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.my_container,searchfragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.tab_profile:
                        //Llamando al fragment de perfil
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.my_container,profileFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }
            }
        });
    }


}
