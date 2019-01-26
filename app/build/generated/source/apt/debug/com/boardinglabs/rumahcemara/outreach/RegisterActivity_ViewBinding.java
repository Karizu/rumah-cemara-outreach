// Generated code from Butter Knife. Do not modify!
package com.boardinglabs.rumahcemara.outreach;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view2131296580;

  private View view2131296313;

  private View view2131296582;

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
    target.gender = Utils.findRequiredViewAsType(source, R.id.etGender, "field 'gender'", AutoCompleteTextView.class);
    target.institutionName = Utils.findRequiredViewAsType(source, R.id.etIntitutionName, "field 'institutionName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tvSelectPicture, "method 'onClickChangeProfilePhoto'");
    view2131296580 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickChangeProfilePhoto();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnSignUp, "method 'onClickBtnRegister'");
    view2131296313 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickBtnRegister();
      }
    });
    view = Utils.findRequiredView(source, R.id.tvSignIn, "method 'haveAccount'");
    view2131296582 = view;
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
    target.gender = null;
    target.institutionName = null;

    view2131296580.setOnClickListener(null);
    view2131296580 = null;
    view2131296313.setOnClickListener(null);
    view2131296313 = null;
    view2131296582.setOnClickListener(null);
    view2131296582 = null;
  }
}
