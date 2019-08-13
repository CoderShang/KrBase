/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.krspace.krdemo.mvp.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;

import com.krspace.krdemo.R;
import com.krspace.krbase.base.BaseHolder;
import com.krspace.krbase.base.DefaultAdapter;
import com.krspace.krdemo.mvp.model.entity.User;
import com.krspace.krdemo.mvp.ui.holder.UserItemHolder;

import java.util.List;

/**
 * ================================================
 * 展示 {@link DefaultAdapter} 的用法
 * <p>
 * Created by J.Shang on 09/04/2016 12:57
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class UserAdapter extends DefaultAdapter<User> {

    public UserAdapter(List<User> infos) {
        super(infos);
    }

    @NonNull
    @Override
    public BaseHolder<User> getHolder(@NonNull View v, int viewType) {
        return new UserItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recycle_list;
    }
}
