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

public class DetailAppointmentActivity_ViewBinding implements Unbinder {
  private DetailAppointmentActivity target;

  private View view2131296309;

  @UiThread
  public DetailAppointmentActivity_ViewBinding(DetailAppointmentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailAppointmentActivity_ViewBinding(final DetailAppointmentActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btnEndAppointment, "method 'onClickEndAppointment'");
    view2131296309 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickEndAppointment();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131296309.setOnClickListener(null);
    view2131296309 = null;
  }
}
