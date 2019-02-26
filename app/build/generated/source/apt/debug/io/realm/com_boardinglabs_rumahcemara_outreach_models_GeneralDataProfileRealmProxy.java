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
public class com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy extends com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile
    implements RealmObjectProxy, com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface {

    static final class GeneralDataProfileColumnInfo extends ColumnInfo {
        long idIndex;
        long roleIdIndex;
        long usernameIndex;
        long statusIndex;
        long createdAtIndex;
        long updateAtIndex;
        long deletedAtIndex;
        long profileIndex;

        GeneralDataProfileColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("GeneralDataProfile");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.roleIdIndex = addColumnDetails("roleId", "roleId", objectSchemaInfo);
            this.usernameIndex = addColumnDetails("username", "username", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", "status", objectSchemaInfo);
            this.createdAtIndex = addColumnDetails("createdAt", "createdAt", objectSchemaInfo);
            this.updateAtIndex = addColumnDetails("updateAt", "updateAt", objectSchemaInfo);
            this.deletedAtIndex = addColumnDetails("deletedAt", "deletedAt", objectSchemaInfo);
            this.profileIndex = addColumnDetails("profile", "profile", objectSchemaInfo);
        }

        GeneralDataProfileColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GeneralDataProfileColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GeneralDataProfileColumnInfo src = (GeneralDataProfileColumnInfo) rawSrc;
            final GeneralDataProfileColumnInfo dst = (GeneralDataProfileColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.roleIdIndex = src.roleIdIndex;
            dst.usernameIndex = src.usernameIndex;
            dst.statusIndex = src.statusIndex;
            dst.createdAtIndex = src.createdAtIndex;
            dst.updateAtIndex = src.updateAtIndex;
            dst.deletedAtIndex = src.deletedAtIndex;
            dst.profileIndex = src.profileIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private GeneralDataProfileColumnInfo columnInfo;
    private ProxyState<com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile> proxyState;

    com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GeneralDataProfileColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$roleId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.roleIdIndex);
    }

    @Override
    public void realmSet$roleId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.roleIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.roleIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.roleIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.roleIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$username() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.usernameIndex);
    }

    @Override
    public void realmSet$username(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.usernameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.usernameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.usernameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.usernameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$createdAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.createdAtIndex);
    }

    @Override
    public void realmSet$createdAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.createdAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.createdAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$updateAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.updateAtIndex);
    }

    @Override
    public void realmSet$updateAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.updateAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.updateAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.updateAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.updateAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$deletedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.deletedAtIndex);
    }

    @Override
    public void realmSet$deletedAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.deletedAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.deletedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.deletedAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.deletedAtIndex, value);
    }

    @Override
    public com.boardinglabs.rumahcemara.outreach.models.Profile realmGet$profile() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.profileIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.boardinglabs.rumahcemara.outreach.models.Profile.class, proxyState.getRow$realm().getLink(columnInfo.profileIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$profile(com.boardinglabs.rumahcemara.outreach.models.Profile value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("profile")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.profileIndex);
                return;
            }
            proxyState.checkValidObject(value);
            row.getTable().setLink(columnInfo.profileIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.profileIndex);
            return;
        }
        proxyState.checkValidObject(value);
        proxyState.getRow$realm().setLink(columnInfo.profileIndex, ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex());
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("GeneralDataProfile", 8, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("roleId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("username", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("createdAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("updateAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("deletedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("profile", RealmFieldType.OBJECT, "Profile");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GeneralDataProfileColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GeneralDataProfileColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "GeneralDataProfile";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "GeneralDataProfile";
    }

    @SuppressWarnings("cast")
    public static com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("profile")) {
            excludeFields.add("profile");
        }
        com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile obj = realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class, true, excludeFields);

        final com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("roleId")) {
            if (json.isNull("roleId")) {
                objProxy.realmSet$roleId(null);
            } else {
                objProxy.realmSet$roleId((String) json.getString("roleId"));
            }
        }
        if (json.has("username")) {
            if (json.isNull("username")) {
                objProxy.realmSet$username(null);
            } else {
                objProxy.realmSet$username((String) json.getString("username"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("createdAt")) {
            if (json.isNull("createdAt")) {
                objProxy.realmSet$createdAt(null);
            } else {
                objProxy.realmSet$createdAt((String) json.getString("createdAt"));
            }
        }
        if (json.has("updateAt")) {
            if (json.isNull("updateAt")) {
                objProxy.realmSet$updateAt(null);
            } else {
                objProxy.realmSet$updateAt((String) json.getString("updateAt"));
            }
        }
        if (json.has("deletedAt")) {
            if (json.isNull("deletedAt")) {
                objProxy.realmSet$deletedAt(null);
            } else {
                objProxy.realmSet$deletedAt((String) json.getString("deletedAt"));
            }
        }
        if (json.has("profile")) {
            if (json.isNull("profile")) {
                objProxy.realmSet$profile(null);
            } else {
                com.boardinglabs.rumahcemara.outreach.models.Profile profileObj = com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("profile"), update);
                objProxy.realmSet$profile(profileObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile obj = new com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile();
        final com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface objProxy = (com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("roleId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$roleId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$roleId(null);
                }
            } else if (name.equals("username")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$username((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$username(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("createdAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$createdAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$createdAt(null);
                }
            } else if (name.equals("updateAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$updateAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$updateAt(null);
                }
            } else if (name.equals("deletedAt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$deletedAt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$deletedAt(null);
                }
            } else if (name.equals("profile")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$profile(null);
                } else {
                    com.boardinglabs.rumahcemara.outreach.models.Profile profileObj = com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.createUsingJsonStream(realm, reader);
                    objProxy.realmSet$profile(profileObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile copyOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile copy(Realm realm, com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile realmObject = realm.createObjectInternal(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface realmObjectSource = (com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) newObject;
        com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface realmObjectCopy = (com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        realmObjectCopy.realmSet$roleId(realmObjectSource.realmGet$roleId());
        realmObjectCopy.realmSet$username(realmObjectSource.realmGet$username());
        realmObjectCopy.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectCopy.realmSet$createdAt(realmObjectSource.realmGet$createdAt());
        realmObjectCopy.realmSet$updateAt(realmObjectSource.realmGet$updateAt());
        realmObjectCopy.realmSet$deletedAt(realmObjectSource.realmGet$deletedAt());

        com.boardinglabs.rumahcemara.outreach.models.Profile profileObj = realmObjectSource.realmGet$profile();
        if (profileObj == null) {
            realmObjectCopy.realmSet$profile(null);
        } else {
            com.boardinglabs.rumahcemara.outreach.models.Profile cacheprofile = (com.boardinglabs.rumahcemara.outreach.models.Profile) cache.get(profileObj);
            if (cacheprofile != null) {
                realmObjectCopy.realmSet$profile(cacheprofile);
            } else {
                realmObjectCopy.realmSet$profile(com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.copyOrUpdate(realm, profileObj, update, cache));
            }
        }
        return realmObject;
    }

    public static long insert(Realm realm, com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class);
        long tableNativePtr = table.getNativePtr();
        GeneralDataProfileColumnInfo columnInfo = (GeneralDataProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$roleId = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$roleId();
        if (realmGet$roleId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.roleIdIndex, rowIndex, realmGet$roleId, false);
        }
        String realmGet$username = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        }
        String realmGet$status = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$createdAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        }
        String realmGet$updateAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$updateAt();
        if (realmGet$updateAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updateAtIndex, rowIndex, realmGet$updateAt, false);
        }
        String realmGet$deletedAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        }

        com.boardinglabs.rumahcemara.outreach.models.Profile profileObj = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$profile();
        if (profileObj != null) {
            Long cacheprofile = cache.get(profileObj);
            if (cacheprofile == null) {
                cacheprofile = com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insert(realm, profileObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.profileIndex, rowIndex, cacheprofile, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class);
        long tableNativePtr = table.getNativePtr();
        GeneralDataProfileColumnInfo columnInfo = (GeneralDataProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class);
        com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            String realmGet$roleId = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$roleId();
            if (realmGet$roleId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.roleIdIndex, rowIndex, realmGet$roleId, false);
            }
            String realmGet$username = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            }
            String realmGet$status = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            }
            String realmGet$createdAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            }
            String realmGet$updateAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$updateAt();
            if (realmGet$updateAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updateAtIndex, rowIndex, realmGet$updateAt, false);
            }
            String realmGet$deletedAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$deletedAt();
            if (realmGet$deletedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
            }

            com.boardinglabs.rumahcemara.outreach.models.Profile profileObj = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$profile();
            if (profileObj != null) {
                Long cacheprofile = cache.get(profileObj);
                if (cacheprofile == null) {
                    cacheprofile = com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insert(realm, profileObj, cache);
                }
                table.setLink(columnInfo.profileIndex, rowIndex, cacheprofile, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class);
        long tableNativePtr = table.getNativePtr();
        GeneralDataProfileColumnInfo columnInfo = (GeneralDataProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$roleId = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$roleId();
        if (realmGet$roleId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.roleIdIndex, rowIndex, realmGet$roleId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.roleIdIndex, rowIndex, false);
        }
        String realmGet$username = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
        }
        String realmGet$status = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$createdAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
        }
        String realmGet$updateAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$updateAt();
        if (realmGet$updateAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updateAtIndex, rowIndex, realmGet$updateAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updateAtIndex, rowIndex, false);
        }
        String realmGet$deletedAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
        }

        com.boardinglabs.rumahcemara.outreach.models.Profile profileObj = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$profile();
        if (profileObj != null) {
            Long cacheprofile = cache.get(profileObj);
            if (cacheprofile == null) {
                cacheprofile = com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insertOrUpdate(realm, profileObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.profileIndex, rowIndex, cacheprofile, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.profileIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class);
        long tableNativePtr = table.getNativePtr();
        GeneralDataProfileColumnInfo columnInfo = (GeneralDataProfileColumnInfo) realm.getSchema().getColumnInfo(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile.class);
        com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile object = null;
        while (objects.hasNext()) {
            object = (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$roleId = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$roleId();
            if (realmGet$roleId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.roleIdIndex, rowIndex, realmGet$roleId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.roleIdIndex, rowIndex, false);
            }
            String realmGet$username = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
            }
            String realmGet$status = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
            }
            String realmGet$createdAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$createdAt();
            if (realmGet$createdAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
            }
            String realmGet$updateAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$updateAt();
            if (realmGet$updateAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.updateAtIndex, rowIndex, realmGet$updateAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.updateAtIndex, rowIndex, false);
            }
            String realmGet$deletedAt = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$deletedAt();
            if (realmGet$deletedAt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
            }

            com.boardinglabs.rumahcemara.outreach.models.Profile profileObj = ((com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) object).realmGet$profile();
            if (profileObj != null) {
                Long cacheprofile = cache.get(profileObj);
                if (cacheprofile == null) {
                    cacheprofile = com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.insertOrUpdate(realm, profileObj, cache);
                }
                Table.nativeSetLink(tableNativePtr, columnInfo.profileIndex, rowIndex, cacheprofile, false);
            } else {
                Table.nativeNullifyLink(tableNativePtr, columnInfo.profileIndex, rowIndex);
            }
        }
    }

    public static com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile createDetachedCopy(com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) cachedObject.object;
            }
            unmanagedObject = (com.boardinglabs.rumahcemara.outreach.models.GeneralDataProfile) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface unmanagedCopy = (com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) unmanagedObject;
        com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface realmSource = (com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$roleId(realmSource.realmGet$roleId());
        unmanagedCopy.realmSet$username(realmSource.realmGet$username());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$createdAt(realmSource.realmGet$createdAt());
        unmanagedCopy.realmSet$updateAt(realmSource.realmGet$updateAt());
        unmanagedCopy.realmSet$deletedAt(realmSource.realmGet$deletedAt());

        // Deep copy of profile
        unmanagedCopy.realmSet$profile(com_boardinglabs_rumahcemara_outreach_models_ProfileRealmProxy.createDetachedCopy(realmSource.realmGet$profile(), currentDepth + 1, maxDepth, cache));

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GeneralDataProfile = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{roleId:");
        stringBuilder.append(realmGet$roleId() != null ? realmGet$roleId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{username:");
        stringBuilder.append(realmGet$username() != null ? realmGet$username() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdAt:");
        stringBuilder.append(realmGet$createdAt() != null ? realmGet$createdAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updateAt:");
        stringBuilder.append(realmGet$updateAt() != null ? realmGet$updateAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{deletedAt:");
        stringBuilder.append(realmGet$deletedAt() != null ? realmGet$deletedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profile:");
        stringBuilder.append(realmGet$profile() != null ? "Profile" : "null");
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
        com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy aGeneralDataProfile = (com_boardinglabs_rumahcemara_outreach_models_GeneralDataProfileRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGeneralDataProfile.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGeneralDataProfile.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGeneralDataProfile.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
