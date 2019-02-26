// Generated code from Butter Knife. Do not modify!
package com.boardinglabs.rumahcemara.outreach;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditAccountActivity_ViewBinding implements Unbinder {
  private EditAccountActivity target;

  private View view2131362122;

  private View view2131361846;

  @UiThread
  public EditAccountActivity_ViewBinding(EditAccountActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditAccountActivity_ViewBinding(final EditAccountActivity target, View source) {
    this.target = target;

    View view;
    target.etFullname = Utils.findRequiredViewAsType(source, R.id.etEditName, "field 'etFullname'", EditText.class);
    target.etPhoneNumber = Utils.findRequiredViewAsType(source, R.id.etEditPhoneNumber, "field 'etPhoneNumber'", EditText.class);
    target.etUser = Utils.findRequiredViewAsType(source, R.id.etEditUsername, "field 'etUser'", EditText.class);
    target.etImgProfile = Utils.findRequiredViewAsType(source, R.id.imgEditProfile, "field 'etImgProfile'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.tvChangePhoto, "field 'tvChangePhoto' and method 'onClickChangeProfilePhoto'");
    target.tvChangePhoto = Utils.castView(view, R.id.tvChangePhoto, "field 'tvChangePhoto'", TextView.class);
    view2131362122 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickChangeProfilePhoto();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnEditSave, "method 'updateProfile'");
    view2131361846 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.updateProfile();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    EditAccountActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etFullname = null;
    target.etPhoneNumber = null;
    target.etUser = null;
    target.etImgProfile = null;
    target.tvChangePhoto = null;

    view2131362122.setOnClickListener(null);
    view2131362122 = null;
    view2131361846.setOnClickListener(null);
    view2131361846 = null;
  }
}
