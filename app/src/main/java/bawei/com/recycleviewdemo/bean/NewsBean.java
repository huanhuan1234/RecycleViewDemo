package bawei.com.recycleviewdemo.bean;

import java.util.List;

/**
 * Created by huanhuan on 2017/4/21.
 */
public class NewsBean {

    /**
     * ret_code : 200
     * ret_msg : ok
     * listViewPager : ["https://img10.360buyimg.com/da/jfs/t4747/277/1368712300/170619/35098d7f/58f038e0N9b3a0ca5.jpg","https://img14.360buyimg.com/da/jfs/t4915/21/1427207714/81116/b005bb06/58f08963Ndb295b3c.jpg","https://img13.360buyimg.com/da/jfs/t4651/104/2867456043/68336/99da4c16/58f41eaeN5b614a63.jpg"]
     * list : [{"date":"2小时前","id":2,"pic":"http://img2.imgtn.bdimg.com/it/u=819201812,3553302270&fm=214&gp=0.jpg","title":"明星和岳父的合影曝光：吴奇隆刘强东真尴尬，王祖蓝真心不容易~","type":1},{"date":"1小时前","id":3,"pic":"http://img02.tooopen.com/images/20140504/sy_60294738471.jpg","title":"《人民的名义》观后感：郑胜利居心不良，高育良地下情曝光","type":1},{"date":"7小时前","id":8,"pic":"http://pic7.nipic.com/20100517/3409334_180613088650_2.jpg|http://pic9.nipic.com/20100820/2531170_182750402288_2.jpg|http://pic1a.nipic.com/2008-10-07/20081079019381_2.jpg","title":"镜头中的中朝边境，两人背对背却在不同的国家","type":2},{"date":"8小时前","id":9,"pic":"http://img4.imgtn.bdimg.com/it/u=486623575,86214171&fm=23&gp=0.jpg|http://img4.imgtn.bdimg.com/it/u=3917409467,3977631285&fm=23&gp=0.jpg|http://img2.imgtn.bdimg.com/it/u=2763715957,3251390351&fm=23&gp=0.jpg","title":" \n美女隐居山林20年，生活清苦似原始人，变成大妈终不悔","type":2},{"date":"9小时前","id":10,"pic":"http://img0.imgtn.bdimg.com/it/u=105550316,1243681444&fm=23&gp=0.jpg|http://img2.imgtn.bdimg.com/it/u=3108305815,518549389&fm=23&gp=0.jpg|http://img2.imgtn.bdimg.com/it/u=2236312605,3722185191&fm=23&gp=0.jpg","title":"镜头下：1976年唐山发生7.8级大地震后的真实写照","type":2},{"date":"9分钟前","id":14,"pic":"http://p3.pstatp.com/list/190x124/1bf6000d3aa7569f07e4","title":" \n梁洛施带儿子返港，李嘉诚每年见孙子两次，李泽楷反对前女友定居\n \n梁洛施带儿子返港，李嘉诚每年见孙子两次，李泽楷反对前女友定居\n \n梁洛施带儿子返港，李嘉诚每年见孙子两次，李泽楷反对前女友定居","type":1},{"date":"10分钟前","id":16,"pic":"http://p3.pstatp.com/list/190x124/1cbc0003cf55a3003467|http://p3.pstatp.com/list/190x124/1cbc0003cf53e713d90e|http://p3.pstatp.com/list/190x124/1bc30008ed9744c2c34b","title":"90后女孩辞职做代孕赚20万 供两个妹妹上大学","type":2},{"date":"1分钟前","id":18,"pic":"http://p3.pstatp.com/list/190x124/e5900054f8a11fc5960","title":"深圳男子被吃脑虫入侵去世，哪些食物最危险含寄生虫?","type":1},{"date":"9小时前","id":20,"pic":"http://p1.pstatp.com/list/190x124/18a10004f6a0fb66f371","title":" \n100万元人民币的现金到底有多重？","type":1}]
     */

    private int ret_code;
    private String ret_msg;
    private List<String> listViewPager;
    private List<ListBean> list;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public List<String> getListViewPager() {
        return listViewPager;
    }

    public void setListViewPager(List<String> listViewPager) {
        this.listViewPager = listViewPager;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * date : 2小时前
         * id : 2
         * pic : http://img2.imgtn.bdimg.com/it/u=819201812,3553302270&fm=214&gp=0.jpg
         * title : 明星和岳父的合影曝光：吴奇隆刘强东真尴尬，王祖蓝真心不容易~
         * type : 1
         */

        private String date;
        private int id;
        private String pic;
        private String title;
        private int type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
