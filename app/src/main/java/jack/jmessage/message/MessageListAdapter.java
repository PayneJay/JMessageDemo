package jack.jmessage.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jack.jmessage.R;
import jack.jmessage.message.models.MsgItemBean;

/**
 * ================================================
 * description:
 * ================================================
 * package_name: jack.jmessage.message
 * author: PayneJay
 * date: 2018/7/20.
 */

public class MessageListAdapter extends Adapter {
    private final Context mContext;
    private final List<MsgItemBean> mData = new ArrayList<>();

    public MessageListAdapter(Context context, List<MsgItemBean> data) {
        mContext = context;
        mData.clear();
        mData.addAll(data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = new TextView(mContext);
        textView.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        textView.setLayoutParams(lp);
        return new ItemViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ((TextView) holder.itemView).setText(mData.get(position).getMessage());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext instanceof Activity) {
                    mContext.startActivity(new Intent(mContext, ConversationActivity.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private class ItemViewHolder extends ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
