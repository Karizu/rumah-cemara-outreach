// Generated code from Butter Knife. Do not modify!
package com.boardinglabs.rumahcemara.outreach.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.boardinglabs.rumahcemara.outreach.R;
import com.mikhaellopez.circularimageview.CircularImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OptionsFragment_ViewBinding implements Unbinder {
  private OptionsFragment target;

  @UiThread
  public OptionsFragment_ViewBinding(OptionsFragment target, View source) {
    this.target = target;

    target.imageProfile = Utils.findRequiredViewAsType(source, R.id.imgProfile, "field 'imageProfile'", CircularImageView.class);
    target.editAccount = Utils.findRequiredViewAsType(source, R.id.tvEdit, "field 'editAccount'", TextView.class);
    target.prNoHp = Utils.findRequiredViewAsType(source, R.id.tvPhoneNumber, "field 'prNoHp'", TextView.class);
    target.prFullname = Utils.findRequiredViewAsType(source, R.id.tvName, "field 'prFullname'", TextView.class);
    target.prUsername = Utils.findRequiredViewAsType(source, R.id.tvUsername, "field 'prUsername'", TextView.class);
    target.prSignOut = Utils.findRequiredViewAsType(source, R.id.tvSignOut, "field 'prSignOut'", TextView.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OptionsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageProfile = null;
    target.editAccount = null;
    target.prNoHp = null;
    target.prFullname = null;
    target.prUsername = null;
    target.prSignOut = null;
    target.mToolbar = null;
  }
}
