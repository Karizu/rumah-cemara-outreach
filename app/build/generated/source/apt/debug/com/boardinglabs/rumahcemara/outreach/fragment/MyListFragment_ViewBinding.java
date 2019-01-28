// Generated code from Butter Knife. Do not modify!
package com.boardinglabs.rumahcemara.outreach.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.boardinglabs.rumahcemara.outreach.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyListFragment_ViewBinding implements Unbinder {
  private MyListFragment target;

  private View view2131296402;

  @UiThread
  public MyListFragment_ViewBinding(final MyListFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.imgHistoryAppointment, "method 'onClickHistory'");
    view2131296402 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickHistory();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131296402.setOnClickListener(null);
    view2131296402 = null;
  }
}
