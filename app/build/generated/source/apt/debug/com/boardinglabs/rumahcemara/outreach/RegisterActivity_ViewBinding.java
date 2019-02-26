// Generated code from Butter Knife. Do not modify!
package com.boardinglabs.rumahcemara.outreach;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view2131362143;

  private View view2131361850;

  private View view2131362145;

  @UiThread
  public RegisterActivity_ViewBinding(RegisterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterActivity_ViewBinding(final RegisterActivity target, View source) {
    this.target = target;

    View view;
    target.fullname = Utils.findRequiredViewAsType(source, R.id.etName, "field 'fullname'", EditText.class);
    target.birthDate = Utils.findRequiredViewAsType(source, R.id.etBirthDay, "field 'birthDate'", EditText.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.etEmail, "field 'email'", EditText.class);
    target.username = Utils.findRequiredViewAsType(source, R.id.etUsername, "field 'username'", EditText.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.etPassword, "field 'password'", EditText.class);
    target.sGender = Utils.findRequiredViewAsType(source, R.id.spinnerGender, "field 'sGender'", Spinner.class);
    target.etImgProfile = Utils.findRequiredViewAsType(source, R.id.imgProfile, "field 'etImgProfile'", ImageView.class);
    target.institutionName = Utils.findRequiredViewAsType(source, R.id.spinnerInstitution, "field 'institutionName'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.tvSelectPicture, "method 'onClickChangeProfilePhoto'");
    view2131362143 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickChangeProfilePhoto();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnSignUp, "method 'onClickBtnRegister'");
    view2131361850 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickBtnRegister();
      }
    });
    view = Utils.findRequiredView(source, R.id.tvSignIn, "method 'haveAccount'");
    view2131362145 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.haveAccount();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    RegisterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fullname = null;
    target.birthDate = null;
    target.email = null;
    target.username = null;
    target.password = null;
    target.sGender = null;
    target.etImgProfile = null;
    target.institutionName = null;

    view2131362143.setOnClickListener(null);
    view2131362143 = null;
    view2131361850.setOnClickListener(null);
    view2131361850 = null;
    view2131362145.setOnClickListener(null);
    view2131362145 = null;
  }
}
