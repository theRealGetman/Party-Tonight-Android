package app.media.opp.partytonight.presentation.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import javax.inject.Inject;

import app.media.opp.partytonight.R;
import app.media.opp.partytonight.presentation.PartyTonightApplication;
import app.media.opp.partytonight.presentation.presenters.SignUpPresenter;
import app.media.opp.partytonight.presentation.utils.ActivityNavigator;
import app.media.opp.partytonight.presentation.utils.FieldsUtils;
import app.media.opp.partytonight.presentation.views.ICredentialView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PromoterSignUpActivity extends ProgressActivity implements ICredentialView {

    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPhoneNumber)
    EditText etPhoneNumber;
    @BindView(R.id.etBillingInfo)
    EditText etBillingInfo;
    @BindView(R.id.etEmergencyContact)
    EditText etEmergencyContact;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @Inject
    SignUpPresenter presenter;
    private ActivityNavigator activityNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoter_sign_up);
        ButterKnife.bind(this);
        PartyTonightApplication.getApp(this).getUserComponent().inject(this);
        activityNavigator = new ActivityNavigator();
        presenter.onCreate(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onRelease();
        super.onDestroy();
    }

    @OnClick(R.id.bSignUp)
    public void onClick() {
        String name = etName.getText().toString().trim().replace("  ", " ");
        String email = etEmail.getText().toString();
        String phone = etPhoneNumber.getText().toString();
        String password = etPassword.getText().toString();
        String billingInfo = etBillingInfo.getText().toString();
        String emergencyContact = etEmergencyContact.getText().toString();

        if (isValid(name, email, phone, password, billingInfo, emergencyContact)) {
            presenter.onSignUpButtonClick(name, email, phone, password, billingInfo, emergencyContact);
        }
    }

    private boolean isValid(String name, String email, String phone, String password, String billingInfo, String emergencyContact) {

        boolean isValidName = false;
        if (name.isEmpty()) {
            showFieldError(etName, getString(R.string.fieldShoudNotBeEmpty));
        } else if (!FieldsUtils.isValidString(FieldsUtils.NAME_VALID_SYMBOLS, name)) {
            showFieldError(etName, getString(R.string.fieldContainsInvalidCharacters));
        } else {
            isValidName = true;
        }

        boolean isValidPhone = false;
        if (phone.isEmpty()) {
            showFieldError(etPhoneNumber, getString(R.string.fieldShoudNotBeEmpty));
        } else if (!FieldsUtils.isValidString(FieldsUtils.PHONE_VALID_SYMBOLS, phone)) {
            showFieldError(etPhoneNumber, getString(R.string.fieldContainsInvalidCharacters));
        } else {
            isValidPhone = true;
        }

        boolean isValidBilling = false;
        if (billingInfo.isEmpty()) {
            showFieldError(etBillingInfo, getString(R.string.fieldShoudNotBeEmpty));
        } else if (!FieldsUtils.isValidString(FieldsUtils.BILLING_VALID_SYMBOLS, billingInfo)) {
            showFieldError(etBillingInfo, getString(R.string.fieldContainsInvalidCharacters));
        } else {
            isValidBilling = true;
        }

        boolean isValidEmergencyContact = false;
        if (emergencyContact.isEmpty()) {
            showFieldError(etEmergencyContact, getString(R.string.fieldShoudNotBeEmpty));
        } else if (!FieldsUtils.isValidString(FieldsUtils.CONTACT_VALID_SYMBOLS, emergencyContact)) {
            showFieldError(etEmergencyContact, getString(R.string.fieldContainsInvalidCharacters));
        } else {
            isValidEmergencyContact = true;
        }

        boolean isValidEmail = false;
        if (email.isEmpty()) {
            showFieldError(etEmail, getString(R.string.fieldShoudNotBeEmpty));
        } else if (!FieldsUtils.hasProperLength(email)) {
            showFieldError(etEmail, getString(R.string.minimumLengthIs) + " " + FieldsUtils.MIN_LENGTH);
        } else if (!FieldsUtils.isValidString(FieldsUtils.EMAIL_VALID_SYMBOLS, email)) {
            showFieldError(etEmail, getString(R.string.fieldContainsInvalidCharacters));
        } else if (!email.contains("@")) {
            showFieldError(etEmail, getString(R.string.fieldDoesNotContainEt));
        } else if (!email.contains(".")) {
            showFieldError(etEmail, getString(R.string.fieldDoesNotContainDot));
        } else {
            isValidEmail = true;
        }

        boolean isValidPassword = false;
        if (password.isEmpty()) {
            showFieldError(etPassword, getString(R.string.fieldShoudNotBeEmpty));
        } else if (!FieldsUtils.hasProperLength(password)) {
            showFieldError(etPassword, getString(R.string.minimumLengthIs) + " " + FieldsUtils.MIN_LENGTH);
        } else if (!FieldsUtils.isValidString(FieldsUtils.PASSWORD_VALID_SYMBOLS, password)) {
            showFieldError(etPassword, getString(R.string.passwordShouldContainOnlyLettersAndDigits));
        } else {
            isValidPassword = true;
        }
        return isValidBilling && isValidEmail && isValidEmergencyContact && isValidName && isValidPassword && isValidPhone;
    }


    private void showFieldError(EditText editText, String error) {
        Log.e("SignIn", "error " + error);

        editText.setError(error);
    }

    @Override
    public void navigateToProfile() {
        activityNavigator.startMainActivity(this, true);
    }
}
