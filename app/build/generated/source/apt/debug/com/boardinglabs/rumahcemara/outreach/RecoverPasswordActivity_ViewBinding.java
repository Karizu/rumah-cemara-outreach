// Generated code from Butter Knife. Do not modify!
package com.boardinglabs.rumahcemara.outreach;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecoverPasswordActivity_ViewBinding implements Unbinder {
  private RecoverPasswordActivity target;

  private View view2131362024;

  @UiThread
  public RecoverPasswordActivity_ViewBinding(RecoverPasswordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RecoverPasswordActivity_ViewBinding(final RecoverPasswordActivity target, View source) {
    this.target = target;

    View view;
    target.email = Utils.findRequiredViewAsType(source, R.id.emailTextInputEditText, "field 'email'", TextInputEditText.class);
    target.number = Utils.findRequiredViewAsType(source, R.id.numberTextInputEditText, "field 'number'", TextInputEditText.class);
    target.newPassword = Utils.findRequiredViewAsType(source, R.id.passwordTextInputEditText, "field 'newPassword'", TextInputEditText.class);
    view = Utils.findRequiredView(source, R.id.recover_btn, "method 'doRecover'");
    view2131362024 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.doRecover();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    RecoverPasswordActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.email = null;
    target.number = null;
    target.newPassword = null;

    view2131362024.setOnClickListener(null);
    view2131362024 = null;
  }
}
