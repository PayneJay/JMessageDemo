package jack.jmessage.message;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jack.jmessage.R;
import jack.jmessage.message.models.MsgItemBean;
import jack.jmessage.utils.ViewFindUtils;

/**
 * ================================================
 * description:
 * ================================================
 * package_name: jack.jmessage
 * author: PayneJay
 * date: 2018/7/20.
 */

public class SimpleCardFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private String mTitle;
    private SwipeRefreshLayout mSwipeLayout;
    private RecyclerView mRecyclerView;
    private MessageListAdapter mAdapter;
    private List<MsgItemBean> mData = new ArrayList<>();

    public static SimpleCardFragment getInstance(String title) {
        SimpleCardFragment sf = new SimpleCardFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message_list_layout, null);
        mSwipeLayout = ViewFindUtils.find(v, R.id.message_swipe_refresh_layout);
        mRecyclerView = ViewFindUtils.find(v, R.id.message_recycler_view);

        initView();
        return v;
    }

    private void initView() {
        int[] colors = getResources().getIntArray(R.array.google_colors);
        mSwipeLayout.setColorSchemeColors(colors);
        mSwipeLayout.setOnRefreshListener(this);

        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        lm.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new MessageListAdapter(getActivity(), getData(5));
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<MsgItemBean> getData(int count) {
        for (int i = 0; i < count; i++) {
            MsgItemBean bean = new MsgItemBean();
            bean.setNickName("Jupiter-" + i);
            bean.setMessage("你好，请问这个房子可以长租吗？你是我服务的方式发生服务服务服务费");
            bean.setTimeStamp("12:08");
            bean.setUnRead(5);
            mData.add(bean);
        }
        return mData;
    }

    @Override
    public void onRefresh() {
        mData.clear();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mData.addAll(getData(10));
            }
        }, 1500);
    }
}
