// Generated code from Butter Knife. Do not modify!
package com.boardinglabs.rumahcemara.outreach;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RequestDetailActivity_ViewBinding implements Unbinder {
  private RequestDetailActivity target;

  private View view2131296307;

  @UiThread
  public RequestDetailActivity_ViewBinding(RequestDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RequestDetailActivity_ViewBinding(final RequestDetailActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnAccAppointment, "method 'onClickButton'");
    view2131296307 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickButton();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131296307.setOnClickListener(null);
    view2131296307 = null;
  }
}
