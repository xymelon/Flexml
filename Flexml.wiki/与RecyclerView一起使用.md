如果你要在RecyclerView中使用，你的Adapter应该这么写。
```kotlin
            override fun onBindViewHolder(
                    holder: HostingViewHolder,
                    position: Int
            ) {
                val page = pages[pos]
                holder.hostingView.templatePage = page
            }

            override fun onViewRecycled(holder: HostingViewHolder) {
                //下面这两行很关键，涉及到资源的正确回收，一定不能不写
                holder.hostingView.unmountAllItems()
                holder.hostingView.templatePage = null
            }
```