package jack.jmessage.message;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

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
    private Context mContext;
    private List<MsgItemBean> mData = new ArrayList<>();

    public MessageListAdapter(Context context, List<MsgItemBean> data) {
        mContext = context;
        mData.clear();
        mData.addAll(data);
    }

    public void setData(List<MsgItemBean> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_message_list_layout, parent, false);
        return new ItemViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).sdvAvatar.setImageURI(mData.get(position).getAvatarUrl());
            ((ItemViewHolder) holder).tvMsg.setText(mData.get(position).getMessage());
            ((ItemViewHolder) holder).tvDate.setText(mData.get(position).getTimeStamp());
            ((ItemViewHolder) holder).tvNickName.setText(mData.get(position).getNickName());
            ((ItemViewHolder) holder).tvUnRead.setText(mData.get(position).getUnRead() + "");

        }
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
        public SimpleDraweeView sdvAvatar;
        public TextView tvUnRead;
        public TextView tvNickName;
        public TextView tvDate;
        public TextView tvMsg;

        public ItemViewHolder(View itemView) {
            super(itemView);

            sdvAvatar = itemView.findViewById(R.id.msg_item_sdv_avatar);
            tvUnRead = itemView.findViewById(R.id.msg_item_tv_unread);
            tvNickName = itemView.findViewById(R.id.msg_item_tv_nickname);
            tvDate = itemView.findViewById(R.id.msg_item_tv_date);
            tvMsg = itemView.findViewById(R.id.msg_item_tv_message);
        }
    }
}
