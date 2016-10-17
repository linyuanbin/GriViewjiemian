package griview.itcast.com.griviewjiemian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{
    private GridView gridView;
    private List<Map<String,Object>> dataList;
    private SimpleAdapter adapter;

    //icon存放图片  图片的id都是int型
    private int [] icon={R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_4, R.drawable.img_5,
            R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,
            R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,
            R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9};

    //存放字
    private  String [] iconName={"通讯录","课堂","教师","学生","机械","Google","百度","文档","照相机",
            "通讯录","课堂","教师","学生","机械","Google","百度","文档","照相机"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
          1. 准备数据
          2, 新建适配器（simpleadapter）
          3.GriView加载适配器
          4.GriView 适配事件监听器（OnIte吗ClickListener）
         */

        gridView=(GridView) findViewById(R.id.gridView);
        dataList=new ArrayList<Map<String,Object>>();
        adapter=new SimpleAdapter(this,getDataList(),R.layout.item,
                new String[]{"image","text"},new int[]{R.id.imageView,R.id.textView});

        gridView.setAdapter(adapter);//夹加载适配器

        //加载点击事件
        gridView.setOnItemClickListener(this);

    }

    public List<Map<String ,Object>> getDataList(){

        for (int i=0;i<icon.length;i++) {
        Map<String ,Object> map=new HashMap<String ,Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            dataList.add(map);
        }
        return dataList;
    }

    //OnItemClickListener接口要实现的方法   点击事件
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {//i代表iconName中的位置从0开始的   (long l)表示id  从0开始

        Toast.makeText(this, "我是"+iconName[i] +" "+l, Toast.LENGTH_SHORT).show();
    }
}
