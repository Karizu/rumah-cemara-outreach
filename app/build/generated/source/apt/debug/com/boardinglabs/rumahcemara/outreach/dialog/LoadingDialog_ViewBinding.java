// Generated code from Butter Knife. Do not modify!
package com.boardinglabs.rumahcemara.outreach.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.boardinglabs.rumahcemara.outreach.R;
import com.victor.loading.rotate.RotateLoading;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoadingDialog_ViewBinding implements Unbinder {
  private LoadingDialog target;

  @UiThread
  public LoadingDialog_ViewBinding(LoadingDialog target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoadingDialog_ViewBinding(LoadingDialog target, View source) {
    this.target = target;

    target.rotateLoading = Utils.findRequiredViewAsType(source, R.id.rotate_loading, "field 'rotateLoading'", RotateLoading.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoadingDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rotateLoading = null;
  }
}
