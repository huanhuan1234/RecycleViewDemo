package bawei.com.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bawei.com.recycleviewdemo.bean.NewsBean;


public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<NewsBean.ListBean> mList;
    private LayoutInflater inflater;


    //    viewType 定义3中
//    private int header = 0;
//    private int footer = 1 ;

    public MainAdapter(Context context, List<NewsBean.ListBean> list) {

        this.mContext = context;
        this.mList = list;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        if (viewType == 0) {


            View view = inflater.inflate(R.layout.header, parent, false);

            OneViewHolder viewHolder = new OneViewHolder(view);

            return viewHolder;

        } else {
            View view = inflater.inflate(R.layout.footer, parent, false);

            TwoViewHolder viewHolder = new TwoViewHolder(view);

            return viewHolder;
        }


    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof OneViewHolder) {

            OneViewHolder hViewHolder = (OneViewHolder) holder;

            hViewHolder.textView.setText(mList.get(position).getTitle());
            ImageLoader.getInstance().displayImage(mList.get(position).getPic(), hViewHolder.im_one);
        }


        if (holder instanceof TwoViewHolder) {
            TwoViewHolder fViewHolder = (TwoViewHolder) holder;
            NewsBean.ListBean bean = mList.get(position);
            String[] arrPic = bean.getPic().split("\\|");

            fViewHolder.two_textView.setText(mList.get(position).getTitle());

            ImageLoader.getInstance().displayImage(arrPic[0], fViewHolder.im_two1);
            ImageLoader.getInstance().displayImage(arrPic[1], fViewHolder.im_two2);

        }


    }


    @Override
    public int getItemViewType(int position) {
        NewsBean.ListBean listBean = mList.get(position);
        if (listBean.getType() == 1) {
            return 0;
        } else {
            return 1;
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView im_one;

        public OneViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_one);
            im_one = (ImageView) itemView.findViewById(R.id.im_one);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {
        TextView two_textView;
        ImageView im_two1;
        ImageView im_two2;

        public TwoViewHolder(View itemView) {
            super(itemView);
            two_textView = (TextView) itemView.findViewById(R.id.tv_two);
            im_two1 = (ImageView) itemView.findViewById(R.id.im_two1);
            im_two2 = (ImageView) itemView.findViewById(R.id.im_two2);

        }
    }


    interface OnItemClickListener {

        void onItemClickListener(int position, View view);

        void onItemLongClickListener(int position, View view);
    }


    public OnItemClickListener listener;


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


}
