package bawei.com.recycleviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;

import com.alibaba.fastjson.JSON;
import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import bawei.com.recycleviewdemo.bean.NewsBean;

public class MainActivity extends Activity implements MainAdapter.OnItemClickListener{

    private IRecyclerView iRecyclerView;

    private MainAdapter adapter;

    private List<NewsBean.ListBean> list=new ArrayList<NewsBean.ListBean>();

    private LinearLayoutManager linearLayoutManager;
    private LoadMoreFooterView loadMoreFooterView;

     int page=1;

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    iRecyclerView.setRefreshing(false);

                    break;
                case 2:

                    loadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);

                    break;
            }
        }
    } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iRecyclerView = (IRecyclerView) findViewById(R.id.iRecyclerView);

        loadMoreFooterView = (LoadMoreFooterView)iRecyclerView.getLoadMoreFooterView();

        adapter=new MainAdapter(MainActivity.this,list);

        initData(true);



//        iRecyclerView.setAdapter(adapter);
      //设置布局管理器
          //false默认 是正序排列 true 是倒序排列   VERTICAL可以设置垂直滚动或者是水平滚动
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        iRecyclerView.setLayoutManager(linearLayoutManager);
        //添加分割线
        iRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());

//添加分割线
//        recyclerView.addItemDecoration
//        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).build());
        iRecyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .color(Color.RED)
//                        .sizeResId(R.dimen.divider)
//                        .marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                        .build());

        iRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        iRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(AbsListView.OnScrollListener.SCROLL_STATE_IDLE == newState){

                    //当前滚动 停止
                    int findLastCompletelyVisibleItemPosition =  linearLayoutManager.findLastCompletelyVisibleItemPosition() ;
                    int findFirstCompletelyVisibleItemPosition =   linearLayoutManager.findFirstCompletelyVisibleItemPosition();

                    int findFirstVisibleItemPosition =  linearLayoutManager.findFirstVisibleItemPosition() ;
                    int findLastVisibleItemPosition =  linearLayoutManager.findLastVisibleItemPosition() ;


                    System.out.println("findLastCompletelyVisibleItemPosition = " + findLastCompletelyVisibleItemPosition);
                    System.out.println("findFirstCompletelyVisibleItemPosition = " + findFirstCompletelyVisibleItemPosition);
                    System.out.println("findFirstVisibleItemPosition = " + findFirstVisibleItemPosition);
                    System.out.println("findLastVisibleItemPosition = " + findLastVisibleItemPosition);

                }


            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });



        iRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {

                list.clear();

                adapter.notifyDataSetChanged();

                initData(true);

//                iRecyclerView.setRefreshing(true);

                handler.sendEmptyMessageDelayed(1,2000);




            }
        });


        iRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                page++;
                initData(false);
                loadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
                handler.sendEmptyMessageDelayed(2,2000);

            }
        });

    }

    private void initData(final boolean flag) {

        //http://qhb.2dyt.com/Bwei/news?postkey=1503d&page=1&type=1
        //RequestParams params = new RequestParams("http://qhb.2dyt.com/Bwei/news?type=2&postkey=1503d&page=1");
        RequestParams params = new RequestParams("http://qhb.2dyt.com/Bwei/news?postkey=1503d&page="+page+"&type=1");

        System.out.println("params ==== " + params);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                NewsBean newsBean = JSON.parseObject(result, NewsBean.class);

                list.addAll(newsBean.getList());

//                adapter=new MainAdapter(MainActivity.this,list);
//                iRecyclerView.setIAdapter(adapter);
                setData(flag);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public void setData(boolean flag) {

        if (flag) {

            iRecyclerView.setIAdapter(adapter);

        } else {

            adapter.notifyDataSetChanged();

        }

    }

    @Override
    public void onItemClickListener(int position, View view) {

//        adapter.add(position);


    }

    @Override
    public void onItemLongClickListener(int position, View view) {

//        adapter.remove(position);

    }
}
