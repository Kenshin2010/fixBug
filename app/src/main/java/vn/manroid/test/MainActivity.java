package vn.manroid.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ConstructionSpnAdapter constructionSpnAdapter;
    private List<AppParamDTO> listAppParam;
    private List<AppParamDTO> listSpn;
    private SpinnerAdapter spinnerAdapter;
    private AppParamDTO appParamDTO;
    private Spinner spinner;
    private RecyclerView recyclerView;
    private EditText editText;
    private boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcv_construction_spn);
        editText = findViewById(R.id.edt_amount);
        spinner = findViewById(R.id.spn_construction);


        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appParamDTO = (AppParamDTO) spinner.getSelectedItem();
                if (listAppParam.size() == 0) {
                    String amount = editText.getText().toString().trim();
                    appParamDTO.setAmount(amount);
                    listAppParam.add(0, appParamDTO);
                    constructionSpnAdapter.notifyItemInserted(0);
                    constructionSpnAdapter.notifyItemRangeChanged(0, listAppParam.size());
                    editText.setText("");
                } else {
                    for (int i = 0; i < listAppParam.size(); i++) {
                        if (listAppParam.get(i).getName().equals(appParamDTO.getName())) {
                            String amount = editText.getText().toString().trim();
                            appParamDTO.setAmount(amount);
                            constructionSpnAdapter.notifyItemChanged(i);
                            constructionSpnAdapter.notifyItemRangeChanged(0, listAppParam.size());
                            editText.setText("");
                            check = true;
                            return;
                        }
                    }

                    if (check) {
                        String amount = editText.getText().toString().trim();
                        appParamDTO.setAmount(amount);
                        listAppParam.add(0, appParamDTO);
                        constructionSpnAdapter.notifyItemInserted(0);
                        constructionSpnAdapter.notifyItemRangeChanged(0, listAppParam.size());
                        editText.setText("");
                        check = false;
                    }
                }


//                if (listAppParam.size() == 0){
//                    appParamDTO = (AppParamDTO) spinner.getSelectedItem();
//                    String amount = editText.getText().toString().trim();
//                    appParamDTO.setAmount(amount);
//                    listAppParam.add(0, appParamDTO);
//                    constructionSpnAdapter.notifyItemInserted(0);
//                    constructionSpnAdapter.notifyItemRangeChanged(0,listAppParam.size());
//                    editText.setText("");
//                }else {
//                    for (int i = 0; i < listAppParam.size(); i++) {
//                        if (listAppParam.get(i).getName().equals(appParamDTO.getName())){
//                            appParamDTO = (AppParamDTO) spinner.getSelectedItem();
//                            String amount = editText.getText().toString().trim();
//                            appParamDTO.setAmount(amount);
//                            constructionSpnAdapter.notifyItemChanged(i);
//                            constructionSpnAdapter.notifyItemRangeChanged(0,listAppParam.size());
//                            editText.setText("");
//                        }
//                    }
//                }


            }
        });


        listAppParam = new ArrayList<>();
        listSpn = new ArrayList<>();

        AppParamDTO appParamDTO = new AppParamDTO();
        AppParamDTO appParamDTO2 = new AppParamDTO();
        AppParamDTO appParamDTO3 = new AppParamDTO();

        appParamDTO.setName("Test 1");
        appParamDTO2.setName("Test 2");
        appParamDTO3.setName("Test 3");

        listSpn.add(appParamDTO);
        listSpn.add(appParamDTO2);
        listSpn.add(appParamDTO3);

        constructionSpnAdapter = new ConstructionSpnAdapter(this, listAppParam);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager2);
        recyclerView.setAdapter(constructionSpnAdapter);

        spinnerAdapter = new vn.manroid.test.SpinnerAdapter(MainActivity.this, listSpn);
        spinner.setAdapter(spinnerAdapter);


    }
}
