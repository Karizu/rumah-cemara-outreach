package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy extends com.boardinglabs.rumahcemara.outreach.models.Profile
    implements RealmObjectProxy, com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface {

    static final class ProfileColumnInfo extends ColumnInfo {
        long userIdIndex;
        long groupIdIndex;
        long fullnameIndex;
        long phoneNumberIndex;
        long birthPlaceIndex;
        long birthDateIndex;
        long emailIndex;
        long addressIndex;
        long pictureIndex;
        long hobbyIndex;
        long cityIndex;
        long workIndex;
        long whatsupNumberIndex;
        long lineAccountIndex;
        long pinBbmIndex;
        long facebookAccountIndex;
        long twitterAccountIndex;
        long shirtSizeIndex;
        long groupIndex;
        long privacyConfigIndex;
        long instagramAccountIndex;

        ProfileColumnInfo(OsSchemaInfo schemaInfo) {
            super(21);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Profile");
            this.userIdIndex = addColumnDetails("userId", "userId", objectSchemaInfo);
            this.groupIdIndex = addColumnDetails("groupId", "groupId", objectSchemaInfo);
            this.fullnameIndex = addColumnDetails("fullname", "fullname", objectSchemaInfo);
            this.phoneNumberIndex = addColumnDetails("phoneNumber", "phoneNumber", objectSchemaInfo);
            this.birthPlaceIndex = addColumnDetails("birthPlace", "birthPlace", objectSchemaInfo);
            this.birthDateIndex = addColumnDetails("birthDate", "birthDate", objectSchemaInfo);
            this.emailIndex = addColumnDetails("email", "email", objectSchemaInfo);
            this.addressIndex = addColumnDetails("address", "address", objectSchemaInfo);
            this.pictureIndex = addColumnDetails("picture", "picture", objectSchemaInfo);
            this.hobbyIndex = addColumnDetails("hobby", "hobby", objectSchemaInfo);
            this.cityIndex = addColumnDetails("city", "city", objectSchemaInfo);
            this.workIndex = addColumnDetails("work", "work", objectSchemaInfo);
            this.whatsupNumberIndex = addColumnDetails("whatsupNumber", "whatsupNumber", objectSchemaInfo);
            this.lineAccountIndex = addColumnDetails("lineAccount", "lineAccount", objectSchemaInfo);
            this.pinBbmIndex = addColumnDetails("pinBbm", "pinBbm", objectSchemaInfo);
            this.facebookAccountIndex = addColumnDetails("facebookAccount", "facebookAccount", objectSchemaInfo);
            this.twitterAccountIndex = addColumnDetails("twitterAccount", "twitterAccount", objectSchemaInfo);
            this.shirtSizeIndex = addColumnDetails("shirtSize", "shirtSize", objectSchemaInfo);
            this.groupIndex = addColumnDetails("group", "group", objectSchemaInfo);
            this.privacyConfigIndex = addColumnDetails("privacyConfig", "privacyConfig", objectSchemaInfo);
            this.instagramAccountIndex = addColumnDetails("instagramAccount", "instagramAccount", objectSchemaInfo);
        }

        ProfileColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProfileColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProfileColumnInfo src = (ProfileColumnInfo) rawSrc;
            final ProfileColumnInfo dst = (ProfileColumnInfo) rawDst;
            dst.userIdIndex = src.userIdIndex;
            dst.groupIdIndex = src.groupIdIndex;
            dst.fullnameIndex = src.fullnameIndex;
            dst.phoneNumberIndex = src.phoneNumberIndex;
            dst.birthPlaceIndex = src.birthPlaceIndex;
            dst.birthDateIndex = src.birthDateIndex;
            dst.emailIndex = src.emailIndex;
            dst.addressIndex = src.addressIndex;
            dst.pictureIndex = src.pictureIndex;
            dst.hobbyIndex = src.hobbyIndex;
            dst.cityIndex = src.cityIndex;
            dst.workIndex = src.workIndex;
            dst.whatsupNumberIndex = src.whatsupNumberIndex;
            dst.lineAccountIndex = src.lineAccountIndex;
            dst.pinBbmIndex = src.pinBbmIndex;
            dst.facebookAccountIndex = src.facebookAccountIndex;
            dst.twitterAccountIndex = src.twitterAccountIndex;
            dst.shirtSizeIndex = src.shirtSizeIndex;
            dst.groupIndex = src.groupIndex;
            dst.privacyConfigIndex = src.privacyConfigIndex;
            dst.instagramAccountIndex = src.instagramAccountIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ProfileColumnInfo columnInfo;
    private ProxyState<com.boardinglabs.rumahcemara.outreach.models.Profile> proxyState;

    com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProfileColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.boardinglabs.rumahcemara.outreach.models.Profile>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userIdIndex);
    }

    @Override
    public void realmSet$userId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.userIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$groupId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.groupIdIndex);
    }

    @Override
    public void realmSet$groupId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.groupIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.groupIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.groupIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.groupIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fullname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fullnameIndex);
    }

    @Override
    public void realmSet$fullname(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fullnameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fullnameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fullnameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fullnameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$phoneNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phoneNumberIndex);
    }

    @Override
    public void realmSet$phoneNumber(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phoneNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.phoneNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phoneNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.phoneNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$birthPlace() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.birthPlaceIndex);
    }

    @Override
    public void realmSet$birthPlace(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.birthPlaceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.birthPlaceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.birthPlaceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.birthPlaceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$birthDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.birthDateIndex);
    }

    @Override
    public void realmSet$birthDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.birthDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.birthDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.birthDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.birthDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$address() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressIndex);
    }

    @Override
    public void realmSet$address(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addressIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$picture() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pictureIndex);
    }

    @Override
    public void realmSet$picture(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.pictureIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.pictureIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pictureIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.pictureIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$hobby() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.hobbyIndex);
    }

    @Override
    public void realmSet$hobby(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.hobbyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.hobbyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.hobbyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.hobbyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$city() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cityIndex);
    }

    @Override
    public void realmSet$city(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$work() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.workIndex);
    }

    @Override
    public void realmSet$work(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.workIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.workIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.workIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.workIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$whatsupNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.whatsupNumberIndex);
    }

    @Override
    public void realmSet$whatsupNumber(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.whatsupNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.whatsupNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.whatsupNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.whatsupNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$lineAccount() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lineAccountIndex);
    }

    @Override
    public void realmSet$lineAccount(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.lineAccountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.lineAccountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lineAccountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.lineAccountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$pinBbm() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pinBbmIndex);
    }

    @Override
    public void realmSet$pinBbm(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.pinBbmIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.pinBbmIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pinBbmIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.pinBbmIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$facebookAccount() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.facebookAccountIndex);
    }

    @Override
    public void realmSet$facebookAccount(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.facebookAccountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.facebookAccountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.facebookAccountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.facebookAccountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$twitterAccount() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.twitterAccountIndex);
    }

    @Override
    public void realmSet$twitterAccount(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.twitterAccountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.twitterAccountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.twitterAccountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.twitterAccountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$shirtSize() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.shirtSizeIndex);
    }

    @Override
    public void realmSet$shirtSize(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.shirtSizeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.shirtSizeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.shirtSizeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.shirtSizeIndex, value);
    }

    @Override
    public com.boardinglabs.rumahcemara.outreach.models.Group realmGet$group() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.groupIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.boardinglabs.rumahcemara.outreach.models.Group.class, proxyState.getRow$realm().getLink(columnInfo.groupIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$group(com.boardinglabs.rumahcemara.outreach.models.Group value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("group")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.groupIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.groupIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.groupIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.groupIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$privacyConfig() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.privacyConfigIndex);
    }

    @Override
    public void realmSet$privacyConfig(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.privacyConfigIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.privacyConfigIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.privacyConfigIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.privacyConfigIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$instagramAccount() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.instagramAccountIndex);
    }

    @Override
    public void realmSet$instagramAccount(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.instagramAccountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.instagramAccountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.instagramAccountIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.instagramAccountIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Profile", 21, 0);
        builder.addPersistedProperty("userId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("groupId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fullname", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("phoneNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("birthPlace", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("birthDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("picture", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("hobby", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("city", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("work", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("whatsupNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("lineAccount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("pinBbm", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("facebookAccount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("twitterAccount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("shirtSize", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("group", RealmFieldType.OBJECT, "Group");
        builder.addPersistedProperty("privacyConfig", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("instagramAccount", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ProfileColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ProfileColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Profile";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Profile";
    }

    @SuppressWarnings("cast")
    public static com.boardinglabs.rumahcemara.outreach.models.Profile createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("group")) {
            excludeFields.add("group");
        }
        com.boardinglabs.rumahcemara.outreach.models.Profile obj = realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.Profile.class, true, excludeFields);

        final com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) obj;
        if (json.has("userId")) {
            if (json.isNull("userId")) {
                objProxy.realmSet$userId(null);
            } else {
                objProxy.realmSet$userId((String) json.getString("userId"));
            }
        }
        if (json.has("groupId")) {
            if (json.isNull("groupId")) {
                objProxy.realmSet$groupId(null);
            } else {
                objProxy.realmSet$groupId((String) json.getString("groupId"));
            }
        }
        if (json.has("fullname")) {
            if (json.isNull("fullname")) {
                objProxy.realmSet$fullname(null);
            } else {
                objProxy.realmSet$fullname((String) json.getString("fullname"));
            }
        }
        if (json.has("phoneNumber")) {
            if (json.isNull("phoneNumber")) {
                objProxy.realmSet$phoneNumber(null);
            } else {
                objProxy.realmSet$phoneNumber((String) json.getString("phoneNumber"));
            }
        }
        if (json.has("birthPlace")) {
            if (json.isNull("birthPlace")) {
                objProxy.realmSet$birthPlace(null);
            } else {
                objProxy.realmSet$birthPlace((String) json.getString("birthPlace"));
            }
        }
        if (json.has("birthDate")) {
            if (json.isNull("birthDate")) {
                objProxy.realmSet$birthDate(null);
            } else {
                objProxy.realmSet$birthDate((String) json.getString("birthDate"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                objProxy.realmSet$address(null);
            } else {
                objProxy.realmSet$address((String) json.getString("address"));
            }
        }
        if (json.has("picture")) {
            if (json.isNull("picture")) {
                objProxy.realmSet$picture(null);
            } else {
                objProxy.realmSet$picture((String) json.getString("picture"));
            }
        }
        if (json.has("hobby")) {
            if (json.isNull("hobby")) {
                objProxy.realmSet$hobby(null);
            } else {
                objProxy.realmSet$hobby((String) json.getString("hobby"));
            }
        }
        if (json.has("city")) {
            if (json.isNull("city")) {
                objProxy.realmSet$city(null);
            } else {
                objProxy.realmSet$city((String) json.getString("city"));
            }
        }
        if (json.has("work")) {
            if (json.isNull("work")) {
                objProxy.realmSet$work(null);
            } else {
                objProxy.realmSet$work((String) json.getString("work"));
            }
        }
        if (json.has("whatsupNumber")) {
            if (json.isNull("whatsupNumber")) {
                objProxy.realmSet$whatsupNumber(null);
            } else {
                objProxy.realmSet$whatsupNumber((String) json.getString("whatsupNumber"));
            }
        }
        if (json.has("lineAccount")) {
            if (json.isNull("lineAccount")) {
                objProxy.realmSet$lineAccount(null);
            } else {
                objProxy.realmSet$lineAccount((String) json.getString("lineAccount"));
            }
        }
        if (json.has("pinBbm")) {
            if (json.isNull("pinBbm")) {
                objProxy.realmSet$pinBbm(null);
            } else {
                objProxy.realmSet$pinBbm((String) json.getString("pinBbm"));
            }
        }
        if (json.has("facebookAccount")) {
            if (json.isNull("facebookAccount")) {
                objProxy.realmSet$facebookAccount(null);
            } else {
                objProxy.realmSet$facebookAccount((String) json.getString("facebookAccount"));
            }
        }
        if (json.has("twitterAccount")) {
            if (json.isNull("twitterAccount")) {
                objProxy.realmSet$twitterAccount(null);
            } else {
                objProxy.realmSet$twitterAccount((String) json.getString("twitterAccount"));
            }
        }
        if (json.has("shirtSize")) {
            if (json.isNull("shirtSize")) {
                objProxy.realmSet$shirtSize(null);
            } else {
                objProxy.realmSet$shirtSize((String) json.getString("shirtSize"));
            }
        }
        if (json.has("group")) {
            if (json.isNull("group")) {
                objProxy.realmSet$group(null);
            } else {
                com.boardinglabs.rumahcemara.outreach.models.Group groupObj = com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("group"), update);
                objProxy.realmSet$group(groupObj);
            }
        }
        if (json.has("privacyConfig")) {
            if (json.isNull("privacyConfig")) {
                objProxy.realmSet$privacyConfig(null);
            } else {
                objProxy.realmSet$privacyConfig((String) json.getString("privacyConfig"));
            }
        }
        if (json.has("instagramAccount")) {
            if (json.isNull("instagramAccount")) {
                objProxy.realmSet$instagramAccount(null);
            } else {
                objProxy.realmSet$instagramAccount((String) json.getString("instagramAccount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.boardinglabs.rumahcemara.outreach.models.Profile createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.boardinglabs.rumahcemara.outreach.models.Profile obj = new com.boardinglabs.rumahcemara.outreach.models.Profile();
        final com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("userId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userId(null);
                }
            } else if (name.equals("groupId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$groupId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$groupId(null);
                }
            } else if (name.equals("fullname")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fullname((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fullname(null);
                }
            } else if (name.equals("phoneNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phoneNumber((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phoneNumber(null);
                }
            } else if (name.equals("birthPlace")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$birthPlace((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$birthPlace(null);
                }
            } else if (name.equals("birthDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$birthDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$birthDate(null);
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("address")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$address((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$address(null);
                }
            } else if (name.equals("picture")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$picture((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$picture(null);
                }
            } else if (name.equals("hobby")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$hobby((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$hobby(null);
                }
            } else if (name.equals("city")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$city((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$city(null);
                }
            } else if (name.equals("work")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$work((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$work(null);
                }
            } else if (name.equals("whatsupNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$whatsupNumber((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$whatsupNumber(null);
                }
            } else if (name.equals("lineAccount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lineAccount((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$lineAccount(null);
                }
            } else if (name.equals("pinBbm")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$pinBbm((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$pinBbm(null);
                }
            } else if (name.equals("facebookAccount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$facebookAccount((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$facebookAccount(null);
                }
            } else if (name.equals("twitterAccount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$twitterAccount((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$twitterAccount(null);
                }
            } else if (name.equals("shirtSize")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$shirtSize((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$shirtSize(null);
                }
            } else if (name.equals("group")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$group(null);
                } else {
                    com.boardinglabs.rumahcemara.outreach.models.Group groupObj = com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$group(groupObj);
                }
            } else if (name.equals("privacyConfig")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$privacyConfig((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$privacyConfig(null);
                }
            } else if (name.equals("instagramAccount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$instagramAccount((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$instagramAccount(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.Profile copyOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.Profile object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.boardinglabs.rumahcemara.outreach.models.Profile) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.Profile copy(Realm realm, com.boardinglabs.rumahcemara.outreach.models.Profile newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.boardinglabs.rumahcemara.outreach.models.Profile) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.boardinglabs.rumahcemara.outreach.models.Profile realmObject = realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.Profile.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface realmObjectSource = (com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) newObject;
        com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface realmObjectCopy = (com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$userId(realmObjectSource.realmGet$userId());
        realmObjectCopy.realmSet$groupId(realmObjectSource.realmGet$groupId());
        realmObjectCopy.realmSet$fullname(realmObjectSource.realmGet$fullname());
        realmObjectCopy.realmSet$phoneNumber(realmObjectSource.realmGet$phoneNumber());
        realmObjectCopy.realmSet$birthPlace(realmObjectSource.realmGet$birthPlace());
        realmObjectCopy.realmSet$birthDate(realmObjectSource.realmGet$birthDate());
        realmObjectCopy.realmSet$email(realmObjectSource.realmGet$email());
        realmObjectCopy.realmSet$address(realmObjectSource.realmGet$address());
        realmObjectCopy.realmSet$picture(realmObjectSource.realmGet$picture());
        realmObjectCopy.realmSet$hobby(realmObjectSource.realmGet$hobby());
        realmObjectCopy.realmSet$city(realmObjectSource.realmGet$city());
        realmObjectCopy.realmSet$work(realmObjectSource.realmGet$work());
        realmObjectCopy.realmSet$whatsupNumber(realmObjectSource.realmGet$whatsupNumber());
        realmObjectCopy.realmSet$lineAccount(realmObjectSource.realmGet$lineAccount());
        realmObjectCopy.realmSet$pinBbm(realmObjectSource.realmGet$pinBbm());
        realmObjectCopy.realmSet$facebookAccount(realmObjectSource.realmGet$facebookAccount());
        realmObjectCopy.realmSet$twitterAccount(realmObjectSource.realmGet$twitterAccount());
        realmObjectCopy.realmSet$shirtSize(realmObjectSource.realmGet$shirtSize());

        com.boardinglabs.rumahcemara.outreach.models.Group groupObj = realmObjectSource.realmGet$group();
        if (groupObj == null) {
            realmObjectCopy.realmSet$group(null);
        } else {
            com.boardinglabs.rumahcemara.outreach.models.Group cachegroup = (com.boardinglabs.rumahcemara.outreach.models.Group) cache.get(groupObj);
            if (cachegroup != null) {
                realmObjectCopy.realmSet$group(cachegroup);
            } else {
                realmObjectCopy.realmSet$group(com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.copyOrUpdate(realm, groupObj, update, cache));
            }
        }
        realmObjectCopy.realmSet$privacyConfig(realmObjectSource.realmGet$privacyConfig());
        realmObjectCopy.realmSet$instagramAccount(realmObjectSource.realmGet$instagramAccount());
        return realmObject;
    }

    public static long insert(Realm realm, com.boardinglabs.rumahcemara.outreach.models.Profile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.Profile.class);
        long tableNativePtr = table.getNativePtr();
        ProfileColumnInfo columnInfo = (ProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.Profile.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$userId = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
        }
        String realmGet$groupId = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$groupId();
        if (realmGet$groupId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.groupIdIndex, rowIndex, realmGet$groupId, false);
        }
        String realmGet$fullname = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$fullname();
        if (realmGet$fullname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
        }
        String realmGet$phoneNumber = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, realmGet$phoneNumber, false);
        }
        String realmGet$birthPlace = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$birthPlace();
        if (realmGet$birthPlace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthPlaceIndex, rowIndex, realmGet$birthPlace, false);
        }
        String realmGet$birthDate = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$birthDate();
        if (realmGet$birthDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthDateIndex, rowIndex, realmGet$birthDate, false);
        }
        String realmGet$email = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        }
        String realmGet$picture = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        }
        String realmGet$hobby = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$hobby();
        if (realmGet$hobby != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.hobbyIndex, rowIndex, realmGet$hobby, false);
        }
        String realmGet$city = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$city();
        if (realmGet$city != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
        }
        String realmGet$work = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$work();
        if (realmGet$work != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.workIndex, rowIndex, realmGet$work, false);
        }
        String realmGet$whatsupNumber = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$whatsupNumber();
        if (realmGet$whatsupNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.whatsupNumberIndex, rowIndex, realmGet$whatsupNumber, false);
        }
        String realmGet$lineAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$lineAccount();
        if (realmGet$lineAccount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lineAccountIndex, rowIndex, realmGet$lineAccount, false);
        }
        String realmGet$pinBbm = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$pinBbm();
        if (realmGet$pinBbm != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pinBbmIndex, rowIndex, realmGet$pinBbm, false);
        }
        String realmGet$facebookAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$facebookAccount();
        if (realmGet$facebookAccount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.facebookAccountIndex, rowIndex, realmGet$facebookAccount, false);
        }
        String realmGet$twitterAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$twitterAccount();
        if (realmGet$twitterAccount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.twitterAccountIndex, rowIndex, realmGet$twitterAccount, false);
        }
        String realmGet$shirtSize = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$shirtSize();
        if (realmGet$shirtSize != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.shirtSizeIndex, rowIndex, realmGet$shirtSize, false);
        }

        com.boardinglabs.rumahcemara.outreach.models.Group groupObj = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$group();
        if (groupObj != null) {
            Long cachegroup = cache.get(groupObj);
            if (cachegroup == null) {
                cachegroup = com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insert(realm, groupObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
        }
        String realmGet$privacyConfig = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$privacyConfig();
        if (realmGet$privacyConfig != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.privacyConfigIndex, rowIndex, realmGet$privacyConfig, false);
        }
        String realmGet$instagramAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$instagramAccount();
        if (realmGet$instagramAccount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instagramAccountIndex, rowIndex, realmGet$instagramAccount, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.Profile.class);
        long tableNativePtr = table.getNativePtr();
        ProfileColumnInfo columnInfo = (ProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.Profile.class);
        com.boardinglabs.rumahcemara.outreach.models.Profile object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.Profile) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$userId = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
            }
            String realmGet$groupId = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$groupId();
            if (realmGet$groupId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.groupIdIndex, rowIndex, realmGet$groupId, false);
            }
            String realmGet$fullname = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$fullname();
            if (realmGet$fullname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
            }
            String realmGet$phoneNumber = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, realmGet$phoneNumber, false);
            }
            String realmGet$birthPlace = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$birthPlace();
            if (realmGet$birthPlace != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthPlaceIndex, rowIndex, realmGet$birthPlace, false);
            }
            String realmGet$birthDate = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$birthDate();
            if (realmGet$birthDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthDateIndex, rowIndex, realmGet$birthDate, false);
            }
            String realmGet$email = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            }
            String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
            }
            String realmGet$picture = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            }
            String realmGet$hobby = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$hobby();
            if (realmGet$hobby != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.hobbyIndex, rowIndex, realmGet$hobby, false);
            }
            String realmGet$city = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$city();
            if (realmGet$city != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
            }
            String realmGet$work = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$work();
            if (realmGet$work != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.workIndex, rowIndex, realmGet$work, false);
            }
            String realmGet$whatsupNumber = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$whatsupNumber();
            if (realmGet$whatsupNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.whatsupNumberIndex, rowIndex, realmGet$whatsupNumber, false);
            }
            String realmGet$lineAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$lineAccount();
            if (realmGet$lineAccount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lineAccountIndex, rowIndex, realmGet$lineAccount, false);
            }
            String realmGet$pinBbm = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$pinBbm();
            if (realmGet$pinBbm != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pinBbmIndex, rowIndex, realmGet$pinBbm, false);
            }
            String realmGet$facebookAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$facebookAccount();
            if (realmGet$facebookAccount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.facebookAccountIndex, rowIndex, realmGet$facebookAccount, false);
            }
            String realmGet$twitterAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$twitterAccount();
            if (realmGet$twitterAccount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.twitterAccountIndex, rowIndex, realmGet$twitterAccount, false);
            }
            String realmGet$shirtSize = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$shirtSize();
            if (realmGet$shirtSize != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.shirtSizeIndex, rowIndex, realmGet$shirtSize, false);
            }

            com.boardinglabs.rumahcemara.outreach.models.Group groupObj = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$group();
            if (groupObj != null) {
                Long cachegroup = cache.get(groupObj);
                if (cachegroup == null) {
                    cachegroup = com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insert(realm, groupObj, cache);
                }
                table.setLink(columnInfo.groupIndex, rowIndex, cachegroup, false);
            }
            String realmGet$privacyConfig = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$privacyConfig();
            if (realmGet$privacyConfig != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.privacyConfigIndex, rowIndex, realmGet$privacyConfig, false);
            }
            String realmGet$instagramAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$instagramAccount();
            if (realmGet$instagramAccount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.instagramAccountIndex, rowIndex, realmGet$instagramAccount, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.Profile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.Profile.class);
        long tableNativePtr = table.getNativePtr();
        ProfileColumnInfo columnInfo = (ProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.Profile.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$userId = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIdIndex, rowIndex, false);
        }
        String realmGet$groupId = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$groupId();
        if (realmGet$groupId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.groupIdIndex, rowIndex, realmGet$groupId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.groupIdIndex, rowIndex, false);
        }
        String realmGet$fullname = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$fullname();
        if (realmGet$fullname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fullnameIndex, rowIndex, false);
        }
        String realmGet$phoneNumber = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, realmGet$phoneNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, false);
        }
        String realmGet$birthPlace = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$birthPlace();
        if (realmGet$birthPlace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthPlaceIndex, rowIndex, realmGet$birthPlace, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.birthPlaceIndex, rowIndex, false);
        }
        String realmGet$birthDate = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$birthDate();
        if (realmGet$birthDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthDateIndex, rowIndex, realmGet$birthDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.birthDateIndex, rowIndex, false);
        }
        String realmGet$email = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
        }
        String realmGet$picture = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
        }
        String realmGet$hobby = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$hobby();
        if (realmGet$hobby != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.hobbyIndex, rowIndex, realmGet$hobby, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.hobbyIndex, rowIndex, false);
        }
        String realmGet$city = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$city();
        if (realmGet$city != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cityIndex, rowIndex, false);
        }
        String realmGet$work = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$work();
        if (realmGet$work != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.workIndex, rowIndex, realmGet$work, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.workIndex, rowIndex, false);
        }
        String realmGet$whatsupNumber = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$whatsupNumber();
        if (realmGet$whatsupNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.whatsupNumberIndex, rowIndex, realmGet$whatsupNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.whatsupNumberIndex, rowIndex, false);
        }
        String realmGet$lineAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$lineAccount();
        if (realmGet$lineAccount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lineAccountIndex, rowIndex, realmGet$lineAccount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lineAccountIndex, rowIndex, false);
        }
        String realmGet$pinBbm = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$pinBbm();
        if (realmGet$pinBbm != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pinBbmIndex, rowIndex, realmGet$pinBbm, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pinBbmIndex, rowIndex, false);
        }
        String realmGet$facebookAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$facebookAccount();
        if (realmGet$facebookAccount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.facebookAccountIndex, rowIndex, realmGet$facebookAccount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.facebookAccountIndex, rowIndex, false);
        }
        String realmGet$twitterAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$twitterAccount();
        if (realmGet$twitterAccount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.twitterAccountIndex, rowIndex, realmGet$twitterAccount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.twitterAccountIndex, rowIndex, false);
        }
        String realmGet$shirtSize = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$shirtSize();
        if (realmGet$shirtSize != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.shirtSizeIndex, rowIndex, realmGet$shirtSize, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.shirtSizeIndex, rowIndex, false);
        }

        com.boardinglabs.rumahcemara.outreach.models.Group groupObj = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$group();
        if (groupObj != null) {
            Long cachegroup = cache.get(groupObj);
            if (cachegroup == null) {
                cachegroup = com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insertOrUpdate(realm, groupObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.groupIndex, rowIndex);
        }
        String realmGet$privacyConfig = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$privacyConfig();
        if (realmGet$privacyConfig != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.privacyConfigIndex, rowIndex, realmGet$privacyConfig, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.privacyConfigIndex, rowIndex, false);
        }
        String realmGet$instagramAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$instagramAccount();
        if (realmGet$instagramAccount != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.instagramAccountIndex, rowIndex, realmGet$instagramAccount, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.instagramAccountIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.Profile.class);
        long tableNativePtr = table.getNativePtr();
        ProfileColumnInfo columnInfo = (ProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.Profile.class);
        com.boardinglabs.rumahcemara.outreach.models.Profile object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.Profile) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$userId = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$userId();
            if (realmGet$userId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userIdIndex, rowIndex, false);
            }
            String realmGet$groupId = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$groupId();
            if (realmGet$groupId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.groupIdIndex, rowIndex, realmGet$groupId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.groupIdIndex, rowIndex, false);
            }
            String realmGet$fullname = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$fullname();
            if (realmGet$fullname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fullnameIndex, rowIndex, realmGet$fullname, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fullnameIndex, rowIndex, false);
            }
            String realmGet$phoneNumber = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, realmGet$phoneNumber, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberIndex, rowIndex, false);
            }
            String realmGet$birthPlace = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$birthPlace();
            if (realmGet$birthPlace != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthPlaceIndex, rowIndex, realmGet$birthPlace, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.birthPlaceIndex, rowIndex, false);
            }
            String realmGet$birthDate = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$birthDate();
            if (realmGet$birthDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthDateIndex, rowIndex, realmGet$birthDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.birthDateIndex, rowIndex, false);
            }
            String realmGet$email = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
            }
            String realmGet$address = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
            }
            String realmGet$picture = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
            }
            String realmGet$hobby = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$hobby();
            if (realmGet$hobby != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.hobbyIndex, rowIndex, realmGet$hobby, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.hobbyIndex, rowIndex, false);
            }
            String realmGet$city = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$city();
            if (realmGet$city != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.cityIndex, rowIndex, false);
            }
            String realmGet$work = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$work();
            if (realmGet$work != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.workIndex, rowIndex, realmGet$work, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.workIndex, rowIndex, false);
            }
            String realmGet$whatsupNumber = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$whatsupNumber();
            if (realmGet$whatsupNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.whatsupNumberIndex, rowIndex, realmGet$whatsupNumber, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.whatsupNumberIndex, rowIndex, false);
            }
            String realmGet$lineAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$lineAccount();
            if (realmGet$lineAccount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lineAccountIndex, rowIndex, realmGet$lineAccount, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lineAccountIndex, rowIndex, false);
            }
            String realmGet$pinBbm = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$pinBbm();
            if (realmGet$pinBbm != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pinBbmIndex, rowIndex, realmGet$pinBbm, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.pinBbmIndex, rowIndex, false);
            }
            String realmGet$facebookAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$facebookAccount();
            if (realmGet$facebookAccount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.facebookAccountIndex, rowIndex, realmGet$facebookAccount, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.facebookAccountIndex, rowIndex, false);
            }
            String realmGet$twitterAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$twitterAccount();
            if (realmGet$twitterAccount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.twitterAccountIndex, rowIndex, realmGet$twitterAccount, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.twitterAccountIndex, rowIndex, false);
            }
            String realmGet$shirtSize = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$shirtSize();
            if (realmGet$shirtSize != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.shirtSizeIndex, rowIndex, realmGet$shirtSize, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.shirtSizeIndex, rowIndex, false);
            }

            com.boardinglabs.rumahcemara.outreach.models.Group groupObj = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$group();
            if (groupObj != null) {
                Long cachegroup = cache.get(groupObj);
                if (cachegroup == null) {
                    cachegroup = com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.insertOrUpdate(realm, groupObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.groupIndex, rowIndex, cachegroup, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.groupIndex, rowIndex);
            }
            String realmGet$privacyConfig = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$privacyConfig();
            if (realmGet$privacyConfig != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.privacyConfigIndex, rowIndex, realmGet$privacyConfig, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.privacyConfigIndex, rowIndex, false);
            }
            String realmGet$instagramAccount = ((com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) object).realmGet$instagramAccount();
            if (realmGet$instagramAccount != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.instagramAccountIndex, rowIndex, realmGet$instagramAccount, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.instagramAccountIndex, rowIndex, false);
            }
        }
    }

    public static com.boardinglabs.rumahcemara.outreach.models.Profile createDetachedCopy(com.boardinglabs.rumahcemara.outreach.models.Profile realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.boardinglabs.rumahcemara.outreach.models.Profile unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.boardinglabs.rumahcemara.outreach.models.Profile();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.boardinglabs.rumahcemara.outreach.models.Profile) cachedObject.object;
            }
            unmanagedObject = (com.boardinglabs.rumahcemara.outreach.models.Profile) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface unmanagedCopy = (com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) unmanagedObject;
        com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface realmSource = (com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$userId(realmSource.realmGet$userId());
        unmanagedCopy.realmSet$groupId(realmSource.realmGet$groupId());
        unmanagedCopy.realmSet$fullname(realmSource.realmGet$fullname());
        unmanagedCopy.realmSet$phoneNumber(realmSource.realmGet$phoneNumber());
        unmanagedCopy.realmSet$birthPlace(realmSource.realmGet$birthPlace());
        unmanagedCopy.realmSet$birthDate(realmSource.realmGet$birthDate());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$address(realmSource.realmGet$address());
        unmanagedCopy.realmSet$picture(realmSource.realmGet$picture());
        unmanagedCopy.realmSet$hobby(realmSource.realmGet$hobby());
        unmanagedCopy.realmSet$city(realmSource.realmGet$city());
        unmanagedCopy.realmSet$work(realmSource.realmGet$work());
        unmanagedCopy.realmSet$whatsupNumber(realmSource.realmGet$whatsupNumber());
        unmanagedCopy.realmSet$lineAccount(realmSource.realmGet$lineAccount());
        unmanagedCopy.realmSet$pinBbm(realmSource.realmGet$pinBbm());
        unmanagedCopy.realmSet$facebookAccount(realmSource.realmGet$facebookAccount());
        unmanagedCopy.realmSet$twitterAccount(realmSource.realmGet$twitterAccount());
        unmanagedCopy.realmSet$shirtSize(realmSource.realmGet$shirtSize());

        // Deep copy of group
        unmanagedCopy.realmSet$group(com_boardinglabs_rumahcemara_outreach_models_GroupRealmProxy.createDetachedCopy(realmSource.realmGet$group(), currentDepth + 1, maxDepth, cache));
        unmanagedCopy.realmSet$privacyConfig(realmSource.realmGet$privacyConfig());
        unmanagedCopy.realmSet$instagramAccount(realmSource.realmGet$instagramAccount());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Profile = proxy[");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId() != null ? realmGet$userId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{groupId:");
        stringBuilder.append(realmGet$groupId() != null ? realmGet$groupId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fullname:");
        stringBuilder.append(realmGet$fullname() != null ? realmGet$fullname() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phoneNumber:");
        stringBuilder.append(realmGet$phoneNumber() != null ? realmGet$phoneNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{birthPlace:");
        stringBuilder.append(realmGet$birthPlace() != null ? realmGet$birthPlace() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{birthDate:");
        stringBuilder.append(realmGet$birthDate() != null ? realmGet$birthDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{picture:");
        stringBuilder.append(realmGet$picture() != null ? realmGet$picture() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hobby:");
        stringBuilder.append(realmGet$hobby() != null ? realmGet$hobby() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{city:");
        stringBuilder.append(realmGet$city() != null ? realmGet$city() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{work:");
        stringBuilder.append(realmGet$work() != null ? realmGet$work() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{whatsupNumber:");
        stringBuilder.append(realmGet$whatsupNumber() != null ? realmGet$whatsupNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lineAccount:");
        stringBuilder.append(realmGet$lineAccount() != null ? realmGet$lineAccount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pinBbm:");
        stringBuilder.append(realmGet$pinBbm() != null ? realmGet$pinBbm() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{facebookAccount:");
        stringBuilder.append(realmGet$facebookAccount() != null ? realmGet$facebookAccount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{twitterAccount:");
        stringBuilder.append(realmGet$twitterAccount() != null ? realmGet$twitterAccount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{shirtSize:");
        stringBuilder.append(realmGet$shirtSize() != null ? realmGet$shirtSize() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{group:");
        stringBuilder.append(realmGet$group() != null ? "Group" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{privacyConfig:");
        stringBuilder.append(realmGet$privacyConfig() != null ? realmGet$privacyConfig() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{instagramAccount:");
        stringBuilder.append(realmGet$instagramAccount() != null ? realmGet$instagramAccount() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy aProfile = (com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProfile.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProfile.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProfile.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
