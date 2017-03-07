
#RecyclerView 分割线
> 见本项目中的GridItemDecoration

###RecyclerView禁止滑动
	linearLayoutManager = new LinearLayoutManager(context) {
	 @Override
	 public boolean canScrollVertically() {
	  return false;
	 }
	};
	
###RecyclerView(ListView) 点击条目view，隐藏(显示)控件，实现方式：
    // 用点击position位置对应数组的角标，记录点击位置；
    final String[] s = new String[list.size()];
    reason.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if ((position + "").equals(s[position])) {
                                replayLayout.setVisibility(View.GONE);
                                s[position] = "";
                            } else {
                                s[position] = position + "";
                                replayLayout.setVisibility(View.VISIBLE);
                            }
                            notifyItemChanged(position);
                        }
                    });